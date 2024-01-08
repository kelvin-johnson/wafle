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

package com.codernaught.wafle;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParameterPackager {
    public static Map<String, String> packageParameters(Pair<String, String>... parameters) {
        Map<String, String> requestParameters = new HashMap<>();
        Arrays.stream(parameters).toList().forEach(p -> {
            if(p.getValue() != null && !p.getValue().isBlank() && !p.getValue().isEmpty())
                requestParameters.put(p.getKey(), p.getValue());
        });
        return requestParameters;
    }
}
