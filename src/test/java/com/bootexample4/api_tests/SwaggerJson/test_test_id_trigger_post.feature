# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type  and AI Model 
# 
# Feature file generated for /test/{test_id}/trigger_post for http method type POST 
# RoostTestHash=bce43bf0f9
# 
# 

# ********RoostGPT********
Feature: Test Trigger API

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']

  Scenario Outline: Trigger Test with valid test_id
    Given path '/test', '<test_id>', 'trigger'
    And header Authorization = 'Bearer ' + authToken
    When method POST
    Then status 201

    Examples:
      | read('test_test_id_trigger_post.csv') |

  Scenario Outline: Trigger Test with invalid test_id
    Given path '/test', '<test_id>', 'trigger'
    And header Authorization = 'Bearer ' + authToken
    When method POST
    Then status 404
    And match response ==
      """
      {
        code: 404,
        timestamp: '#string',
        path: '/application/client/git/eaas/trigger',
        method: '#? _ == "POST"',
        message: 'Not found'
      }
      """
    And match response.timestamp == '#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d{3})?Z'

    Examples:
      | test_id     |
      | invalid_id  |
      | nonexistent |

  Scenario: Trigger Test without authorization
    Given path '/test/test123/trigger'
    When method POST
    Then status 401

  Scenario: Trigger Test with invalid authorization
    Given path '/test/test123/trigger'
    And header Authorization = 'Bearer invalid_token'
    When method POST
    Then status 401