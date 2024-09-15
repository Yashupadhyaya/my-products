# ********RoostGPT********

# Test generated by RoostGPT for test testing-karate1 using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /employees/{id}_get for http method type GET 
# RoostTestHash=36bc161fb6
# 
# 

# ********RoostGPT********
Feature: Employee Management

Background:
  * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
  * url urlBase
  * def authToken = karate.properties['AUTH_TOKEN']
  * configure headers = { Authorization: '#(authToken)' }

Scenario Outline: Get an employee by ID
  Given path '/employees/', '<id>'
  When method get
  Then status 200
  And match response == { id: '#uuid', jobTitle: '#string', name: '#string', email: '#string' }
  And match response.id == '<id>'
  And match response.jobTitle == '<jobTitle>'
  And match response.name == '<name>'
  And match response.email == '<email>'

Examples:
  | id                                   | jobTitle       | name       | email                 |
  | 'd290f1ee-6c54-4b01-90e6-d701748f0851' | 'System Analyst' | 'John Smith' | 'john.smith@acme-corp.com' |

Scenario: Get an employee by ID - Not Found
  Given path '/employees/', 'non-existent-id'
  When method get
  Then status 404
