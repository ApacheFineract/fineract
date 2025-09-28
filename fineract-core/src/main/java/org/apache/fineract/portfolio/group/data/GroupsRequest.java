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
package org.apache.fineract.portfolio.group.data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupsRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private Long officeId;
    private String submittedOnDate;
    private String externalId;
    private Boolean active;
    private String activationDate;
    private String dateFormat;
    private String locale;
    private String[] clientMembers;
    private String transactionDate;
    private Long calendarId;
    private String actualDisbursementDate;
    private Long staffId;
    private String role;
    private Long clientId;
    private Long roleId;
    private Long destinationGroupId;
    private String closureDate;
    private Long closureReasonId;
    private List<BulkDisbursementTransactionsRequest> bulkDisbursementTransactions;
    private List<BulkRepaymentTransactionsRequest> bulkRepaymentTransactions;
    private List<BulkSavingsDueTransactionsRequest> bulkSavingsDueTransactions;
}
