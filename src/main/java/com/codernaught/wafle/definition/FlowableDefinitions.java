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

package com.codernaught.wafle.definition;

public class FlowableDefinitions {

    public static final String DEFAULT_BASE_URL                 = "http://localhost:8080";
    public static final String DEFAULT_FLOWABLE_BASE_API_URL    = "/flowable-rest";
    public static final String DEFAULT_ACTIVITI_BASE_API_URL    = "/activiti-rest";
    public static final String DEFAULT_CAMUNDA_BASE_API_URL     = "/";


    //Database
    public static final String DATABASE_TABLES                    = "/service/management/tables";
    public static final String DATABASE_TABLE                     = "/service/management/tables/{tableName}";
    public static final String DATABASE_COLUMN_FOR_SINGLE_TABLE   = "/service/management/tables/{tableName}/columns";
    public static final String DATABASE_DATA_FOR_SINGLE_ROW       = "/service/management/tables/{tableName}/data";


    //Deployment
    public static final String DEPLOYMENTS                = "/service/repository/deployments";
    public static final String DEPLOYMENT                 = "/service/repository/deployments/{deploymentId}";
    public static final String DEPLOYMENT_RESOURCES       = "/service/repository/deployments/{deploymentId}/resources";
    public static final String DEPLOYMENT_RESOURCE        = "/service/repository/deployments/{deploymentId}/resources/{resourceId}";
    public static final String DEPLOYMENT_RESOURCE_DATA   = "/service/repository/deployments/{deploymentId}/resourcedata/{resourceId}";


    //Engine
    public static final String ENGINE_MANAGEMENT_PROPERTIES = "/service/management/properties";
    public static final String ENGINE_MANAGEMENT_ENGINE     = "/service/management/engine";


    //Execution
    public static final String EXECUTIONS                   = "/service/runtime/executions";
    public static final String EXECUTION                    = "/service/runtime/executions/{executionId}";
    public static final String EXECUTION_QUERY              = "/service/query/executions";
    public static final String EXECUTION_ACTIVITIES         = "/service/runtime/executions/{executionId}/activities";
    public static final String EXECUTION_VARIABLES          = "/service/runtime/executions/{executionId}/variables";
    public static final String EXECUTION_VARIABLE           = "/service/runtime/executions/{executionId}/variables/{variableName}";


    //Process Definitions
    public static final String PROCESS_DEFINITIONS                      = "/service/repository/process-definitions";
    public static final String PROCESS_DEFINITION                       = "/service/repository/process-definitions/{processDefinitionId}";
    public static final String PROCESS_DEFINITION_RESOURCES_DATA        = "/service/repository/process-definitions/{processDefinitionId}/resourcedata";
    public static final String PROCESS_DEFINITION_MODEL                 = "/service/repository/process-definitions/{processDefinitionId}/model";
    public static final String PROCESS_DEFINITION_CANDIDATE_STARTERS    = "/service/repository/process-definitions/{processDefinitionId}/identitylinks";
    public static final String PROCESS_DEFINITION_CANDIDATE_STARTER     = "/service/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}";


    //Process Instances
    public static final String PROCESS_INSTANCES                            = "/service/runtime/process-instances";
    public static final String PROCESS_INSTANCE                             = "/service/runtime/process-instances/{processInstanceId}";
    public static final String PROCESS_INSTANCE_DIAGRAM                     = "/service/runtime/process-instances/{processInstanceId}/diagram";
    public static final String PROCESS_INSTANCE_VARIABLES                   = "/service/runtime/process-instances/{processInstanceId}/variables";
    public static final String PROCESS_INSTANCE_VARIABLE                    = "/service/runtime/process-instances/{processInstanceId}/variables/{variableName}";
    public static final String PROCESS_INSTANCE_IDENTITYLINKS               = "/service/runtime/process-instances/{processInstanceId}/identitylinks";
    public static final String PROCESS_INSTANCE_REMOVE_USER                 = "/service/runtime/process-instances/{processInstanceId}/identitylinks/users/{userId}/{type}";
    public static final String PROCESS_INSTANCE_QUERY                       = "/service/query/process-instances";

