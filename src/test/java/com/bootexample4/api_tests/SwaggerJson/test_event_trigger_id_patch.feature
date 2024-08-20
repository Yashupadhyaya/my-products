# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type Claude AI and AI Model claude-3-5-sonnet-20240620
# 
# Feature file generated for /test/event/{trigger_id}_patch for http method type PATCH 
# RoostTestHash=1f062a2277
# 
# 

# ********RoostGPT********
Feature: Test GPT Controller - Edit Trigger Event

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']

  Scenario Outline: Edit Trigger Event Successfully
    Given path '/test/event', <trigger_id>
    And header Authorization = 'Bearer ' + authToken
    And request
      """
      {
        "status": <status>,
        "status_details": <status_details>,
        "completion_time": <completion_time>,
        "modification_time": <modification_time>,
        "test_endpoints": <test_endpoints>,
        "test_report": <test_report>
      }
      """
    When method PUT
    Then status 200

    Examples:
      | read('test_event_trigger_id_patch.csv') |

  Scenario: Edit Trigger Event with Invalid Request
    Given path '/test/event', 'invalid_id'
    And header Authorization = 'Bearer ' + authToken
    And request
      """
      {
        "status": "unknown",
        "status_details": "Invalid status",
        "completion_time": "invalid_time",
        "modification_time": "invalid_time",
        "test_endpoints": 123,
        "test_report": null
      }
      """
    When method PUT
    Then status 400
    And match response contains { code: 400, message: '#string' }
    And match response.timestamp == '#present'
    And match response.path == '/test/event/invalid_id'
    And match response.method == 'PUT'

  Scenario: Edit Trigger Event for Non-existent ID
    Given path '/test/event', 'non_existent_id'
    And header Authorization = 'Bearer ' + authToken
    And request
      """
      {
        "status": "success",
        "status_details": "Completed",
        "completion_time": "2023-05-17T09:00:00Z",
        "modification_time": "2023-05-17T09:05:00Z",
        "test_endpoints": "/api/v3/test",
        "test_report": "All tests passed"
      }
      """
    When method PUT
    Then status 404
    And match response contains { code: 404, message: 'Not found' }
    And match response.timestamp == '#present'
    And match response.path == '/test/event/non_existent_id'
    And match response.method == 'PUT'

  Scenario: Edit Trigger Event without Authorization
    Given path '/test/event', 'abc123'
    And request
      """
      {
        "status": "success",
        "status_details": "Completed",
        "completion_time": "2023-05-18T11:00:00Z",
        "modification_time": "2023-05-18T11:05:00Z",
        "test_endpoints": "/api/v4/test",
        "test_report": "All tests passed"
      }
      """
    When method PUT
    Then status 401
    And match response contains { code: 401, message: '#string' }
    And match response.timestamp == '#present'
    And match response.path == '/test/event/abc123'
    And match response.method == 'PUT'
