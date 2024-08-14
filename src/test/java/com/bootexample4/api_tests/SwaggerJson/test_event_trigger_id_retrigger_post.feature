# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type Claude AI and AI Model claude-3-5-sonnet-20240620
# 
# Feature file generated for /test/event/{trigger_id}/retrigger_post for http method type POST 
# RoostTestHash=cf104756c6
# 
# 

# ********RoostGPT********
Feature: Test GPT Controller Retrigger Endpoint

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']
    * header Authorization = 'Bearer ' + authToken

  Scenario Outline: Retrigger an event with valid trigger_id and request body
    Given path '/test/event', '<trigger_id>', 'retrigger'
    And request
      """
      {
        "improve_test": <improve_test>,
        "file_path": <file_path>,
        "user_content": "<user_content>",
        "testscript_endpoint": "<testscript_endpoint>",
        "git_pr_url": "<git_pr_url>"
      }
      """
    When method POST
    Then status 201

    Examples:
      | read('test_event_trigger_id_retrigger_post.csv') |

  Scenario: Retrigger an event with invalid trigger_id
    Given path '/test/event', 'invalid_id', 'retrigger'
    And request
      """
      {
        "improve_test": true,
        "file_path": ["path1"],
        "user_content": "Test content",
        "testscript_endpoint": "/api/test",
        "git_pr_url": "https://github.com/user/repo"
      }
      """
    When method POST
    Then status 404
    And match response ==
      """
      {
        "code": 404,
        "timestamp": "#string",
        "path": "/application/client/git/eaas/trigger",
        "method": "#? _.includes(['GET', 'DELETE', 'HEAD', 'OPTIONS', 'POST', 'PUT', 'PATCH', 'PURGE', 'LINK', 'UNLINK'])",
        "message": "Not found"
      }
      """
    And match response.timestamp == '#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.*'

  Scenario: Retrigger an event with missing required fields
    Given path '/test/event', 'abc123', 'retrigger'
    And request
      """
      {
        "improve_test": true,
        "file_path": ["path1"]
      }
      """
    When method POST
    Then status 400

  Scenario: Retrigger an event with invalid data types
    Given path '/test/event', 'abc123', 'retrigger'
    And request
      """
      {
        "improve_test": "not a boolean",
        "file_path": "not an array",
        "user_content": 123,
        "testscript_endpoint": true,
        "git_pr_url": ["not a string"]
      }
      """
    When method POST
    Then status 400
