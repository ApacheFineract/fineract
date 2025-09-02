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
package org.apache.fineract.makerchecker.api;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.fineract.commands.domain.CommandWrapper;
import org.apache.fineract.commands.service.CommandWrapperBuilder;
import org.apache.fineract.makerchecker.service.CommandSourceWritePlatformServiceImpl;
import org.springframework.stereotype.Component;

@Path("/v1/makerchecker")
@Component
@Consumes({ "application/json" })
@Produces({ "application/json" })
@RequiredArgsConstructor
public class MakerCheckerApiResource {

    private final CommandSourceWritePlatformServiceImpl commandsSourceWritePlatformService;

    @POST
    public List<String> checkLoginFunctionality(@Parameter(hidden = true) final String apiRequestBodyAsJson) {

        final CommandWrapper commandRequest = new CommandWrapperBuilder().createClient().withJson(apiRequestBodyAsJson).build();

        final List<String> result = commandsSourceWritePlatformService.logCommandSource(commandRequest);

        return result;
    }

}
