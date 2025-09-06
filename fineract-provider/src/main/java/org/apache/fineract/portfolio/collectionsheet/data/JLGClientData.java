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
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.fineract.infrastructure.core.data.EnumOptionData;

/**
 * Immutable data object for clients with loans due for disbursement or collection.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public final class JLGClientData implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Long clientId;
    private final String clientName;
    private List<LoanDueData> loans;
    private List<SavingsDueData> savings;
    private final EnumOptionData attendanceType;

    public static JLGClientData instance(final Long clientId, final String clientName, final EnumOptionData attendanceType) {
        return new JLGClientData(clientId, clientName, new ArrayList<>(), new ArrayList<>(), attendanceType);
    }

    public static JLGClientData withSavings(final JLGClientData client, final List<SavingsDueData> savings) {
        final EnumOptionData attendanceType = null;
        return new JLGClientData(client.clientId, client.clientName, new ArrayList<>(), savings, attendanceType);
    }

    /*
     * public JLGClientData(final Long clientId, final String clientName, final Collection<LoanDueData> loans, final
     * EnumOptionData attendanceType) { this.clientId = clientId; this.clientName = clientName; this.loans = loans;
     * this.attendanceType = attendanceType; }
     */
    public static JLGClientData withAttendance(final Long clientId, final String clientName, final EnumOptionData attendanceType) {
        return new JLGClientData(clientId, clientName, new ArrayList<>(), new ArrayList<>(), attendanceType);
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof JLGClientData)) {
            return false;
        }
        final JLGClientData clientData = (JLGClientData) obj;
        return clientData.clientId.compareTo(this.clientId) == 0;
    }

    @Override
    public int hashCode() {
        return this.clientId.hashCode();
    }
}
