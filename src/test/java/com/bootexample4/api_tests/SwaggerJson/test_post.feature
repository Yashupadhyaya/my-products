# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type  and AI Model 
# 
# Feature file generated for /test_post for http method type POST 
# RoostTestHash=99bb15b7c8
# 
# 

# ********RoostGPT********
Here's the corrected Gherkin feature file with the parsing errors resolved:

```gherkin
Feature: Create a Test App

Background:
  * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
  * url urlBase
  * def authToken = karate.properties['AUTH_TOKEN']
  * header Authorization = 'Bearer ' + authToken

Scenario Outline: Create a new application with its configuration
  Given path '/test'
  And request
    """
    {
      "app_id": "<app_id>",
      "test_name": "<test_name>",
      "trigger_events": <trigger_events>,
      "git_ops": <git_ops>,
      "git_type": "<git_type>",
      "ai_model_info": {
        "connector_id": "<connector_id>",
        "selected_model": "<selected_model>",
        "access_token": "<access_token>",
        "gpt_model": "<gpt_model>",
        "vertex_model": {
          "title": "<vertex_model_title>",
          "key": "<vertex_model_key>"
        },
        "vertex_project_id": "<vertex_project_id>",
        "vertex_endpoint": "<vertex_endpoint>",
        "vertex_type": "<vertex_type>",
        "open_source_model_info": {
          "ip": "<open_source_ip>",
          "model_name": "<open_source_model_name>"
        },
        "claude_model": {
          "title": "<claude_model_title>",
          "key": "<claude_model_key>"
        },
        "star_chat_info": {
          "ip": "<star_chat_ip>",
          "model_name": "<star_chat_model_name>"
        },
        "llama_model_info": {
          "ip": "<llama_ip>",
          "model_name": "<llama_model_name>"
        },
        "dbrx_info": {
          "dbrx_model_name": "<dbrx_model_name>",
          "dbrx_model_endpoint": "<dbrx_model_endpoint>",
          "dbrx_auth_token": "<dbrx_auth_token>"
        },
        "azure_model_info": {
          "azure_openai_key": "<azure_openai_key>",
          "azure_deployment_name": "<azure_deployment_name>",
          "azure_endpoint": "<azure_endpoint>"
        },
        "ai_temperature": <ai_temperature>
      },
      "git_info": {
        "type": {},
        "source_repo_pr": <source_repo_pr>,
        "selected_path": "<selected_path>",
        "host_type": {},
        "user_ip": "<user_ip>",
        "source": {
          "connector_id": "<source_connector_id>",
          "access_token": "<source_access_token>",
          "selected_branch": "<source_selected_branch>",
          "username": "<source_username>",
          "org_name": "<source_org_name>",
          "repository_type": {},
          "public_repo_url": "<public_repo_url>",
          "selected_repo": {
            "key": "<source_repo_key>",
            "id": "<source_repo_id>",
            "owner": "<source_repo_owner>",
            "default_branch": "<source_repo_default_branch>",
            "project_name": "<source_repo_project_name>",
            "project_id": "<source_repo_project_id>"
          },
          "application_entrypoint": "<application_entrypoint>"
        },
        "target": {
          "connector_id": "<target_connector_id>",
          "access_token": "<target_access_token>",
          "selected_branch": "<target_selected_branch>",
          "username": "<target_username>",
          "org_name": "<target_org_name>",
          "selected_repo": {
            "key": "<target_repo_key>",
            "id": "<target_repo_id>",
            "owner": "<target_repo_owner>",
            "default_branch": "<target_repo_default_branch>",
            "project_name": "<target_repo_project_name>",
            "project_id": "<target_repo_project_id>"
          }
        },
        "max_depth": <max_depth>
      },
      "integration_info": {
        "connector_id": "<integration_connector_id>",
        "type": "<integration_type>",
        "jira_email": "<jira_email>",
        "jira_password": "<jira_password>",
        "jira_host_name": "<jira_host_name>",
        "jira_id": "<jira_id>",
        "azure_org": "<azure_org>",
        "azure_project": "<azure_project>",
        "azure_project_id": "<azure_project_id>",
        "azure_token": "<azure_token>",
        "azure_work_item_id": "<azure_work_item_id>"
      },
      "additional_info": {
        "language": "<language>",
        "packages": "<packages>",
        "iterations": "<iterations>",
        "test_type": "<test_type>",
        "test_framework": "<test_framework>",
        "java_project_type": "<java_project_type>",
        "roost_user_input": "<roost_user_input>",
        "create_api_spec": <create_api_spec>,
        "consider_existing_test": <consider_existing_test>,
        "functions_to_test": "<functions_to_test>",
        "custom_prompt": "<custom_prompt>",
        "log_type": "<log_type>",
        "log_file": {
          "file_name": "<log_file_name>",
          "file_path": "<log_file_path>",
          "file_content": "<log_file_content>"
        },
        "log_stash_type": {},
        "log_stash_api_key": "<log_stash_api_key>",
        "log_stash_url": "<log_stash_url>",
        "log_stash_username": "<log_stash_username>",
        "log_stash_token": "<log_stash_token>",
        "cloudWatchConfig": {
          "enabled": <cloudwatch_enabled>,
          "cw_region": "<cw_region>",
          "cw_credentials": {
            "enabled": <cw_credentials_enabled>,
            "credentials_input_type": "<credentials_input_type>",
            "credentials_file": {
              "file_name": "<credentials_file_name>",
              "file_content": "<credentials_file_content>"
            },
            "access_key_id": "<access_key_id>",
            "secret_access_key": "<secret_access_key>",
            "session_token": "<session_token>",
            "use_admin_creds": <use_admin_creds>
          },
          "cw_log_group_name": "<cw_log_group_name>"
        },
        "emailConfig": {
          "inviteAll": <invite_all>,
          "inviteRoosterEmails": <invite_rooster_emails>
        },
        "slackConfig": {
          "slackToken": "<slack_token>",
          "slackChannelId": "<slack_channel_id>",
          "slackChannel": {
            "title": "<slack_channel_title>",
            "key": "<slack_channel_key>"
          }
        },
        "msTeamsConfig": {
          "ms_teams_tenant_id": "<ms_teams_tenant_id>",
          "ms_teams_name": {
            "title": "<ms_teams_name_title>",
            "key": "<ms_teams_name_key>"
          },
          "ms_teams_channel": {
            "title": "<ms_teams_channel_title>",
            "key": "<ms_teams_channel_key>"
          }
        },
        "notificationTypeArray": <notification_type_array>,
        "dependency_versions": {
          "java_version": {
            "title": "<java_version_title>",
            "key": "<java_version_key>"
          },
          "go_version": {
            "title": "<go_version_title>",
            "key": "<go_version_key>"
          },
          "python_version": {
            "title": "<python_version_title>",
            "key": "<python_version_key>"
          },
          "dotnet_version": {
            "title": "<dotnet_version_title>",
            "key": "<dotnet_version_key>"
          },
          "cpp_version": {
            "title": "<cpp_version_title>",
            "key": "<cpp_version_key>"
          },
          "node_version": {
            "title": "<node_version_title>",
            "key": "<node_version_key>"
          },
          "maven_version": {
            "title": "<maven_version_title>",
            "key": "<maven_version_key>"
          },
          "gradle_version": {
            "title": "<gradle_version_title>",
            "key": "<gradle_version_key>"
          }
        },
        "apiSpec": {
          "type": "<api_spec_type>",
          "sourceType": "<api_spec_source_type>",
          "url": <api_spec_url>,
          "gitpath": <api_spec_gitpath>,
          "fileContent": <api_spec_file_content>
        },
        "behaviouralTest": {
          "type": "<behavioural_test_type>",
          "sourceType": "<behavioural_test_source_type>",
          "url": <behavioural_test_url>,
          "gitpath": <behavioural_test_gitpath>,
          "fileContent": <behavioural_test_file_content>
        },
        "http_filters": <http_filters>,
        "api_filter": "<api_filter>",
        "env_config": <env_config>,
        "use_assistant": <use_assistant>,
        "teams_connector_id": "<teams_connector_id>",
        "slack_connector_id": "<slack_connector_id>",
        "elastic_search_connector_id": "<elastic_search_connector_id>",
        "verify_test": <verify_test>,
        "vulnerability_gen": <vulnerability_gen>,
        "custom_tags": <custom_tags>
      },
      "test_timeout": <test_timeout>,
      "test_framework": "<test_framework>",
      "source_branch": "<source_branch>"
    }
    """
  When method POST
  Then status 201
  And match response contains { id: '#string' }
  And match response.user_id == '#string'
  And match response.thirdparty_app_id == '#string'
  And match response.test_name == '<test_name>'
  And match response.git_info == '#string'
  And match response.ai_model_info == '#string'
  And match response.integration_info == '#string'
  And match response.additional_info == '#string'
  And match response.trigger_events == '#string'
  And match response.created_on == '#datetime'
  And match response.updated_on == '#datetime'
  And match response.deleted == '#number'
  And match response.test_timeout == '#number'
  And match response.webhook_error == '#string'
  And match response.test_framework == '#string'
  And match response.git_type == '<git_type>'
  And match response.source_repo == '#string'
  And match response.source_branch == '<source_branch>'
  And match response.connector_ids == '#string'
  And match response.git_ops == '#number'
  And match response.labels == '#string'
  And match response.test_source == '#? _ == "jira_plugin"'

  Examples:
    | app_id | test_name | trigger_events | git_ops | git_type | connector_id | selected_model | access_token | gpt_model | vertex_model_title | vertex_model_key | vertex_project_id | vertex_endpoint | vertex_type | open_source_ip | open_source_model_name | claude_model_title | claude_model_key | star_chat_ip | star_chat_model_name | llama_ip | llama_model_name | dbrx_model_name | dbrx_model_endpoint | dbrx_auth_token | azure_openai_key | azure_deployment_name | azure_endpoint | ai_temperature | source_repo_pr | selected_path | user_ip | source_connector_id | source_access_token | source_selected_branch | source_username | source_org_name | public_repo_url | source_repo_key | source_repo_id | source_repo_owner | source_repo_default_branch | source_repo_project_name | source_repo_project_id | application_entrypoint | target_connector_id | target_access_token | target_selected_branch | target_username | target_org_name | target_repo_key | target_repo_id | target_repo_owner | target_repo_default_branch | target_repo_project_name | target_repo_project_id | max_depth | integration_connector_id | integration_type | jira_email | jira_password | jira_host_name | jira_id | azure_org | azure_project | azure_project_id | azure_token | azure_work_item_id | language | packages | iterations | test_type | test_framework | java_project_type | roost_user_input | create_api_spec | consider_existing_test | functions_to_test | custom_prompt | log_type | log_file_name | log_file_path | log_file_content | log_stash_api_key | log_stash_url | log_stash_username | log_stash_token | cloudwatch_enabled | cw_region | cw_credentials_enabled | credentials_input_type | credentials_file_name | credentials_file_content | access_key_id | secret_access_key | session_token | use_admin_creds | cw_log_group_name | invite_all | invite_rooster_emails | slack_token | slack_channel_id | slack_channel_title | slack_channel_key | ms_teams_tenant_id | ms_teams_name_title | ms_teams_name_key | ms_teams_channel_title | ms_teams_channel_key | notification_type_array | java_version_title | java_version_key | go_version_title | go_version_key | python_version_title | python_version_key | dotnet_version_title | dotnet_version_key | cpp_version_title | cpp_version_key | node_version_title | node_version_key | maven_version_title | maven_version_key | gradle_version_title | gradle_version_key | api_spec_type | api_spec_source_type | api_spec_url | api_spec_gitpath | api_spec_file_content | behavioural_test_type | behavioural_test_source_type | behavioural_test_url | behavioural_test_gitpath | behavioural_test_file_content | http_filters | api_filter | env_config | use_assistant | teams_connector_id | slack_connector_id | elastic_search_connector_id | verify_test | vulnerability_gen | custom_tags | test_timeout | test_framework | source_branch |
    | 'app1' | 'Test 1' | ['push', 'pr_create'] | true | 'github' | 'conn1' | 'openai' | 'token123' | 'gpt-3' | 'Vertex Model 1' | 'vm1' | 'proj1' | 'endpoint1' | 'type1' | '192.168.1.1' | 'OpenModel1' | 'Claude Model 1' | 'cm1' | '192.168.1.2' | 'StarChat1' | '192.168.1.3' | 'Llama1' | 