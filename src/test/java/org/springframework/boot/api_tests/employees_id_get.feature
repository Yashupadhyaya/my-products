# ********RoostGPT********

# Test generated by RoostGPT for test testing-karate using AI Type Azure Open AI and AI Model roostgpt-4-32k
# 
# Feature file generated for /employees/{id}_get for http method type GET 
# RoostTestHash=36bc161fb6
# 
# 

# ********RoostGPT********
Feature: Employee API

Background: 
  * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
  * url urlBase  
  * header Authorization = karate.env.AUTH_TOKEN

@Employee
Scenario Outline: Gets an employee by ID
  Given path '/employees', '<id>'
  When method GET
  Then status 200
  And match response.email == '<email>'
  And match response.jobTitle == '<jobTitle>'
  And match response.name == '<name>'
  And match $response == {id:'#string', email:'#string', name:'#string', jobTitle:'#string'}

Examples:
  | id                                     | email                 | name       | jobTitle       |
  | 'd290f1ee-6c54-4b01-90e6-d701748f0851' | 'john.smith@acme.com' | 'John Doe' | 'System Analyst' |

Scenario: Invalid id
  Given path '/employees', 'invalid-id'
  When method GET
  Then status 404
