# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type Claude AI and AI Model claude-3-5-sonnet-20240620
# 
# Feature file generated for /test/event/{trigger_id}/execute/report_get for http method type GET 
# RoostTestHash=25919140f7
# 
# 

# ********RoostGPT********
Feature: Test Execution Report API

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']

  Scenario Outline: Get test execution report
    Given path '/test/event', '<trigger_id>', 'execute/report'
    And param file_choice = '<file_choice>'
    And param file_path = '<file_path>'
    And header Authorization = 'Bearer ' + authToken
    When method GET
    Then status 200
    And match response == '#object'
    And match header Content-Type == 'application/json'

    Examples:
      | read('test_event_trigger_id_execute_report_get.csv') |

  Scenario Outline: Get test execution report - Error cases
    Given path '/test/event', '<trigger_id>', 'execute/report'
    And param file_choice = '<file_choice>'
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
    And match response.path contains '/test/event'
    And match response.method == 'GET'

    Examples:
      | read('test_event_trigger_id_execute_report_get.csv') |

  Scenario: Get test execution report - Missing required parameters
    Given path '/test/event', 'trigger5', 'execute/report'
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
    And match response.path contains '/test/event'
    And match response.method == 'GET'

  Scenario: Get test execution report - Unauthorized access
    Given path '/test/event', 'trigger6', 'execute/report'
    And param file_choice = 'option1'
    And param file_path = '/path/to/file'
    When method GET
    Then status 401
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
    And match response.code == 401
    And match response.path contains '/test/event'
    And match response.method == 'GET'
