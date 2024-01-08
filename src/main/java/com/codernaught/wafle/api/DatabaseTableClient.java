/*
 *    Copyright 2023 Kelvin Johnson
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.codernaught.wafle.api;

import com.codernaught.wafle.definition.FlowableDefinitions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface DatabaseTableClient {
    static final String DATABASE_TABLES                    = "/service/management/tables";
    static final String DATABASE_TABLE                     = "/service/management/tables/{tableName}";
    static final String DATABASE_COLUMN_FOR_SINGLE_TABLE   = "/service/management/tables/{tableName}/columns";
    static final String DATABASE_DATA_FOR_SINGLE_ROW       = "/service/management/tables/{tableName}/data";

    @GetExchange(DATABASE_TABLES)
    Mono<ResponseEntity<String>> getDatabaseTables();

    @GetExchange(DATABASE_TABLE)
    Mono<ResponseEntity<String>> getDatabaseTable(@PathVariable String tableName);

    @GetExchange(DATABASE_COLUMN_FOR_SINGLE_TABLE)
    Mono<ResponseEntity<String>> getDatabaseTableColumns(@PathVariable String tableName);

    @GetExchange(DATABASE_DATA_FOR_SINGLE_ROW)
    Mono<ResponseEntity<String>> getDatabaseTableData(@PathVariable String tableName);
}
