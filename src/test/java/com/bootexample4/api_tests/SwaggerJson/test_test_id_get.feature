# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type  and AI Model 
# 
# Feature file generated for /test/{test_id}_get for http method type GET 
# RoostTestHash=7f22b8b745
# 
# 

# ********RoostGPT********
Feature: Test GPT Controller - Get One Test

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']

  Scenario Outline: Get One Test with different test_id
    Given path 'test', <test_id>
    And header Authorization = 'Bearer ' + authToken
    When method GET
    Then status 200

    Examples:
      | read('test_test_id_get.csv') |

  Scenario: Get One Test with invalid test_id
    Given path 'test', 'invalid_id'
    And header Authorization = 'Bearer ' + authToken
    When method GET
    Then status 404
    And match response ==
      """
      {
        code: '#number',
        timestamp: '#string',
        path: '#string',
        method: '#regex ^GET|DELETE|HEAD|OPTIONS|POST|PUT|PATCH|PURGE|LINK|UNLINK$',
        message: '#string'
      }
      """
    And match response.code == 404
    And match response.path contains '/test/'
    And match response.method == 'GET'
    And match response.message == 'Not found'

  Scenario: Get One Test without authorization
    Given path 'test', 'test123'
    When method GET
    Then status 401

  Scenario: Get One Test with invalid authorization
    Given path 'test', 'test123'
    And header Authorization = 'Bearer invalid_token'
    When method GET
    Then status 401
