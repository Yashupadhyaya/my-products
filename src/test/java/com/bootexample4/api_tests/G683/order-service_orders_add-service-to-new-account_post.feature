# ********RoostGPT********

# Test generated by RoostGPT for test Test-5619 using AI Type  and AI Model 
# 
# Feature file generated for /order-service/orders/add-service-to-new-account_post for http method type POST 
# RoostTestHash=5296e57867
# 
# 

# ********RoostGPT********
Feature: Order Service API

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']

  Scenario Outline: Validate HTTP <methodType> method for /order-service/orders/add-service-to-new-account endpoint
    Given that the API endpoint is '/order-service/orders/add-service-to-new-account'
    And the header channel is '<channel>'
    And the header X-Trace-Id is '<X-Trace-Id>'
    And the header username is '<username>'
    And the header Authorization is 'Bearer ' + authToken
    When the <methodType> method is executed
    Then the status code should be <statusCode>

    Examples:
      | read('order-service_orders_add-service-to-new-account_post.csv') |