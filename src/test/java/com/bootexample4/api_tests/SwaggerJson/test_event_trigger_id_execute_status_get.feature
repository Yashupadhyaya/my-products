# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type  and AI Model 
# 
# Feature file generated for /test/event/{trigger_id}/execute/status_get for http method type GET 
# RoostTestHash=3f0e45dce7
# 
# 

# ********RoostGPT********
Feature: Test Execution File Status

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']

  Scenario Outline: Get test execution file status
    Given path '/test/event', '<trigger_id>', 'execute/status'
    And param file_path = '<file_path>'
    And header Authorization = 'Bearer ' + authToken
    When method GET
    Then status 200
    And match response == '#string'

    Examples:
      | read('test_event_trigger_id_execute_status_get.csv') |

  Scenario Outline: Get test execution file status - Error cases
    Given path '/test/event', '<trigger_id>', 'execute/status'
    And param file_path = '<file_path>'
    And header Authorization = 'Bearer ' + authToken
    When method GET
    Then status <status_code>
    And match response ==
      """
      {
        code: '#number',
        timestamp: '#string',
        path: '#string',
        method: '#string',
        message: '#string'
      }
      """
    And match response.code == <status_code>
    And match response.timestamp == '#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d{3})?Z'
    And match response.path contains '/test/event'
    And match response.method == 'GET'
    And match response.message == '#present'

    Examples:
      | read('test_event_trigger_id_execute_status_get.csv') |

  Scenario: Get test execution file status - Missing required parameters
    Given path '/test/event/trigger1/execute/status'
    And header Authorization = 'Bearer ' + authToken
    When method GET
    Then status 400
    And match response ==
      """
      {
        code: '#number',
        timestamp: '#string',
        path: '#string',
        method: '#string',
        message: '#string'
      }
      """
    And match response.code == 400
    And match response.timestamp == '#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d{3})?Z'
    And match response.path contains '/test/event'
    And match response.method == 'GET'
    And match response.message == '#present'
