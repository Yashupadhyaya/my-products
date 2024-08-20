# ********RoostGPT********

# Test generated by RoostGPT for test test-roostapispec-1 using AI Type Claude AI and AI Model claude-3-5-sonnet-20240620
# 
# Feature file generated for /test_get for http method type GET 
# RoostTestHash=c82b34f0b0
# 
# 

# ********RoostGPT********
Feature: Test API endpoints

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * header Authorization = 'Bearer ' + karate.properties['AUTH_TOKEN']

  Scenario: Get all tests
    Given path '/test'
    And param get_for_all = 'true'
    And param searchTerm = 'test'
    And param take = '10'
    And param skip = '0'
    When method GET
    Then status 200
    And match response.control.code == '200'
    And match response.control.message == 'OK'
    And match response.control.type == 'S'

  Scenario Outline: Get all tests with invalid parameters
    Given path '/test'
    And param get_for_all = '<get_for_all>'
    And param searchTerm = '<searchTerm>'
    And param take = '<take>'
    And param skip = '<skip>'
    When method GET
    Then status 400
    And match response.control.code == '400'
    And match response.control.message == 'Bad Request'
    And match response.control.type == 'E'

    Examples:
      | get_for_all | searchTerm | take | skip |
      | invalid     | test       |   10 |    0 |
      | true        | te         |   10 |    0 |
      | true        | test       | abc  |    0 |
      | true        | test       |   10 | abc  |

  Scenario: Get all tests with optional label filter
    Given path '/test'
    And param get_for_all = 'true'
    And param searchTerm = 'test'
    And param take = '10'
    And param skip = '0'
    And param label_filter = ['label1', 'label2']
    When method GET
    Then status 200
    And match response.control.code == '200'
    And match response.control.message == 'OK'
    And match response.control.type == 'S'

  Scenario: Get all tests with unauthorized access
    Given path '/test'
    And param get_for_all = 'true'
    And param searchTerm = 'test'
    And param take = '10'
    And param skip = '0'
    And header Authorization = 'Bearer invalid_token'
    When method GET
    Then status 401
    And match response.control.code == '401'
    And match response.control.message == 'Unauthorized'
    And match response.control.type == 'E'
