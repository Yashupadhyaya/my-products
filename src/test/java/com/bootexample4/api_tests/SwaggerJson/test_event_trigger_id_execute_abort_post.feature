# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type Claude AI and AI Model claude-3-5-sonnet-20240620
# 
# Feature file generated for /test/event/{trigger_id}/execute/abort_post for http method type POST 
# RoostTestHash=a21516c35c
# 
# 

# ********RoostGPT********
Feature: Abort Test Execution

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']

  Scenario Outline: Abort test execution for a trigger
    Given path '/test/event', '<trigger_id>', 'execute/abort'
    And header Authorization = 'Bearer ' + authToken
    When method POST
    Then status 201
    And match response == '#string'

    Examples:
      | read('test_event_trigger_id_execute_abort_post.csv') |

  Scenario Outline: Abort test execution with invalid trigger ID
    Given path '/test/event', '<trigger_id>', 'execute/abort'
    And header Authorization = 'Bearer ' + authToken
    When method POST
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
    And match response.timestamp contains '-'
    And match response.path contains '/test/event/'
    And match response.method == 'POST'
    And match response.message == '#present'

    Examples:
      | read('test_event_trigger_id_execute_abort_post.csv') |

  Scenario: Abort test execution without authentication
    Given path '/test/event/some_trigger_id/execute/abort'
    When method POST
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
    And match response.timestamp contains '-'
    And match response.path contains '/test/event/'
    And match response.method == 'POST'
    And match response.message == '#present'
