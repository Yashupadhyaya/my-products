# ********RoostGPT********

# Test generated by RoostGPT for test artillery-test using AI Type  and AI Model 
# 
# Feature file generated for /employees_get for http method type GET 
# RoostTestHash=ec231a756b
# 
# 

# ********RoostGPT********
Feature: Employees API

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * configure headers = { Authorization: #(karate.properties['AUTH_TOKEN']) }

  Scenario Outline: Search Employees
    Given path '/employees'
    And param searchString = '<searchString>'
    When method get
    Then status 200
    And match response == '#array'
    And match each response[*] contains { email: '#string', jobTitle: '#string', name: '#string' }

    Examples:
      | read('employees_get.csv') |

  Scenario: Bad input
    Given path '/employees'
    And param searchString = '123'
    When method get
    Then status 400
