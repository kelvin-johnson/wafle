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

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;
import reactor.core.publisher.Mono;

public interface ExecutionClient {
    final String EXECUTIONS              = "/service/runtime/executions";
    final String EXECUTION               = "/service/runtime/executions/{executionId}";
    final String EXECUTION_QUERY         = "/service/query/executions";
    final String EXECUTION_ACTIVITIES    = "/service/runtime/executions/{executionId}/activities";
    final String EXECUTION_VARIABLES     = "/service/runtime/executions/{executionId}/variables";
    final String EXECUTION_VARIABLE      = "/service/runtime/executions/{executionId}/variables/{variableName}";

    @GetExchange(value = EXECUTIONS)
    Mono<ResponseEntity<String>> getExecutions();

    @GetExchange(value = EXECUTION)
    Mono<ResponseEntity<String>> getExecution(@PathVariable String executionId);

    @PostExchange(value = EXECUTION_QUERY)
    Mono<ResponseEntity<String>> queryExecutions(@RequestBody String query);

    @PutExchange(value = EXECUTION)
    Mono<ResponseEntity<String>> executionAction(@PathVariable String executionId);

    @GetExchange(value = EXECUTION_ACTIVITIES)
    Mono<ResponseEntity<String>> getExecutionActivities(@PathVariable String executionId);

    @GetExchange(value = EXECUTION_VARIABLES)
    Mono<ResponseEntity<String>> getExecutionVariables(@PathVariable String executionId);

    @GetExchange(value = EXECUTION_VARIABLE)
    Mono<ResponseEntity<String>> getExecutionVariable(@PathVariable String executionId, @PathVariable String variableName);

    @PostExchange(value = EXECUTION_VARIABLES)
    Mono<ResponseEntity<String>> createExecutionVariable(@PathVariable String executionId, @PathVariable String variableName, @RequestBody String variableValue);

    @PutExchange(value = EXECUTION_VARIABLE)
    Mono<ResponseEntity<String>> updateExecutionVariable(@PathVariable String executionId, @PathVariable String variableName, @RequestBody String variableValue);

    @PostExchange(value = EXECUTION_VARIABLES, contentType = "multipart/form-data")
    Mono<ResponseEntity<String>> createExecutionVariable(@PathVariable String executionId, @PathVariable String variableName, @RequestPart FileSystemResource variableValue);

    @PutExchange(value = EXECUTION_VARIABLE, contentType = "multipart/form-data")
    Mono<ResponseEntity<String>> updateExecutionVariable(@PathVariable String executionId, @PathVariable String variableName, @RequestPart FileSystemResource variableValue);

}
