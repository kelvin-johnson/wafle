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

import com.codernaught.wafle.api.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public class WorkflowClient {

    private WebClientWrapper webClientWrapper;
    private Settings settings;

    private DatabaseTableClient databaseTableClient;
    private DeploymentClient deploymentClient;
    private EngineClient engineClient;
    private ExecutionClient executionClient;
    private FormClient formClient;
    private GroupClient groupClient;
    private HistoryClient historyClient;
    private JobClient jobClient;
    private ModelClient modelClient;
    private ProcessDefinitionClient processDefinitionClient;
    private ProcessInstanceClient processInstanceClient;
    private RuntimeClient runtimeClient;
    private TaskClient taskClient;
    private UserClient userClient;

    private ObjectMapper mapper = new ObjectMapper();

    public WorkflowClient(WebClientWrapper webClientWrapper, Settings settings) {
        this.webClientWrapper = webClientWrapper;
        this.settings = settings;
        initClients();
    }

    private void initClients() {
        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClientWrapper.getWebClient())).build();

        databaseTableClient = httpServiceProxyFactory.createClient(DatabaseTableClient.class);
        deploymentClient = httpServiceProxyFactory.createClient(DeploymentClient.class);
        engineClient = httpServiceProxyFactory.createClient(EngineClient.class);
        executionClient = httpServiceProxyFactory.createClient(ExecutionClient.class);
        formClient = httpServiceProxyFactory.createClient(FormClient.class);
        groupClient = httpServiceProxyFactory.createClient(GroupClient.class);
        historyClient = httpServiceProxyFactory.createClient(HistoryClient.class);
        jobClient = httpServiceProxyFactory.createClient(JobClient.class);
        modelClient = httpServiceProxyFactory.createClient(ModelClient.class);
        processDefinitionClient = httpServiceProxyFactory.createClient(ProcessDefinitionClient.class);
        processInstanceClient = httpServiceProxyFactory.createClient(ProcessInstanceClient.class);
        runtimeClient = httpServiceProxyFactory.createClient(RuntimeClient.class);
        taskClient = httpServiceProxyFactory.createClient(TaskClient.class);
        userClient = httpServiceProxyFactory.createClient(UserClient.class);
    }

    // Database Table
    
    public Mono<ResponseEntity<String>> getDatabaseTables() {
        return databaseTableClient.getDatabaseTables();
    }

    
    public Mono<ResponseEntity<String>> getDatabaseTable(String tableName) {
        return databaseTableClient.getDatabaseTable(tableName);
    }

    
    public Mono<ResponseEntity<String>> getDatabaseTableColumns(String tableName) {
        return databaseTableClient.getDatabaseTableColumns(tableName);
    }

    
    public Mono<ResponseEntity<String>> getDatabaseTableData(String tableName) {
        return databaseTableClient.getDatabaseTableData(tableName);
    }

    // Process Definition


    public Mono<ResponseEntity<String>> getProcessDefinitions() {
        return processDefinitionClient.getProcessDefinitions();
    }


    public Mono<ResponseEntity<String>> getProcessDefinition(String processDefinitionId) {
        return processDefinitionClient.getProcessDefinition(processDefinitionId);
    }


    public Mono<ResponseEntity<String>> updateProcessDefinitionCategory(String processDefinitionId, String category) {
        return processDefinitionClient.updateProcessDefinitionCategory(processDefinitionId, category);
    }


    public Mono<ResponseEntity<String>> getProcessDefinitionResourceData(String processDefinitionId) {
        return processDefinitionClient.getProcessDefinitionResourceData(processDefinitionId);
    }


    public Mono<ResponseEntity<String>> getProcessDefinitionModel(String processDefinitionId) {
        return processDefinitionClient.getProcessDefinitionModel(processDefinitionId);
    }


    public Mono<ResponseEntity<String>> suspendProcessDefinition(String processDefinitionId) {
        return processDefinitionClient.suspendProcessDefinition(processDefinitionId);
    }


    public Mono<ResponseEntity<String>> activateProcessDefinition(String processDefinitionId) {
        return processDefinitionClient.activateProcessDefinition(processDefinitionId);
    }


    public Mono<ResponseEntity<String>> getProcessDefinitionCandidateStarters(String processDefinitionId) {
        return processDefinitionClient.getProcessDefinitionCandidateStarters(processDefinitionId);
    }


    public Mono<ResponseEntity<String>> addCandidateStarterUserToProcessDefinition(String processDefinitionId, String userId) {
        return null;
    }


    public Mono<ResponseEntity<String>> addCandidateStarterGroupToProcessDefinition(String processDefinitionId, String groupId) {
        return null;
    }


    public Mono<ResponseEntity<String>> deleteCandidateStarterFromProcessDefinition(String processDefinitionId, String family, String identityId) {
        return null;
    }


    public Mono<ResponseEntity<String>> getCandidateStarterFromProcessDefinition(String processDefinitionId, String family, String identityId) {
        return null;
    }

    // Deployment

    public Mono<ResponseEntity<String>> getDeployments(Map<String,String> requestParameters) {
        return deploymentClient.getDeployments(requestParameters);
    }


    public Mono<ResponseEntity<String>> createDeployment(FileSystemResource fileSystemResource, String tenantId) {
        return deploymentClient.createDeployment(fileSystemResource, tenantId);
    }


    public Mono<ResponseEntity<String>> createDeployment(FileSystemResource fileSystemResource) {
        return deploymentClient.createDeployment(fileSystemResource);
    }


    public Mono<ResponseEntity<Void>> deleteDeployment(String deploymentId) {
        return deploymentClient.deleteDeployment(deploymentId);
    }


    public Mono<ResponseEntity<String>> getDeploymentResources(String deploymentId) {
        return deploymentClient.getDeploymentResources(deploymentId);
    }


    public Mono<ResponseEntity<String>> getDeploymentResource(String deploymentId, String resourceId) {
        return deploymentClient.getDeploymentResource(deploymentId, resourceId);
    }


    public Mono<ResponseEntity<Flux<DataBuffer>>> getDeploymentResourceData(String deploymentId, String resourceId) {
        return deploymentClient.getDeploymentResourceData(deploymentId, resourceId);
    }

    //Model
    
    public Mono<ResponseEntity<String>> getModels() {
        return modelClient.getModels();
    }

    
    public Mono<ResponseEntity<String>> getModel(String modelId) {
        return modelClient.getModel(modelId);
    }

    
    public Mono<ResponseEntity<String>> createModel(String name, Map<String,String> modelInfo) {
        return modelClient.createModel(name, modelInfo);
    }

    
    public Mono<String> updateModel(String modelId) {
        return null;
    }

    
    public Mono<ResponseEntity<String>> deleteModel(String modelId) {
        return modelClient.deleteModel(modelId);
    }

    
    public Mono<ResponseEntity<String>> getModelEditorSource(String modelId) {
        return modelClient.getModelEditorSource(modelId);
    }

    
    public Mono<String> setModelEditorSource(String modelId, String modelEditorSource) {
        return null;
    }

    
    public Mono<String> getModelEditorSourceExtra(String modelId, String resourceId) {
        return null;
    }

    
    public Mono<String> setModelEditorSourceExtra(String modelId, String resourceId, String modelEditorSourceExtra) {
        return null;
    }

    //User
    
    public Mono<ResponseEntity<String>> getUsers(Map<String,String> requestParameters) {
        return userClient.getUsers(requestParameters);
    }

    
    public Mono<ResponseEntity<String>> getUser(String userId) {
        return userClient.getUser(userId);
    }

    
    public Mono<String> createUser(String userId, Map<String, String> requestParameters) {
        return null;
    }

    
    public Mono<String> deleteUser(String userId) {
        return null;
    }

    
    public Mono<ResponseEntity<Flux<DataBuffer>>> getUserPicture(String userId) {
        return userClient.getUserPicture(userId);
    }

    
    public Mono<String> getUserInfoList(String userId) {
        return null;
    }

    
    public Mono<String> getUserInfo(String userId, String key) {
        return null;
    }

    
    public Mono<String> updateUserInfo(String userId, String key, Map<String, String> requestParameters) {
        return null;
    }

    
    public Mono<String> createUserInfo(String userId, String key, Map<String, String> requestParameters) {
        return null;
    }

    
    public Mono<ResponseEntity<String>> deleteUserInfo(String userId, String key) {
        return userClient.deleteUserInfo(userId, key);
    }

    
    public Mono<ResponseEntity<Flux<DataBuffer>>> getUserPictureData(String userId) {
        return userClient.getUserPictureData(userId);
    }

    
    public Mono<ResponseEntity<String>> updateUserPicture(FileSystemResource fileSystemResource, String userId, String mimeType) {
        return userClient.updateUserPicture(fileSystemResource, userId, mimeType);
    }

    
    public String willItWork() {
        return "Wow! It works!";
    }
}

//Mono<ResponseEntity<T>>