# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type  and AI Model 
# 
# Feature file generated for /test/event_get for http method type GET 
# RoostTestHash=4f773e2b60
# 
# 

# ********RoostGPT********
Feature: Test GET /test/event endpoint

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']
    * header Authorization = 'Bearer ' + authToken

  Scenario Outline: Get all events with different query parameters
    Given path '/test/event'
    And param searchTerm = '<searchTerm>'
    And param take = '<take>'
    And param skip = '<skip>'
    And param test_id = '<test_id>'
    And param status_filter = <status_filter>
    And param order_by = '<order_by>'
    And param time_filter = '<time_filter>'
    And param label_filter = <label_filter>
    When method GET
    Then status 200
    And match response == '#object'

    Examples:
      | read('test_event_get.csv') |

  Scenario: Get all events with invalid search term
    Given path '/test/event'
    And param searchTerm = 'ab'
    When method GET
    Then status 400
    And match response contains { code: 400, message: '#string' }

  Scenario: Get all events with invalid status filter
    Given path '/test/event'
    And param status_filter = ['invalid_status']
    When method GET
    Then status 400
    And match response contains { code: 400, message: '#string' }

  Scenario: Get all events with invalid order by
    Given path '/test/event'
    And param order_by = 'invalid_order'
    When method GET
    Then status 400
    And match response contains { code: 400, message: '#string' }

  Scenario: Get all events with invalid time filter
    Given path '/test/event'
    And param time_filter = 'Last-60Days'
    When method GET
    Then status 400
    And match response contains { code: 400, message: '#string' }

  Scenario: Get all events without authentication
    Given path '/test/event'
    And header Authorization = ''
    When method GET
    Then status 401
    And match response contains { code: 401, message: '#string' }
