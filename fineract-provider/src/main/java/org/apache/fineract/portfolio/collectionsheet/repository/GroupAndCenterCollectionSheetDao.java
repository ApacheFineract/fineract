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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.fineract.infrastructure.core.data.EnumOptionData;
import org.apache.fineract.infrastructure.core.domain.JdbcSupport;
import org.apache.fineract.infrastructure.core.service.DateUtils;
import org.apache.fineract.infrastructure.core.service.database.DatabaseSpecificSQLGenerator;
import org.apache.fineract.organisation.monetary.data.CurrencyData;
import org.apache.fineract.portfolio.calendar.domain.CalendarEntityType;
import org.apache.fineract.portfolio.collectionsheet.data.JLGClientData;
import org.apache.fineract.portfolio.collectionsheet.data.JLGCollectionSheetFlatData;
import org.apache.fineract.portfolio.collectionsheet.data.JLGGroupData;
import org.apache.fineract.portfolio.collectionsheet.data.SavingsDueData;
import org.apache.fineract.portfolio.group.data.CenterData;
import org.apache.fineract.portfolio.group.data.GroupGeneralData;
import org.apache.fineract.portfolio.meeting.attendance.service.AttendanceEnumerations;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GroupAndCenterCollectionSheetDao {

    private final DatabaseSpecificSQLGenerator sqlGenerator;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<JLGCollectionSheetFlatData> getGroupCollectionSheetFlatDataList(final LocalDate transactionDate,
            final String officeHierarchy, final GroupGeneralData group, final CalendarEntityType entityType) {
        final boolean isCenterCollection = false;
        final String transactionDateStr = DateUtils.DEFAULT_DATE_FORMATTER.format(transactionDate);
        final StringBuilder sqlString = getCollectionSheetFlatDataSql(isCenterCollection);

        return namedParameterJdbcTemplate.query(sqlString.toString(),
                getGroupNamedParameters(transactionDateStr, officeHierarchy, group, entityType), rowMapperFlatData());
    }

    private SqlParameterSource getGroupNamedParameters(final String transactionDateStr, final String officeHierarchy,
                                                       final GroupGeneralData group, final CalendarEntityType entityType) {

        return new MapSqlParameterSource().addValue("dueDate", transactionDateStr).addValue("groupId", group.getId())
                .addValue("officeHierarchy", officeHierarchy).addValue("entityTypeId", entityType.getValue());
    }

    private StringBuilder getCollectionSheetFlatDataSql(final boolean isCenterCollection) {
        final StringBuilder sqlString = new StringBuilder();
        sqlString.append("SELECT loandata.*, SUM(lc.amount_outstanding_derived) AS chargesDue FROM ");
        sqlString.append("(SELECT gp.display_name AS groupName, ");
        sqlString.append("gp.id AS groupId, ");
        sqlString.append("cl.display_name AS clientName, ");
        sqlString.append("sf.id AS staffId, ");
        sqlString.append("sf.display_name AS staffName, ");
        sqlString.append("gl.id AS levelId, ");
        sqlString.append("gl.level_name AS levelName, ");
        sqlString.append("cl.id AS clientId, ");
        sqlString.append("ln.id AS loanId, ");
        sqlString.append("ln.account_no AS accountId, ");
        sqlString.append("ln.loan_status_id AS accountStatusId, ");
        sqlString.append("pl.short_name AS productShortName, ");
        sqlString.append("ln.product_id AS productId, ");
        sqlString.append("ln.currency_code AS currencyCode, ");
        sqlString.append("ln.currency_digits AS currencyDigits, ");
        sqlString.append("ln.currency_multiplesof AS inMultiplesOf, ");
        sqlString.append("rc.");
        sqlString.append(sqlGenerator.escape("name"));
        sqlString.append(" AS currencyName, ");
        sqlString.append("rc.display_symbol AS currencyDisplaySymbol, ");
        sqlString.append("rc.internationalized_name_code AS currencyNameCode, ");
        sqlString.append("(CASE WHEN ln.loan_status_id = 200 THEN ln.principal_amount ELSE NULL END) AS disbursementAmount, ");
        sqlString.append("SUM(COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls.principal_amount "
                + "ELSE 0.0 END), 0.0) - COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls"
                + ".principal_completed_derived ELSE 0.0 END), 0.0)) AS principalDue, ");
        sqlString.append("ln.principal_repaid_derived AS principalPaid, ");
        sqlString.append("SUM(COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls.interest_amount "
                + "ELSE  0.0 END), 0.0) - COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls"
                + ".interest_completed_derived ELSE 0.0 END), 0.0) - COALESCE((CASE WHEN ln"
                + ".loan_status_id = 300 THEN ls.interest_waived_derived ELSE 0.0 END), 0.0)) AS interestDue, ");
        sqlString.append("ln.interest_repaid_derived AS interestPaid, ");
        sqlString.append("sum(COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls.fee_charges_amount "
                + "ELSE  0.0 END), 0.0) - COALESCE((CASE WHEN ln.loan_status_id = 300 THEN ls"
                + ".fee_charges_completed_derived ELSE 0.0 END), 0.0)) AS feeDue, ");
        sqlString.append("ln.fee_charges_repaid_derived AS feePaid, ");
        sqlString.append("ca.attendance_type_enum AS attendanceTypeId ");
        sqlString.append("FROM m_group gp ");
        sqlString.append("LEFT JOIN m_office ofc ON ofc.id = gp.office_id AND ofc.hierarchy LIKE :officeHierarchy ");
        sqlString.append("JOIN m_group_level gl ON gl.id = gp.level_Id ");
        sqlString.append("LEFT JOIN m_staff sf ON sf.id = gp.staff_id ");
        sqlString.append("JOIN m_group_client gc ON gc.group_id = gp.id ");
        sqlString.append("JOIN m_client cl ON cl.id = gc.client_id ");
        sqlString.append("LEFT JOIN m_loan ln ON cl.id = ln.client_id ");
        sqlString.append("AND ln.group_id=gp.id ");
        sqlString.append("AND ln.group_id IS NOT NULL ");
        sqlString.append("AND ( ln.loan_status_id = 300 ) ");
        sqlString.append("LEFT JOIN m_product_loan pl ON pl.id = ln.product_id ");
        sqlString.append("LEFT JOIN m_currency rc ON rc.");
        sqlString.append(sqlGenerator.escape("code"));
        sqlString.append(" = ln.currency_code ");
        sqlString.append("LEFT JOIN m_loan_repayment_schedule ls ON ls.loan_id = ln.id ");
        sqlString.append("AND ls.completed_derived = 0 ");
        sqlString.append("AND ls.duedate <= :dueDate ");
        sqlString.append("LEFT JOIN m_calendar_instance ci ON gp.parent_id = ci.entity_id AND ci.entity_type_enum =:entityTypeId ");
        sqlString.append("LEFT JOIN m_meeting mt ON ci.id = mt.calendar_instance_id AND mt.meeting_date =:dueDate ");
        sqlString.append("LEFT JOIN m_client_attendance ca ON ca.meeting_id=mt.id AND ca.client_id=cl.id ");
        if (isCenterCollection) {
            sqlString.append("WHERE gp.parent_id = :centerId ");
        } else {
            sqlString.append("WHERE gp.id = :groupId ");
        }
        sqlString.append("AND (ln.loan_status_id != 200 AND ln.loan_status_id != 100) ");
        sqlString.append("AND (gp.status_enum = 300 OR (gp.status_enum = 600 AND gp.closedon_date >= :dueDate)) ");
        sqlString.append("AND (cl.status_enum = 300 OR (cl.status_enum = 600 AND cl.closedon_date >= :dueDate)) ");
        sqlString.append("GROUP BY gp.id, cl.id, ln.id, ca.attendance_type_enum ORDER BY gp.id, cl.id, ln.id ");
        sqlString.append(") loandata ");
        sqlString.append("LEFT JOIN m_loan_charge lc ON lc.loan_id = loandata.loanId ");
        sqlString.append("AND lc.is_paid_derived = FALSE ");
        sqlString.append("AND lc.is_active = TRUE ");
        sqlString.append("AND ( lc.due_for_collection_as_of_date  <= :dueDate OR lc.charge_time_enum = 1) ");
        sqlString.append("GROUP BY loandata.groupId, loandata.clientId, loandata.loanId ");
        sqlString.append(", loandata.principalDue, loandata.interestDue, loandata.feeDue, loandata.attendanceTypeId ");
        sqlString.append("ORDER BY loandata.groupId, ");
        sqlString.append("loandata.clientId, ");
        sqlString.append("loandata.loanId;");
        return sqlString;
    }

    private RowMapper<JLGCollectionSheetFlatData> rowMapperFlatData() {
        return (rs, rowNum) -> {
            final String groupName = rs.getString("groupName");
            final Long groupId = JdbcSupport.getLong(rs, "groupId");
            final Long staffId = JdbcSupport.getLong(rs, "staffId");
            final String staffName = rs.getString("staffName");
            final Long levelId = JdbcSupport.getLong(rs, "levelId");
            final String levelName = rs.getString("levelName");
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

            final Integer attendanceTypeId = rs.getInt("attendanceTypeId");
            final EnumOptionData attendanceType = AttendanceEnumerations.attendanceType(attendanceTypeId);

            return new JLGCollectionSheetFlatData(groupName, groupId, staffId, staffName, levelId, levelName, clientName, clientId, loanId,
                    accountId, accountStatusId, productShortName, productId, currencyData, disbursementAmount, principalDue, principalPaid,
                    interestDue, interestPaid, chargesDue, attendanceType, feeDue, feePaid);
        };
    }

    public List<JLGGroupData> getGroupsWithSavingsData(final LocalDate transactionDate,
                                                          final String officeHierarchy, final GroupGeneralData group, final CalendarEntityType entityType) {
      final boolean isCenterCollection = false;
      final String transactionDateStr = DateUtils.DEFAULT_DATE_FORMATTER.format(transactionDate);
      StringBuilder sqlString = getGroupsAndCentersWithSavingsDataSql(isCenterCollection);

      return namedParameterJdbcTemplate
            .query(sqlString.toString(), getGroupNamedParameters(transactionDateStr, officeHierarchy, group, entityType), savingsDataResultSet());
  }

  private StringBuilder getGroupsAndCentersWithSavingsDataSql(final boolean isCenterCollection) {
        final StringBuilder sqlString = new StringBuilder(400);
          sqlString.append("SELECT gp.display_name AS groupName, ");
          sqlString.append("gp.id AS groupId, ");
          sqlString.append("cl.display_name AS clientName, ");
          sqlString.append("cl.id AS clientId, ");
          sqlString.append("sf.id AS staffId, ");
          sqlString.append("sf.display_name AS staffName, ");
          sqlString.append("gl.id AS levelId, ");
          sqlString.append("gl.level_name AS levelName, ");
          sqlString.append("sa.id AS savingsId, ");
          sqlString.append("sa.account_no AS accountId, ");
          sqlString.append("sa.status_enum AS accountStatusId, ");
          sqlString.append("sp.short_name AS productShortName, ");
          sqlString.append("sp.id AS productId, ");
          sqlString.append("sa.currency_code AS currencyCode, ");
          sqlString.append("sa.currency_digits AS currencyDigits, ");
          sqlString.append("sa.currency_multiplesof AS inMultiplesOf, ");
          sqlString.append("rc.");
          sqlString.append(sqlGenerator.escape("name"));
          sqlString.append(" AS currencyName, ");
          sqlString.append("rc.display_symbol AS currencyDisplaySymbol, ");
          sqlString.append("(CASE WHEN sa.deposit_type_enum=100 THEN 'Saving Deposit' ELSE (CASE WHEN sa"
                  + ".deposit_type_enum=300 THEN 'Recurring Deposit' ELSE 'Current Deposit' END) END) " + "AS depositAccountType, ");
          sqlString.append("rc.internationalized_name_code AS currencyNameCode, ");
          sqlString.append("SUM(COALESCE(mss.deposit_amount,0) - COALESCE(mss" + ".deposit_amount_completed_derived,0)) AS dueAmount ");
          sqlString.append("FROM m_group gp ");
          sqlString.append("LEFT JOIN m_office ofc ON ofc.id = gp.office_id AND ofc.hierarchy LIKE " + ":officeHierarchy ");
          sqlString.append("JOIN m_group_level gl ON gl.id = gp.level_Id ");
          sqlString.append("LEFT JOIN m_staff sf ON sf.id = gp.staff_id ");
          sqlString.append("JOIN m_group_client gc ON gc.group_id = gp.id ");
          sqlString.append("JOIN m_client cl ON cl.id = gc.client_id ");
          sqlString.append("JOIN m_savings_account sa ON sa.client_id=cl.id AND sa.status_enum = 300 ");
          sqlString.append("JOIN m_savings_product sp ON sa.product_id=sp.id ");
          sqlString.append("LEFT JOIN m_deposit_account_recurring_detail dard ON sa.id = dard"
                  + ".savings_account_id AND dard.is_mandatory = TRUE AND dard.is_calendar_inherited = " + "TRUE ");
          sqlString.append("LEFT JOIN m_mandatory_savings_schedule mss ON mss.savings_account_id = sa.id " + "AND mss.duedate <= :dueDate ");
          sqlString.append("LEFT JOIN m_currency rc ON rc.");
          sqlString.append(sqlGenerator.escape("code"));
          sqlString.append(" = sa.currency_code ");
          if (isCenterCollection) {
              sqlString.append("WHERE gp.parent_id = :centerId ");
          } else {
              sqlString.append("WHERE gp.id = :groupId ");
          }

          sqlString.append("AND (gp.status_enum = 300 OR (gp.status_enum = 600 AND gp.closedon_date >= " + ":dueDate)) ");
          sqlString.append("AND (cl.status_enum = 300 OR (cl.status_enum = 600 AND cl.closedon_date >= " + ":dueDate)) ");
          sqlString.append("GROUP BY gp.id, cl.id, sa.id ORDER BY gp.id, cl.id, sa.id ");
        return sqlString;
    }

  private ResultSetExtractor<List<JLGGroupData>> savingsDataResultSet() {
      return rs -> {
        List<JLGGroupData> groups = new ArrayList<>();
        JLGGroupData group = null;
        int groupIndex = 0;
        boolean isEndOfRecords = false;
        // move cursor to first row.
        final boolean isNotEmptyResultSet = rs.next();

        if (isNotEmptyResultSet) {
          while (!isEndOfRecords) {
            group = mapRowData(rs, groupIndex++);
            groups.add(group);
            isEndOfRecords = rs.isAfterLast();
          }
        }
        return groups;
      };
    }

  private JLGGroupData mapRowData(ResultSet rs, int rowNum) throws SQLException {
    final List<JLGClientData> clients = new ArrayList<>();
    final JLGGroupData group = mapGroupRow(rs, rowNum);
    final Long previousGroupId = group.getGroupId();

    // first client row of new group
    JLGClientData client = mapClientRowData(rs, rowNum);
    clients.add(client);

    // if it's not after last row loop
    while (!rs.isAfterLast()) {
      final Long groupId = JdbcSupport.getLong(rs, "groupId");
      if (previousGroupId != null && groupId.compareTo(previousGroupId) != 0) {
        // return for next group details
        return JLGGroupData.withClients(group, clients);
      }
      client = mapClientRowData(rs, rowNum);
      clients.add(client);
    }
    return JLGGroupData.withClients(group, clients);
  }

  private JLGClientData mapClientRowData(ResultSet rs, int rowNum) throws SQLException {

    List<SavingsDueData> savings = new ArrayList<>();

    JLGClientData client = mapClientRow(rs, rowNum);
    final Long previousClientId = client.getClientId();

    // first savings row of new client record
    SavingsDueData saving = mapSavingsDataRow(rs, rowNum);
    savings.add(saving);

    while (rs.next()) {
      final Long clientId = JdbcSupport.getLong(rs, "clientId");
      if (previousClientId != null && clientId.compareTo(previousClientId) != 0) {
        // client id changes then return for next client data
        return JLGClientData.withSavings(client, savings);
      }
      saving = mapSavingsDataRow(rs, rowNum);
      savings.add(saving);
    }
    return JLGClientData.withSavings(client, savings);
  }

  private JLGGroupData mapGroupRow(ResultSet rs, int rowNum) throws SQLException {
    final String groupName = rs.getString("groupName");
    final Long groupId = JdbcSupport.getLong(rs, "groupId");
    final Long staffId = JdbcSupport.getLong(rs, "staffId");
    final String staffName = rs.getString("staffName");
    final Long levelId = JdbcSupport.getLong(rs, "levelId");
    final String levelName = rs.getString("levelName");
    return JLGGroupData.instance(groupId, groupName, staffId, staffName, levelId, levelName);
  }

  private JLGClientData mapClientRow(ResultSet rs, int rowNum) throws SQLException {
    final String clientName = rs.getString("clientName");
    final Long clientId = JdbcSupport.getLong(rs, "clientId");

    return JLGClientData.instance(clientId, clientName, null);
  }

  private SavingsDueData mapSavingsDataRow(ResultSet rs, int rowNum) throws SQLException {
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

    final CurrencyData currency = new CurrencyData(currencyCode, currencyName, currencyDigits, inMultiplesOf, currencyDisplaySymbol,
            currencyNameCode);

    return SavingsDueData.instance(savingsId, accountId, accountStatusId, productName, productId, currency, dueAmount,
            depositAccountType);
  }

  public List<JLGCollectionSheetFlatData> getCenterCollectionSheetFlatDataList(final LocalDate transactionDate, final String officeHierarchy, final CenterData center) {
    final boolean isCenterCollection = true;
    final String dueDateStr = DateUtils.DEFAULT_DATE_FORMATTER.format(transactionDate);
    final StringBuilder sqlString = getCollectionSheetFlatDataSql(isCenterCollection);

    return namedParameterJdbcTemplate.query(sqlString.toString(),
            getCenterNamedParameters(dueDateStr, officeHierarchy, center),
            rowMapperFlatData());
  }

  private SqlParameterSource getCenterNamedParameters(String dueDateStr, String officeHierarchy, CenterData center) {
      return new MapSqlParameterSource().addValue("dueDate", dueDateStr)
        .addValue("centerId", center.getId()).addValue("officeHierarchy", officeHierarchy)
        .addValue("entityTypeId", CalendarEntityType.CENTERS.getValue());
  }

  public List<JLGGroupData> getCenterWithSavingsData(LocalDate transactionDate, String officeHierarchy, CenterData center) {
    final boolean isCenterCollection = true;
    final String dueDateStr = DateUtils.DEFAULT_DATE_FORMATTER.format(transactionDate);
    StringBuilder sqlString = getGroupsAndCentersWithSavingsDataSql(isCenterCollection);

    return namedParameterJdbcTemplate
            .query(sqlString.toString(), getCenterNamedParameters(dueDateStr, officeHierarchy, center), savingsDataResultSet());
  }
}
