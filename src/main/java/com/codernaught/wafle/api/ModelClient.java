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
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.service.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface ModelClient {
    final String MODELS                      = "/service/repository/models";
    final String MODEL                       = "/service/repository/models/{modelId}";
    final String MODEL_SOURCE                = "/service/repository/models/{modelId}/source";
    final String MODEL_SOURCE_EXTRA          = "/service/repository/models/{modelId}/source-extra";

    @GetExchange(MODELS)
    Mono<ResponseEntity<String>> getModels();

    @GetExchange(MODEL)
    Mono<ResponseEntity<String>> getModel(@PathVariable String modelId);

    @PostExchange(MODELS)
    Mono<ResponseEntity<String>> createModel(@PathVariable String name, Map<String,String> modelInfo);

    @PatchExchange(value=MODEL, contentType = "multipart/form-data")
    Mono<ResponseEntity<String>> updateModel(@RequestPart FileSystemResource fileSystemResource, @PathVariable String modelId);

    @DeleteExchange(MODEL)
    Mono<ResponseEntity<String>> deleteModel(@PathVariable String modelId);

    @GetExchange(MODEL_SOURCE)
    Mono<ResponseEntity<String>> getModelEditorSource(@PathVariable String modelId);

    @PutExchange(value=MODEL_SOURCE, contentType = "multipart/form-data")
    Mono<ResponseEntity<String>> setModelEditorSource(@RequestPart FileSystemResource fileSystemResource, @PathVariable String modelId, String modelEditorSource);

    @GetExchange(MODEL_SOURCE_EXTRA)
    Mono<ResponseEntity<String>> getModelEditorSourceExtra(@PathVariable String modelId, @PathVariable String resourceId);

    @PutExchange(value=MODEL_SOURCE_EXTRA, contentType = "multipart/form-data")
    Mono<ResponseEntity<String>> setModelEditorSourceExtra(@RequestPart FileSystemResource fileSystemResource, @PathVariable String modelId, @PathVariable String resourceId, String modelEditorSourceExtra);

}
