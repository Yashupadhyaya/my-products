# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type  and AI Model 
# 
# Feature file generated for /test/{test_id}_patch for http method type PATCH 
# RoostTestHash=d7c0e01b63
# 
# 

# ********RoostGPT********
Feature: Edit Test API

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']
    * header Authorization = 'Bearer ' + authToken

  Scenario Outline: Edit test with valid input
    Given path '/test', <test_id>
    And request
      """
      {
        "ai_model_info": {
          "selected_model": "<selected_model>",
          "vertex_model": {
            "title": "Vertex Model",
            "key": "vertex-key"
          },
          "open_source_model_info": {
            "ip": "192.168.1.1",
            "model_name": "open-source-model"
          },
          "claude_model": {
            "title": "Claude Model",
            "key": "claude-key"
          },
          "star_chat_info": {
            "ip": "192.168.1.2",
            "model_name": "star-chat-model"
          },
          "llama_model_info": {
            "ip": "192.168.1.3",
            "model_name": "llama-model"
          },
          "dbrx_info": {
            "dbrx_model_name": "dbrx-model"
          },
          "azure_model_info": {
            "azure_openai_key": "azure-key",
            "azure_deployment_name": "azure-deployment",
            "azure_endpoint": "https://azure-endpoint.com"
          }
        },
        "git_info": {
          "type": {},
          "source_repo_pr": true,
          "selected_path": "/path/to/repo",
          "host_type": {},
          "source": {
            "access_token": "source-token",
            "selected_branch": "main",
            "repository_type": {},
            "selected_repo": {
              "key": "repo-key",
              "title": "Repo Title",
              "id": "repo-id",
              "owner": "repo-owner",
              "default_branch": "main"
            }
          },
          "target": {
            "access_token": "target-token",
            "selected_branch": "develop",
            "selected_repo": {
              "key": "target-repo-key",
              "title": "Target Repo Title",
              "id": "target-repo-id",
              "owner": "target-repo-owner",
              "default_branch": "main"
            }
          },
          "max_depth": 5
        },
        "integration_info": {
          "type": "<integration_type>"
        },
        "additional_info": {
          "language": "java",
          "iterations": "3",
          "test_type": "<test_type>",
          "log_type": "file",
          "log_file": {
            "file_name": "test.log",
            "file_path": "/logs/",
            "file_content": "Log content"
          },
          "dependency_versions": {
            "java_version": {
              "title": "Java 11",
              "key": "11"
            }
          },
          "apiSpec": {
            "type": "openapi",
            "sourceType": "url",
            "url": ["https://api-spec.com"],
            "gitpath": ["/path/to/spec"],
            "fileContent": []
          },
          "behaviouralTest": {
            "type": "cucumber",
            "sourceType": "git",
            "url": [],
            "gitpath": ["/path/to/behavioural"],
            "fileContent": []
          },
          "env_config": [
            {
              "key": "ENV_VAR",
              "value": "env_value",
              "type": "string",
              "secret": false
            }
          ]
        },
        "test_timeout": 3600,
        "trigger_events": ["push", "pull_request"],
        "test_framework": "junit",
        "git_type": "github",
        "source_branch": "feature/new-test",
        "git_ops": true
      }
      """
    When method PUT
    Then status 200

    Examples:
      | read('test_test_id_patch.csv') |

  Scenario: Edit test with invalid test_id
    Given path '/test', 'invalid-id'
    And request
      """
      {
        "ai_model_info": {
          "selected_model": "openai",
          "vertex_model": {
            "title": "Vertex Model",
            "key": "vertex-key"
          },
          "open_source_model_info": {
            "ip": "192.168.1.1",
            "model_name": "open-source-model"
          },
          "claude_model": {
            "title": "Claude Model",
            "key": "claude-key"
          },
          "star_chat_info": {
            "ip": "192.168.1.2",
            "model_name": "star-chat-model"
          },
          "llama_model_info": {
            "ip": "192.168.1.3",
            "model_name": "llama-model"
          },
          "dbrx_info": {
            "dbrx_model_name": "dbrx-model"
          },
          "azure_model_info": {
            "azure_openai_key": "azure-key",
            "azure_deployment_name": "azure-deployment",
            "azure_endpoint": "https://azure-endpoint.com"
          }
        },
        "git_info": {
          "type": {},
          "source_repo_pr": true,
          "selected_path": "/path/to/repo",
          "host_type": {},
          "source": {
            "access_token": "source-token",
            "selected_branch": "main",
            "repository_type": {},
            "selected_repo": {
              "key": "repo-key",
              "title": "Repo Title",
              "id": "repo-id",
              "owner": "repo-owner",
              "default_branch": "main"
            }
          },
          "target": {
            "access_token": "target-token",
            "selected_branch": "develop",
            "selected_repo": {
              "key": "target-repo-key",
              "title": "Target Repo Title",
              "id": "target-repo-id",
              "owner": "target-repo-owner",
              "default_branch": "main"
            }
          },
          "max_depth": 5
        },
        "integration_info": {
          "type": "jira"
        },
        "additional_info": {
          "language": "java",
          "iterations": "3",
          "test_type": "unit",
          "log_type": "file",
          "log_file": {
            "file_name": "test.log",
            "file_path": "/logs/",
            "file_content": "Log content"
          },
          "dependency_versions": {
            "java_version": {
              "title": "Java 11",
              "key": "11"
            }
          },
          "apiSpec": {
            "type": "openapi",
            "sourceType": "url",
            "url": ["https://api-spec.com"],
            "gitpath": ["/path/to/spec"],
            "fileContent": []
          },
          "behaviouralTest": {
            "type": "cucumber",
            "sourceType": "git",
            "url": [],
            "gitpath": ["/path/to/behavioural"],
            "fileContent": []
          },
          "env_config": [
            {
              "key": "ENV_VAR",
              "value": "env_value",
              "type": "string",
              "secret": false
            }
          ]
        },
        "test_timeout": 3600,
        "trigger_events": ["push", "pull_request"],
        "test_framework": "junit",
        "git_type": "github",
        "source_branch": "feature/new-test",
        "git_ops": true
      }
      """
    When method PUT
    Then status 404
    And match response contains { code: 404, message: 'Not found' }
    And match response.path == '/test/invalid-id'
    And match response.method == 'PUT'

  Scenario: Edit test with missing required fields
    Given path '/test', 'test-123'
    And request
      """
      {
        "ai_model_info": {
          "selected_model": "openai"
        },
        "git_info": {
          "type": {},
          "source_repo_pr": true,
          "selected_path": "/path/to/repo",
          "host_type": {},
          "source": {
            "access_token": "source-token",
            "selected_branch": "main",
            "repository_type": {},
            "selected_repo": {
              "key": "repo-key",
              "title": "Repo Title",
              "id": "repo-id",
              "owner": "repo-owner",
              "default_branch": "main"
            }
          },
          "target": {
            "access_token": "target-token",
            "selected_branch": "develop",
            "selected_repo": {
              "key": "target-repo-key",
              "title": "Target Repo Title",
              "id": "target-repo-id",
              "owner": "target-repo-owner",
              "default_branch": "main"
            }
          },
          "max_depth": 5
        },
        "integration_info": {
          "type": "jira"
        },
        "additional_info": {
          "language": "java",
          "iterations": "3",
          "test_type": "unit",
          "log_type": "file",
          "log_file": {
            "file_name": "test.log",
            "file_path": "/logs/",
            "file_content": "Log content"
          },
          "dependency_versions": {
            "java_version": {
              "title": "Java 11",
              "key": "11"
            }
          },
          "apiSpec": {
            "type": "openapi",
            "sourceType": "url",
            "url": ["https://api-spec.com"],
            "gitpath": ["/path/to/spec"],
            "fileContent": []
          },
          "behaviouralTest": {
            "type": "cucumber",
            "sourceType": "git",
            "url": [],
            "gitpath": ["/path/to/behavioural"],
            "fileContent": []
          },
          "env_config": [
            {
              "key": "ENV_VAR",
              "value": "env_value",
              "type": "string",
              "secret": false
            }
          ]
        },
        "test_timeout": 3600,
        "trigger_events": ["push", "pull_request"],
        "test_framework": "junit",
        "git_type": "github",
        "source_branch": "feature/new-test",
        "git_ops": true
      }
      """
    When method PUT
    Then status 400
    And match response contains { message: '#regex .*required.*' }