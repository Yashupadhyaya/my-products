# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type Claude AI and AI Model claude-3-5-sonnet-20240620
# 
# Feature file generated for /test/event/{trigger_id}/logs_get for http method type GET 
# RoostTestHash=053c7d36b6
# 
# 

# ********RoostGPT********
Feature: Test RoostGPT API - Get Logs for Trigger

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']

  Scenario Outline: Get logs for a trigger
    Given path '/test/event', '<trigger_id>', 'logs'
    And header Authorization = 'Bearer ' + authToken
    When method GET
    Then status 200
    And match response == '#object'

    Examples:
      | read('test_event_trigger_id_logs_get.csv') |

  Scenario Outline: Get logs for a trigger - Error cases
    Given path '/test/event', '<trigger_id>', 'logs'
    And header Authorization = 'Bearer ' + authToken
    When method GET
    Then status <status_code>
    And match response ==
      """
      {
        code: '#number',
        timestamp: '#string',
        path: '#string',
        method: '#enum',
        message: '#string'
      }
      """
    And match response.code == <status_code>
    And match response.timestamp == '#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}'
    And match response.path contains '/test/event'
    And match response.method == 'GET'
    And match response.message == '#present'

    Examples:
      | read('test_event_trigger_id_logs_get.csv') |

  Scenario: Get logs for a trigger - Missing Authorization
    Given path '/test/event/trigger1/logs'
    When method GET
    Then status 401
