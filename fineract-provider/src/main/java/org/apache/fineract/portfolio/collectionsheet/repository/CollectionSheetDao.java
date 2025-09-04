/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.portfolio.collectionsheet.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.fineract.infrastructure.core.domain.JdbcSupport;
import org.apache.fineract.infrastructure.core.service.DateUtils;
import org.apache.fineract.infrastructure.core.service.database.DatabaseSpecificSQLGenerator;
import org.apache.fineract.organisation.monetary.data.CurrencyData;
import org.apache.fineract.portfolio.collectionsheet.data.IndividualClientData;
import org.apache.fineract.portfolio.collectionsheet.data.IndividualCollectionSheetLoanFlatData;
import org.apache.fineract.portfolio.collectionsheet.data.SavingsDueData;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CollectionSheetDao {

    private final DatabaseSpecificSQLGenerator sqlGenerator;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<IndividualCollectionSheetLoanFlatData> getIndividualCollectionSheetFlatDataList(LocalDate transactionDate,
            String officeHierarchy, Long officeId, Long staffId) {
        final boolean checkForOfficeId = officeId != null;
        final boolean checkForStaffId = staffId != null;
        final String transactionDateStr = DateUtils.DEFAULT_DATE_FORMATTER.format(transactionDate);

        final StringBuilder sqlString = getIndividualCollectionSheetFlatDataSql(checkForOfficeId, checkForStaffId);

        final SqlParameterSource namedParameters = getNamedParameters(transactionDateStr, officeHierarchy, officeId, staffId);

        return this.namedParameterJdbcTemplate.query(sqlString.toString(), namedParameters, rowMapper());
    }

    private SqlParameterSource getNamedParameters(String transactionDateStr, String officeHierarchy, Long officeId, Long staffId) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("dueDate", transactionDateStr)
                .addValue("officeHierarchy", officeHierarchy);

        final boolean checkForOfficeId = officeId != null;
        final boolean checkForStaffId = staffId != null;

        if (checkForOfficeId) {
            ((MapSqlParameterSource) namedParameters).addValue("officeId", officeId);
        }
        if (checkForStaffId) {
            ((MapSqlParameterSource) namedParameters).addValue("staffId", staffId);
        }
        return namedParameters;
    }

    private StringBuilder getIndividualCollectionSheetFlatDataSql(final boolean checkForOfficeId, final boolean checkforStaffId) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT loandata.*, sum(lc.amount_outstanding_derived) as chargesDue ");
        sb.append("from (SELECT cl.display_name As clientName, ");
        sb.append("cl.id As clientId, ln.id As loanId, ln.account_no As accountId, ln.loan_status_id As accountStatusId,");
        sb.append(" pl.short_name As productShortName, ln.product_id As productId, ");
        sb.append("ln.currency_code as currencyCode, ln.currency_digits as currencyDigits, ln.currency_multiplesof as inMultiplesOf, ");
        sb.append("rc." + sqlGenerator.escape("name")
                + " as currencyName, rc.display_symbol as currencyDisplaySymbol, rc.internationalized_name_code as currencyNameCode, ");
        sb.append("(CASE WHEN ln.loan_status_id = 200 THEN ln.principal_amount ELSE null END) As disbursementAmount, ");
        sb.append(
                "sum(COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls.principal_amount ELSE 0.0 END), 0.0) - COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls.principal_completed_derived ELSE 0.0 END), 0.0)) As principalDue, ");
        sb.append("ln.principal_repaid_derived As principalPaid, ");
        sb.append(
                "sum(COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls.interest_amount ELSE 0.0 END), 0.0) - COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls.interest_completed_derived ELSE 0.0 END), 0.0)) As interestDue, ");
        sb.append("ln.interest_repaid_derived As interestPaid, ");
        sb.append(
                "sum(COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls.fee_charges_amount ELSE 0.0 END), 0.0) - COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls.fee_charges_completed_derived ELSE 0.0 END), 0.0)) As feeDue, ");
        sb.append("ln.fee_charges_repaid_derived As feePaid ");
        sb.append("FROM m_loan ln ");
        sb.append("JOIN m_client cl ON cl.id = ln.client_id  ");
        sb.append("LEFT JOIN m_office ofc ON ofc.id = cl.office_id  AND ofc.hierarchy like " + ":officeHierarchy ");
        sb.append("LEFT JOIN m_product_loan pl ON pl.id = ln.product_id ");
        sb.append("LEFT JOIN m_currency rc on rc." + sqlGenerator.escape("code") + " = ln.currency_code ");
        sb.append("JOIN m_loan_repayment_schedule ls ON ls.loan_id = ln.id AND ls.completed_derived = 0 AND ls.duedate <= :dueDate ");
        sb.append("where ");
        if (checkForOfficeId) {
            sb.append("ofc.id = :officeId and ");
        }
        if (checkforStaffId) {
            sb.append("ln.loan_officer_id = :staffId and ");
        }
        sb.append("(ln.loan_status_id = 300) ");
        sb.append("and ln.group_id is null GROUP BY cl.id , ln.id ORDER BY cl.id , ln.id ) loandata ");
        sb.append(
                "LEFT JOIN m_loan_charge lc ON lc.loan_id = loandata.loanId AND lc.is_paid_derived = false AND lc.is_active = true AND ( lc.due_for_collection_as_of_date  <= :dueDate OR lc.charge_time_enum = 1) ");
        sb.append("GROUP BY loandata.clientId, loandata.loanId ORDER BY loandata.clientId, loandata.loanId ");

        return sb;
    }

    private RowMapper<IndividualCollectionSheetLoanFlatData> rowMapper() {
        return (rs, rowNum) -> {
            final String clientName = rs.getString("clientName");
            final Long clientId = JdbcSupport.getLong(rs, "clientId");
            final Long loanId = JdbcSupport.getLong(rs, "loanId");
            final String accountId = rs.getString("accountId");
            final Integer accountStatusId = JdbcSupport.getInteger(rs, "accountStatusId");
            final String productShortName = rs.getString("productShortName");
            final Long productId = JdbcSupport.getLong(rs, "productId");
            final String currencyCode = rs.getString("currencyCode");
            final String currencyName = rs.getString("currencyName");
            final String currencyNameCode = rs.getString("currencyNameCode");
            final String currencyDisplaySymbol = rs.getString("currencyDisplaySymbol");
            final Integer currencyDigits = JdbcSupport.getInteger(rs, "currencyDigits");
            final Integer inMultiplesOf = JdbcSupport.getInteger(rs, "inMultiplesOf");

            CurrencyData currencyData = null;
            if (currencyCode != null) {
                currencyData = new CurrencyData(currencyCode, currencyName, currencyDigits, inMultiplesOf, currencyDisplaySymbol,
                        currencyNameCode);
            }

            final BigDecimal disbursementAmount = rs.getBigDecimal("disbursementAmount");
            final BigDecimal principalDue = rs.getBigDecimal("principalDue");
            final BigDecimal principalPaid = rs.getBigDecimal("principalPaid");
            final BigDecimal interestDue = rs.getBigDecimal("interestDue");
            final BigDecimal interestPaid = rs.getBigDecimal("interestPaid");
            final BigDecimal chargesDue = rs.getBigDecimal("chargesDue");
            final BigDecimal feeDue = rs.getBigDecimal("feeDue");
            final BigDecimal feePaid = rs.getBigDecimal("feePaid");

            return new IndividualCollectionSheetLoanFlatData(clientName, clientId, loanId, accountId, accountStatusId, productShortName,
                    productId, currencyData, disbursementAmount, principalDue, principalPaid, interestDue, interestPaid, chargesDue, feeDue,
                    feePaid);
        };
    }

    public List<IndividualClientData> getIndividualClientData(String transactionDateStr, String officeHierarchy, Long officeId,
            Long staffId) {
        final boolean checkForOfficeId = officeId != null;
        final boolean checkForStaffId = staffId != null;

        final StringBuilder sqlString = getIndividualClientDataSql(checkForOfficeId, checkForStaffId);

        final SqlParameterSource namedParameters = getNamedParameters(transactionDateStr, officeHierarchy, officeId, staffId);

        return this.namedParameterJdbcTemplate.query(sqlString.toString(), namedParameters, individualClientDataExtractor());
    }

    private StringBuilder getIndividualClientDataSql(final boolean checkForOfficeId, final boolean checkForStaffId) {
        final StringBuilder sb = new StringBuilder(400);

        sb.append(
                "SELECT (CASE WHEN sa.deposit_type_enum=100 THEN 'Saving Deposit' ELSE (CASE WHEN sa.deposit_type_enum=300 THEN 'Recurring Deposit' ELSE 'Current Deposit' END) END) as depositAccountType, cl.display_name As clientName, cl.id As clientId, ");
        sb.append("sa.id As savingsId, sa.account_no As accountId, sa.status_enum As accountStatusId, ");
        sb.append("sp.short_name As productShortName, sp.id As productId, ");
        sb.append("sa.currency_code as currencyCode, sa.currency_digits as currencyDigits, sa.currency_multiplesof as inMultiplesOf, ");
        sb.append("rc." + sqlGenerator.escape("name")
                + " as currencyName, rc.display_symbol as currencyDisplaySymbol, rc.internationalized_name_code as currencyNameCode, ");
        sb.append("SUM(COALESCE(mss.deposit_amount,0) - coalesce(mss.deposit_amount_completed_derived,0)) as dueAmount ");
        sb.append("FROM m_savings_account sa ");
        sb.append("JOIN m_client cl ON cl.id = sa.client_id ");
        sb.append("JOIN m_savings_product sp ON sa.product_id=sp.id ");
        sb.append(
                "LEFT JOIN m_deposit_account_recurring_detail dard ON sa.id = dard.savings_account_id AND dard.is_mandatory = true AND dard.is_calendar_inherited = false ");
        sb.append(
                "LEFT JOIN m_mandatory_savings_schedule mss ON mss.savings_account_id=sa.id AND mss.completed_derived = 0 AND mss.duedate <= :dueDate ");
        sb.append("LEFT JOIN m_office ofc ON ofc.id = cl.office_id AND ofc.hierarchy like " + ":officeHierarchy ");
        sb.append("LEFT JOIN m_currency rc on rc." + sqlGenerator.escape("code") + " = sa.currency_code ");
        sb.append("WHERE sa.status_enum=300 and sa.group_id is null and sa.deposit_type_enum in (100,300,400) ");
        sb.append("and (cl.status_enum = 300 or (cl.status_enum = 600 and cl.closedon_date >= :dueDate)) ");
        if (checkForOfficeId) {
            sb.append("and ofc.id = :officeId ");
        }
        if (checkForStaffId) {
            sb.append("and sa.field_officer_id = :staffId ");
        }
        sb.append("GROUP BY cl.id, sa.id ORDER BY cl.id, sa.id ");

        return sb;
    }

    private ResultSetExtractor<List<IndividualClientData>> individualClientDataExtractor() {
        return rs -> {
            List<IndividualClientData> clientData = new ArrayList<>();
            int rowNum = 0;

            IndividualClientData client = null;
            Long previousClientId = null;

            while (rs.next()) {
                final Long clientId = JdbcSupport.getLong(rs, "clientId");

                // if we encounter a new client, create a fresh IndividualClientData
                if (previousClientId == null || !clientId.equals(previousClientId)) {
                    final String clientName = rs.getString("clientName");

                    client = IndividualClientData.instance(clientId, clientName);
                    client = IndividualClientData.withSavings(client, new ArrayList<SavingsDueData>());

                    clientData.add(client);
                    previousClientId = clientId;
                }

                // map savings for this row and attach to current client
                SavingsDueData saving = savingsDueDataRowMapper().mapRow(rs, rowNum);
                client.addSavings(saving);

                rowNum++;
            }

            return clientData;
        };
    }

    private RowMapper<SavingsDueData> savingsDueDataRowMapper() {
        return (rs, rowNum) -> {
            final Long savingsId = rs.getLong("savingsId");
            final String accountId = rs.getString("accountId");
            final Integer accountStatusId = JdbcSupport.getInteger(rs, "accountStatusId");
            final String productName = rs.getString("productShortName");
            final Long productId = rs.getLong("productId");
            final BigDecimal dueAmount = rs.getBigDecimal("dueAmount");

            final String currencyCode = rs.getString("currencyCode");
            final String currencyName = rs.getString("currencyName");
            final String currencyNameCode = rs.getString("currencyNameCode");
            final String currencyDisplaySymbol = rs.getString("currencyDisplaySymbol");
            final Integer currencyDigits = JdbcSupport.getInteger(rs, "currencyDigits");
            final Integer inMultiplesOf = JdbcSupport.getInteger(rs, "inMultiplesOf");

            final String depositAccountType = rs.getString("depositAccountType");

            // build CurrencyData
            final CurrencyData currency = new CurrencyData(currencyCode, currencyName, currencyDigits, inMultiplesOf, currencyDisplaySymbol,
                    currencyNameCode);

            return SavingsDueData.instance(savingsId, accountId, accountStatusId, productName, productId, currency, dueAmount,
                    depositAccountType);
        };
    }
}
