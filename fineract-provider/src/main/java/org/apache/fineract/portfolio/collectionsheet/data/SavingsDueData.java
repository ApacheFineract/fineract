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

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.fineract.organisation.monetary.data.CurrencyData;

/**
 * Immutable data object for representing loan with dues (example: loan is due for disbursement, repayments).
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public final class SavingsDueData {

    private final Long savingsId;
    private final String accountId;
    private final Integer accountStatusId;
    private final String productName;
    private final Long productId;
    private final CurrencyData currency;
    private BigDecimal dueAmount;
    private String depositAccountType;

    public static SavingsDueData instance(final Long savingsId, final String accountId, final Integer accountStatusId,
            final String productName, final Long productId, final CurrencyData currency, final BigDecimal dueAmount,
            final String depositAccountType) {
        return new SavingsDueData(savingsId, accountId, accountStatusId, productName, productId, currency, dueAmount, depositAccountType);
    }

    public String productName() {
        return this.productName;
    }

    public Long productId() {
        return this.productId;
    }
}
