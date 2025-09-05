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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Immutable data object for groups with clients due for disbursement or collection.
 */
@Getter
@Setter
@AllArgsConstructor
public final class JLGGroupData implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Long groupId;
    private final String groupName;
    private final Long staffId;
    private final String staffName;
    private final Long levelId;
    private final String levelName;
    private List<JLGClientData> clients;

    public static JLGGroupData instance(final Long groupId, final String groupName, final Long staffId, final String staffName,
            final Long levelId, final String levelName) {
        return new JLGGroupData(groupId, groupName, staffId, staffName, levelId, levelName, null);
    }

    public static JLGGroupData withClients(final JLGGroupData group, List<JLGClientData> clients) {
        return new JLGGroupData(group.groupId, group.groupName, group.staffId, group.staffName, group.levelId, group.levelName, clients);
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof JLGGroupData)) {
            return false;
        }
        final JLGGroupData groupData = (JLGGroupData) obj;
        return groupData.groupId.compareTo(this.groupId) == 0;
    }

    @Override
    public int hashCode() {
        return this.groupId.hashCode();
    }
}