    //Models
    public static final String MODELS                      = "/service/repository/models";
    public static final String MODEL                       = "/service/repository/models/{modelId}";
    public static final String MODEL_SOURCE                = "/service/repository/models/{modelId}/source";
    public static final String MODEL_SOURCE_EXTRA          = "/service/repository/models/{modelId}/source-extra";

    //Jobs
    public static final String JOBS                             = "/service/management/jobs";
    public static final String JOB                              = "/service/management/jobs/{jobId}";
    public static final String JOB_EXCEPTION_STACK              = "/service/management/jobs/{jobId}/exception-stacktrace";
    public static final String DEADLETTER_JOBS                  = "/service/management/deadletter-jobs";
    public static final String DEADLETTER_JOB                   = "/service/management/deadletter-jobs/{jobId}";
    public static final String DEADLETTER_JOB_EXCEPTION_STACK   = "/service/management/deadletter-jobs/{jobId}/exception-stacktrace";

    //Tasks
    public static final String TASKS                        = "/service/runtime/tasks";
    public static final String TASK                         = "/service/runtime/tasks/{taskId}";
    public static final String TASK_QUERY                   = "/service/query/tasks";

    public static final String TASK_VARIABLES               = "/service/runtime/tasks/{taskId}/variables";
    public static final String TASK_VARIABLE                = "/service/runtime/tasks/{taskId}/variables/{variableName}";
    public static final String TASK_VARIABLE_DATA           = "/service/runtime/tasks/{taskId}/variables/{variableName}/data";
    public static final String TASK_IDENTITY_LINKS          = "/service/runtime/tasks/{taskId}/identitylinks";
    

    //Users
    public static final String USERS            = "/service/identity/users";
    public static final String USER             = "/service/identity/users/{userId}";
    public static final String USER_PICTURE     = "/service/identity/users/{userId}/picture";
    public static final String USER_INFO_LIST   = "/service/identity/users/{userId}/info";
    public static final String USER_INFO        = "/service/identity/users/{userId}/info/{key}";


    //Groups
    public static final String GROUPS               = "/service/identity/groups";
    public static final String GROUP                = "/service/identity/groups/{groupId}";
    public static final String GROUP_MEMBERS_ADD    = "/service/identity/groups/{groupId}/members";
    public static final String GROUP_MEMBER_DELETE  = "/service/identity/groups/{groupId}/members/{userId}";


    //Forms
    public static final String FORM_DEFINITIONS              = "/service/form/form-data";


    //Runtime
    public static final String RUNTIME_SIGNALS               = "/service/runtime/signals";


    public static final String TENANTS              = "";
    public static final String NAME                 = "name";
    public static final String NAME_LIKE            = "nameLike";
    public static final String CATEGORY             = "category";
    public static final String CATEGORY_NOT_EQUALS  = "categoryNotEquals";
    public static final String TENANT_ID            = "tenantId";
    public static final String TENANT_ID_LIKE       = "tenantIdLike";
    public static final String WITHOUT_TENANT_ID    = "withoutTenantId";
    public static final String SORT                 = "sort";
    public static final String START                = "start";
    public static final String SIZE                 = "size";

    public static final String ID                   = "id";
    public static final String FIRST_NAME           = "firstName";
    public static final String LAST_NAME            = "lastName";
    public static final String EMAIL                = "email";
    public static final String FIRST_NAME_LIKE      = "firstNameLike";
    public static final String LAST_NAME_LIKE       = "lastNameLike";
    public static final String EMAIL_LIKE           = "emailLike";
    public static final String MEMBER_OF_GROUP      = "memberOfGroup";
    public static final String POTENTIAL_STARTER    = "potentialStarter";
}
