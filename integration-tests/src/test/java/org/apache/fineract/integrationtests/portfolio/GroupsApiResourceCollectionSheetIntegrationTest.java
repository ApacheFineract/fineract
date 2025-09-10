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
package org.apache.fineract.integrationtests.portfolio;

import java.io.IOException;
import org.apache.fineract.client.services.GroupsApi;
import org.apache.fineract.integrationtests.common.FineractClientHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

public class GroupsApiResourceCollectionSheetIntegrationTest {

    @Test
    public void testGroupsApiResource_GenerateCollectionSheet_statusCode_200() throws IOException {

        String requestJson = "{" + "\"transactionDate\":\"01 September 2025\"," + "\"dateFormat\":\"dd MMMM yyyy\"," + "\"locale\":\"en\","
                + "\"calendarId\":1" + "}";

        GroupsApi groupsApi = FineractClientHelper.getFineractClient().groups;
        Call<String> call = groupsApi.activateOrGenerateCollectionSheet(1L, requestJson, "generateCollectionSheet", null);
        Response<String> response = call.execute();

        Assertions.assertThat(response.code()).isBetween(200, 204);
    }

    @Test
    public void testGroupsApiResource_GenerateCollectionSheet_statusCode_204() throws IOException {

        String requestJson = "{" + "\"transactionDate\":\"01 September 2025\"," + "\"dateFormat\":\"dd MMMM yyyy\"," + "\"locale\":\"en\","
                + "\"calendarId\":1" + "}";

        GroupsApi groupsApi = FineractClientHelper.getFineractClient().groups;
        Call<String> call = groupsApi.activateOrGenerateCollectionSheet(2L, requestJson, "generateCollectionSheet", null);
        Response<String> response = call.execute();

        Assertions.assertThat(response.code()).isBetween(200, 204);
    }

    @Test
    public void testGroupsApiResource_GenerateCollectionSheet_statusCode_404() throws IOException {

        String requestJson = "{" + "\"transactionDate\":\"01 September 2025\"," + "\"dateFormat\":\"dd MMMM yyyy\"," + "\"locale\":\"en\","
                + "\"calendarId\":1" + "}";

        GroupsApi groupsApi = FineractClientHelper.getFineractClient().groups;
        Call<String> call = groupsApi.activateOrGenerateCollectionSheet(-1L, requestJson, "generateCollectionSheet", null);
        Response<String> response = call.execute();

        Assertions.assertThat(response.code()).isBetween(400, 404);
    }

    @Test
    public void testGroupsApiResource_GenerateCollectionSheet_null_transaction_date() throws IOException {

        String requestJson = "{" + "\"dateFormat\":\"dd MMMM yyyy\"," + "\"locale\":\"en\"," + "\"calendarId\":1" + "}";

        GroupsApi groupsApi = FineractClientHelper.getFineractClient().groups;
        Call<String> call = groupsApi.activateOrGenerateCollectionSheet(1L, requestJson, "generateCollectionSheet", null);
        Response<String> response = call.execute();

        Assertions.assertThat(response.code()).isBetween(400, 404);
    }

    @Test
    public void testGroupsApiResource_GenerateCollectionSheet_statusCode_null_dateFormat() throws IOException {

        String requestJson = "{" + "\"transactionDate\":\"01 September 2025\"," + "\"locale\":\"en\"," + "\"calendarId\":1" + "}";

        GroupsApi groupsApi = FineractClientHelper.getFineractClient().groups;
        Call<String> call = groupsApi.activateOrGenerateCollectionSheet(1L, requestJson, "generateCollectionSheet", null);
        Response<String> response = call.execute();

        Assertions.assertThat(response.code()).isBetween(400, 404);
    }

    @Test
    public void testGroupsApiResource_GenerateCollectionSheet_statusCode_null_locale() throws IOException {

        String requestJson = "{" + "\"transactionDate\":\"01 September 2025\"," + "\"dateFormat\":\"dd MMMM yyyy\"," + "\"calendarId\":1"
                + "}";

        GroupsApi groupsApi = FineractClientHelper.getFineractClient().groups;
        Call<String> call = groupsApi.activateOrGenerateCollectionSheet(1L, requestJson, "generateCollectionSheet", null);
        Response<String> response = call.execute();

        Assertions.assertThat(response.code()).isBetween(400, 404);
    }

    @Test
    public void testGroupsApiResource_GenerateCollectionSheet_statusCode_null_calendar_id() throws IOException {

        String requestJson = "{" + "\"transactionDate\":\"01 September 2025\"," + "\"dateFormat" + "\":\"dd MMMM yyyy\","
                + "\"locale\":\"en\"";

        GroupsApi groupsApi = FineractClientHelper.getFineractClient().groups;
        Call<String> call = groupsApi.activateOrGenerateCollectionSheet(1L, requestJson, "generateCollectionSheet", null);
        Response<String> response = call.execute();

        Assertions.assertThat(response.code()).isBetween(400, 404);
    }

    @Test
    public void testGroupsApiResource_GenerateCollectionSheet_statusCode_exception() throws IOException {

        GroupsApi groupsApi = FineractClientHelper.getFineractClient().groups;

        Assertions.assertThatThrownBy(() -> {
            groupsApi.activateOrGenerateCollectionSheet(1L, null, "generateCollectionSheet", null).execute();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
