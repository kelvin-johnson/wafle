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

import org.springframework.http.ResponseEntity;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface EngineClient {
    static final String ENGINE_MANAGEMENT_PROPERTIES = "/service/management/properties";
    static final String ENGINE_MANAGEMENT_ENGINE     = "/service/management/engine";

    @GetExchange(value = ENGINE_MANAGEMENT_PROPERTIES)
    Mono<ResponseEntity<String>> getEngineProperties();

    @GetExchange(value = ENGINE_MANAGEMENT_ENGINE)
    Mono<ResponseEntity<String>> getEngine();

}
