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
package org.apache.fineract.portfolio.collectionsheet.data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.fineract.organisation.monetary.data.CurrencyData;

/**
 * Immutable data object for extracting flat data for joint liability group's collection sheet.
 */
@Getter
@Setter
@AllArgsConstructor
public class IndividualCollectionSheetLoanFlatData implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String clientName;
    private final Long clientId;
    private final Long loanId;
    private final String accountId;
    private final Integer accountStatusId;
    private final String productShortName;
    private final Long productId;
    private final CurrencyData currency;
    private BigDecimal disbursementAmount;
    private BigDecimal principalDue;
    private BigDecimal principalPaid;
    private BigDecimal interestDue;
    private BigDecimal interestPaid;
    private BigDecimal chargesDue;
    private BigDecimal feeDue;
    private BigDecimal feePaid;

    public LoanDueData getLoanDueData() {
        return new LoanDueData(this.loanId, this.accountId, this.accountStatusId, this.productShortName, this.productId, this.currency,
                this.disbursementAmount, this.principalDue, this.principalPaid, this.interestDue, this.interestPaid, this.chargesDue,
                this.feeDue, this.feePaid);
    }

    public IndividualClientData getClientData() {
        return IndividualClientData.instance(this.clientId, this.clientName);
    }
}
