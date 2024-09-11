// ********RoostGPT********
/*
Test generated by RoostGPT for test Test-5619 using AI Type  and AI Model 

Test generated for /order-service/orders/onboarding_post for http method type POST in rest-assured framework

RoostTestHash=abaf01dbfa


*/

// ********RoostGPT********
package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.Arrays;

public class orderserviceOrdersOnboardingPostTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @BeforeEach
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      String[] envVarsList = {""};
      envList = dataloader.load("src/test/java/com/bootexample4/RoostTest/order-service_orders_onboardingPostTest.csv", envVarsList);
    }

  
    @Test  
    public void orderserviceOrdersOnboardingPost_Test() throws JSONException {
        this.setUp();
        Integer testNumber = 1;
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = (testData.get("BASE_URL") != null && !testData.get("BASE_URL").isEmpty()) ? testData.get("BASE_URL"): "https:/serverRoot/com/";  
          JSONObject requestBodyObject = new JSONObject();
          if(testData.get("RequestBody") != null){
              requestBodyObject = new JSONObject(testData.get("RequestBody"));
          }
                Response responseObj = given()
				.header("channel", testData.get("channel") != null ? testData.get("channel") : "")
				.header("X-Trace-Id", testData.get("X-Trace-Id") != null ? testData.get("X-Trace-Id") : "")
				.header("username", testData.get("username") != null ? testData.get("username") : "")
                .when()
                .post("/order-service/orders/onboarding")  
                .then() 
                .extract().response(); 
              JsonPath response;
              String contentType = responseObj.getContentType();

              System.out.printf("Test Case %d: orderserviceOrdersOnboardingPost_Test \n", testNumber++);
              System.out.println("Request: POST /order-service/orders/onboarding");
              System.out.println("Status Code: " + responseObj.statusCode());
              if (testData.get("statusCode") != null) {
                String statusCodeFromCSV = testData.get("statusCode");
                if (statusCodeFromCSV.contains("X")) {
                  MatcherAssert.assertThat(
                      "Expected a status code of category " + statusCodeFromCSV + ", but got "
                          + Integer.toString(responseObj.statusCode()) + " instead",
                      Integer.toString(responseObj.statusCode()).charAt(0), equalTo(statusCodeFromCSV.charAt(0)));
                } else {
                  MatcherAssert.assertThat(
                      Integer.toString(responseObj.statusCode()), equalTo(statusCodeFromCSV));
                }
              } 
              				else {  
      List<Integer> expectedStatusCodes = Arrays.asList(201,400,401,403,405,409,422,500);
				MatcherAssert.assertThat(responseObj.statusCode(), is(in(expectedStatusCodes)));
          }
				String stringifiedStatusCode = Integer.toString(responseObj.statusCode());
        switch(responseObj.statusCode()){
        
          case 201:
            stringifiedStatusCode = "201";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 400:
            stringifiedStatusCode = "400";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 401:
            stringifiedStatusCode = "401";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 403:
            stringifiedStatusCode = "403";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 405:
            stringifiedStatusCode = "405";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 409:
            stringifiedStatusCode = "409";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 422:
            stringifiedStatusCode = "422";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 500:
            stringifiedStatusCode = "500";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
    }

      switch(Integer.toString(responseObj.statusCode()).charAt(0)){
      
    }

      
              if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
                String xmlResponse = responseObj.asString();
                JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
                JSONObject jsonData = jsonResponse.getJSONObject("xml");
                String jsonString = jsonData.toString();
                response = new JsonPath(jsonString);
        
              } else if(contentType.contains("application/json")){  
                response = responseObj.jsonPath(); 
              } else {
                System.out.println("Response content type found: "+contentType+", but RoostGPT currently only supports the following response content types: application/json,text/xml,application/xml");
                continue;
              }
         
                if(stringifiedStatusCode.equals("201")){					System.out.println("Description: Created");
      
              if (response.get("orderId") != null) {
                  
                MatcherAssert.assertThat(response.get("orderId"), instanceOf(String.class));
              }
      
              if (response.get("requestId") != null) {
                  
                MatcherAssert.assertThat(response.get("requestId"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("400")){					System.out.println("Description: Bad Request");
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("status") != null) {
                  
                MatcherAssert.assertThat(response.get("status"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("401")){					System.out.println("Description: Unauthorized");
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("status") != null) {
                  
                MatcherAssert.assertThat(response.get("status"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("403")){					System.out.println("Description: Forbidden");
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("status") != null) {
                  
                MatcherAssert.assertThat(response.get("status"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("405")){					System.out.println("Description: Method Not allowed");
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("status") != null) {
                  
                MatcherAssert.assertThat(response.get("status"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("409")){					System.out.println("Description: Conflict");
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("status") != null) {
                  
                MatcherAssert.assertThat(response.get("status"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("422")){					System.out.println("Description: Unprocessable Entity");
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code"), anyOf(equalTo("601"), equalTo("602"), equalTo("603"), equalTo("604"), equalTo("605"), equalTo("606"), equalTo("607"), equalTo("608"), equalTo("424")));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("status") != null) {
                  
                MatcherAssert.assertThat(response.get("status"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("500")){					System.out.println("Description: Internal Server Error");
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("status") != null) {
                  
                MatcherAssert.assertThat(response.get("status"), instanceOf(String.class));
              }
				}


            }  
    }
}
