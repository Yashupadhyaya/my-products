// ********RoostGPT********
/*
Test generated by RoostGPT for test artillery-test using AI Type  and AI Model 

Test generated for /employees_get for http method type GET in rest-assured framework

RoostTestHash=df8043e820


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

public class employeesGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @BeforeEach
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      String[] envVarsList = {""};
      envList = dataloader.load("src/test/java/com/bootexample4/RoostTest/employeesGetTest.csv", envVarsList);
    }

  
    @Test  
    public void employeesGet_Test() throws JSONException {
        this.setUp();
        Integer testNumber = 1;
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = (testData.get("BASE_URL") != null && !testData.get("BASE_URL").isEmpty()) ? testData.get("BASE_URL"): "https://virtserver.swaggerhub.com/061REB413/employee-service/0.1";  
          JSONObject requestBodyObject = new JSONObject();
          if(testData.get("RequestBody") != null){
              requestBodyObject = new JSONObject(testData.get("RequestBody"));
          }
                Response responseObj = given()
				.queryParam("searchString", testData.get("searchString") != null ? testData.get("searchString") : "")
                .when()
                .get("/employees")  
                .then() 
                .extract().response(); 
              JsonPath response;
              String contentType = responseObj.getContentType();

              System.out.printf("Test Case %d: employeesGet_Test \n", testNumber++);
              System.out.println("Request: GET /employees");
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
      List<Integer> expectedStatusCodes = Arrays.asList(200,400);
				MatcherAssert.assertThat(responseObj.statusCode(), is(in(expectedStatusCodes)));
          }
				String stringifiedStatusCode = Integer.toString(responseObj.statusCode());
        switch(responseObj.statusCode()){
        
          case 200:
            stringifiedStatusCode = "200";
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
         
                if(stringifiedStatusCode.equals("200")){
          JSONArray respoJsonArray = new JSONArray(responseObj.asString()); 
  
            for (int it = 0; it < respoJsonArray.length(); it++) {  
              response = new JsonPath(respoJsonArray.getJSONObject(it).toString());  
                    
              if (response.get("id") != null) {
                  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));
              }
      
              if (response.get("jobTitle") != null) {
                  
                MatcherAssert.assertThat(response.get("jobTitle"), instanceOf(String.class));
              }
      
              if (response.get("name") != null) {
                  
                MatcherAssert.assertThat(response.get("name"), instanceOf(String.class));
              }
      
              if (response.get("email") != null) {
                  
                MatcherAssert.assertThat(response.get("email"), instanceOf(String.class));
              }

            }  
          }
if(stringifiedStatusCode.equals("400")){					System.out.println("Description: Bad input");
				}


            }  
    }
}
