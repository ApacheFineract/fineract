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
package org.apache.fineract.command.core.utils;

import java.io.Serializable;
import java.util.Set;

public class CommandActionBuilder implements Serializable {

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
    private String transactionId;
    private Long productId;
    private Long templateId;
    private Long creditBureauId;
    private Long organisationCreditBureauId;
    private String jobName;
    private String idempotencyKey;
    private Set<String> sanitizeJsonKeys;

    public static CommandActionBuilder saveGroupCollectionSheet(final Long groupId) {
        return new CommandActionBuilder().withActionName("SAVECOLLECTIONSHEET").withEntityName("GROUP").withEntityId(groupId)
                .withGroupId(groupId).withHref("/groups/" + groupId + "?command=saveCollectionSheet");
    }

    public CommandActionBuilder withActionName(String actionName) {
        this.actionName = actionName;
        return this;
    }

    public CommandActionBuilder withEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public CommandActionBuilder withGroupId(Long groupId) {
        this.groupId = groupId;
        return this;
    }

    public CommandActionBuilder withEntityId(Long entityId) {
        this.entityId = entityId;
        return this;
    }

    public CommandActionBuilder withLoanId(Long loanId) {
        this.loanId = loanId;
        return this;
    }

    public CommandActionBuilder withHref(String href) {
        this.href = href;
        return this;
    }
}
