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
package org.apache.fineract.makerchecker.service;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.fineract.commands.domain.CommandSourceRepository;
import org.apache.fineract.commands.domain.CommandWrapper;
import org.apache.fineract.commands.service.CommandProcessingService;
import org.apache.fineract.infrastructure.configuration.domain.ConfigurationDomainService;
import org.apache.fineract.infrastructure.core.domain.FineractRequestContextHolder;
import org.apache.fineract.infrastructure.core.serialization.FromJsonHelper;
import org.apache.fineract.infrastructure.hooks.event.HookEvent;
import org.apache.fineract.infrastructure.jobs.service.SchedulerJobRunnerReadService;
import org.apache.fineract.infrastructure.security.service.PlatformSecurityContext;
import org.apache.fineract.useradministration.domain.AppUserRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandSourceWritePlatformServiceImpl {

    private final PlatformSecurityContext context;
    private final CommandSourceRepository commandSourceRepository;
    private final FromJsonHelper fromApiJsonHelper;
    private final CommandProcessingService processAndLogCommandService;
    private final SchedulerJobRunnerReadService schedulerJobRunnerReadService;
    private final ConfigurationDomainService configurationService;
    private final AppUserRepository repository;
    private final FineractRequestContextHolder fineractRequestContextHolder;

    public List<String> logCommandSource(CommandWrapper wrapper) {

        log.info("Authenticated User: {}", context.authenticatedUser().toString());

        fineractRequestContextHolder.setAttribute("commandId", UUID.randomUUID().toString());

        String commandId = fineractRequestContextHolder.getAttribute("commandId").toString();

        // List<AppUser> usersList = repository.findAll();
        // for (AppUser element : usersList) {
        // log.info("Element: {}", element);
        // }
        // boolean isApprovedByChecker = false;
        //
        // // check if is update of own account details
        // if (wrapper.isChangeOfOwnUserDetails(context.authenticatedUser(wrapper).getId())) {
        // // then allow this operation to proceed.
        // // maker checker doesnt mean anything here.
        // isApprovedByChecker = true; // set to true in case permissions have
        // // been maker-checker enabled by
        // // accident.
        // } else {
        // // if not user changing their own details - check user has
        // // permission to perform specific task.
        // this.context.authenticatedUser(wrapper).validateHasPermissionTo(wrapper.getTaskPermissionName());
        // }
        //
        // validateIsUpdateAllowed();
        // final String json = wrapper.getJson();
        // final JsonElement parsedCommand = this.fromApiJsonHelper.parse(json);
        // JsonCommand command = JsonCommand.from(json, parsedCommand, this.fromApiJsonHelper, wrapper.getEntityName(),
        // wrapper.getEntityId(),
        // wrapper.getSubentityId(), wrapper.getGroupId(), wrapper.getClientId(), wrapper.getLoanId(),
        // wrapper.getSavingsId(),
        // wrapper.getTransactionId(), wrapper.getHref(), wrapper.getProductId(), wrapper.getCreditBureauId(),
        // wrapper.getOrganisationCreditBureauId(), wrapper.getJobName(), wrapper.getLoanExternalId());
        return List.of(context.authenticatedUser().toString(), commandId, wrapper.toString());
    }

    private void validateIsUpdateAllowed() {
        this.schedulerJobRunnerReadService.isUpdatesAllowed();
    }

    @EventListener
    private void consumeEvent(HookEvent event) {
        log.info("Received Hook Event: {}", event);
    }
}
