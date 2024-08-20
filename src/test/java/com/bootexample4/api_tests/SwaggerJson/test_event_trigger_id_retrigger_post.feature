# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type Claude AI and AI Model claude-3-5-sonnet-20240620
# 
# Feature file generated for /test/event/{trigger_id}/retrigger_post for http method type POST 
# RoostTestHash=cf104756c6
# 
# 

# ********RoostGPT********
Feature: Test RoostGPT Retrigger Endpoint

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']

  Scenario Outline: Retrigger event with valid input
    Given path '/test/event', '<trigger_id>', 'retrigger'
    And header Authorization = 'Bearer ' + authToken
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

  Scenario: Retrigger event with invalid trigger_id
    Given path '/test/event', 'invalid_id', 'retrigger'
    And header Authorization = 'Bearer ' + authToken
    And request
      """
      {
        "improve_test": true,
        "file_path": ["path1"],
        "user_content": "Invalid content",
        "testscript_endpoint": "/api/test/script",
        "git_pr_url": "https://github.com/user/repo/pull/3"
      }
      """
    When method POST
    Then status 404
    And match response contains
      """
      {
        "code": 404,
        "timestamp": "#string",
        "path": "/test/event/invalid_id/retrigger",
        "method": "POST",
        "message": "Not found"
      }
      """
    And match response.timestamp == '#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d{3})?Z'

  Scenario: Retrigger event with missing required fields
    Given path '/test/event', 'abc123', 'retrigger'
    And header Authorization = 'Bearer ' + authToken
    And request
      """
      {
        "improve_test": true,
        "file_path": ["path1"]
      }
      """
    When method POST
    Then status 400

  Scenario: Retrigger event with invalid data types
    Given path '/test/event', 'abc123', 'retrigger'
    And header Authorization = 'Bearer ' + authToken
    And request
      """
      {
        "improve_test": "not_a_boolean",
        "file_path": "not_an_array",
        "user_content": 123,
        "testscript_endpoint": true,
        "git_pr_url": ["not_a_string"]
      }
      """
    When method POST
    Then status 400

  Scenario: Retrigger event without authorization
    Given path '/test/event', 'abc123', 'retrigger'
    And request
      """
      {
        "improve_test": true,
        "file_path": ["path1"],
        "user_content": "Test content",
        "testscript_endpoint": "/api/test/script",
        "git_pr_url": "https://github.com/user/repo/pull/1"
      }
      """
    When method POST
    Then status 401
