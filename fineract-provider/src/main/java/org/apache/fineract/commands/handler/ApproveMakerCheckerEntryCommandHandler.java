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
package org.apache.fineract.commands.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.command.core.CommandHandler;
import org.apache.fineract.commands.data.ApproveMakerCheckerEntryRequest;
import org.apache.fineract.commands.data.ApproveMakerCheckerEntryResponse;
import org.apache.fineract.commands.data.MakerCheckerStatus;
import org.apache.fineract.commands.service.PortfolioCommandSourceWritePlatformService;
import org.apache.fineract.infrastructure.core.exception.UnrecognizedQueryParamException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApproveMakerCheckerEntryCommandHandler
        implements CommandHandler<ApproveMakerCheckerEntryRequest, ApproveMakerCheckerEntryResponse> {

    private final PortfolioCommandSourceWritePlatformService writePlatformService;

    @Transactional
    @Override
    public ApproveMakerCheckerEntryResponse handle(Command<ApproveMakerCheckerEntryRequest> command) {

        if (command.getPayload().getCommandParam().equalsIgnoreCase(MakerCheckerStatus.APPROVE.toString())) {
            return writePlatformService.approveEntry(command);
        } else if (command.getPayload().getCommandParam().equalsIgnoreCase(MakerCheckerStatus.REJECT.toString())) {
            return writePlatformService.rejectEntry(command);
        } else {
            throw new UnrecognizedQueryParamException("command", command.getPayload().getCommandParam());
        }
    }
}
