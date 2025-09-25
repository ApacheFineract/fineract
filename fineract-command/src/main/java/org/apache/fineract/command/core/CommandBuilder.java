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
package org.apache.fineract.command.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommandBuilder {

    private Long officeId;
    private Long groupId;
    private Long clientId;
    private Long loanId;
    private Long savingsId;
    private String actionName;
    private String entityName;
    private Long entityId;
    private Long subentityId;
    private String href;
    // private String json = "{}";
    private String transactionId;
    private Long productId;
    private Long templateId;
    private Long creditBureauId;
    private Long organisationCreditBureauId;
    private String jobName;
    private String idempotencyKey;
    // private ExternalId loanExternalId;
    // private Set<String> sanitizeJsonKeys;

    public static CommandBuilder createAccountTransfer() {
        // this.actionName = "CREATE";
        // this.entityName = "ACCOUNTTRANSFER";
        // this.entityId = null;
        // this.href = "/accounttransfers";
        // return this;
        return new CommandBuilder().withActionName("CREATE").withEntityName("ACCOUNTTRANSFER").withHref("/accounttransfers");
    }

    public static CommandBuilder createAccount(String accountType) {
        // this.entityName = accountType.toUpperCase() + "ACCOUNT"; // To Support
        // this.actionName = "CREATE";
        // this.entityId = null;
        // this.href = "/accounts/" + accountType;
        // return this;
        return new CommandBuilder().withActionName("CREATE").withEntityName(accountType.toUpperCase() + "ACCOUNT")
                .withHref("/accounts/" + accountType);
    }

    public CommandBuilder updateAccount(String accountType, final Long accountId) {
        this.entityName = accountType.toUpperCase() + "ACCOUNT";
        this.actionName = "UPDATE";
        this.entityId = accountId;
        this.href = "/accounts/" + accountType + "/" + accountId;
        return this;
    }

    public static CommandBuilder createGuarantor(final Long loanId) {
        // actionName = "CREATE";
        // entityName = "GUARANTOR";
        // entityId = null;
        // loanId = loanId;
        // href = "/loans/" + loanId + "/guarantors";
        // return this;
        return new CommandBuilder().withActionName("CREATE").withEntityName("GUARANTOR").withEntityId(null).withLoanId(loanId)
                .withHref("/loans/" + loanId + "/guarantors");
    }

    // public CommandBuilder recoverFromGuarantor(final Long loanId) {
    // this.actionName = "RECOVERGUARANTEES";
    // this.entityName = "LOAN";
    // this.entityId = loanId;
    // this.loanId = loanId;
    // this.href = "/loans/" + loanId + "?command=recoverGuarantees";
    // return this;
    // }
    //
    // public CommandBuilder updateGuarantor(final Long loanId, final Long guarantorId) {
    // this.actionName = "UPDATE";
    // this.entityName = "GUARANTOR";
    // this.entityId = guarantorId;
    // this.loanId = loanId;
    // this.href = "/loans/" + loanId + "/guarantors/" + guarantorId;
    // return this;
    // }
    //
    // public CommandBuilder deleteGuarantor(final Long loanId, final Long guarantorId, final Long guarantorFundingId) {
    // this.actionName = "DELETE";
    // this.entityName = "GUARANTOR";
    // this.entityId = guarantorId;
    // this.subentityId = guarantorFundingId;
    // this.loanId = loanId;
    // this.href = "/loans/" + loanId + "/guarantors/" + guarantorId;
    // return this;
    // }

    public CommandBuilder withActionName(String actionName) {
        this.actionName = actionName;
        return this;
    }

    public CommandBuilder withEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public CommandBuilder withEntityId(Long entityId) {
        this.entityId = entityId;
        return this;
    }

    public CommandBuilder withLoanId(Long loanId) {
        this.loanId = loanId;
        return this;
    }

    public CommandBuilder withHref(String href) {
        this.href = href;
        return this;
    }
}
