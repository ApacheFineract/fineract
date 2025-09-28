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
package org.apache.fineract.command.persistence.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.command.core.CommandMiddleware;
import org.apache.fineract.command.persistence.domain.CommandEntity;
import org.apache.fineract.command.persistence.domain.CommandRepository;
import org.apache.fineract.command.persistence.mapping.CommandJsonMapper;
import org.apache.fineract.command.persistence.mapping.CommandMapper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommandPersistenceMiddleware implements CommandMiddleware {

    private final CommandMapper commandMapper;
    private final CommandRepository commandRepository;
    private final CommandJsonMapper commandJsonMapper;

    @Override
    public void invoke(Command<?> command) {
        if (command == null) {
            log.warn("Received null command, skipping persistence");
            return;
        }

        if(commandRepository.existsByCommandId(command.getId())) {
          return;
        }

        try {
            // 1 Convert the typed payload to JsonNode using CommandJsonMapper
            JsonNode payloadJson = commandJsonMapper.map(command.getPayload());

            // 2️ Map the Command object to CommandEntity
//            CommandEntity entity = commandMapper.map(command);

            CommandEntity entity = new CommandEntity();

            entity.setCommandId(command.getId());
            entity.setPayload(payloadJson);
            entity.setCreatedAt(command.getCreatedAt());

            // 3️ Set the serialized payload in the entity
//            entity.setPayload(payloadJson);

            // 4️ Persist the entity in the database
            commandRepository.save(entity);

            log.info("Persisted command {} with payload type {} to m_command", command.getId(),
                    command.getPayload() != null ? command.getPayload().getClass().getSimpleName() : "null");

        } catch (Exception e) {
            log.error("Failed to persist command {}", command.getId(), e);
        }
    }
}
