// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /order-report/meta-data/order-types_get for http method type GET in rest-assured framework

RoostTestHash=e5a6af5c86


*/

// ********RoostGPT********
package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
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

public class ordertypesGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/order-typesGetTest.csv");
    }

  
    @Test  
    public void ordertypesGet_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "https:/serverRoot/com/";  
  
                Response responseObj = given()
				.header("X-Trace-Id", testData.get("X-Trace-Id") != null ? testData.get("X-Trace-Id") : "")
				.header("channel", testData.get("channel") != null ? testData.get("channel") : "")
				.header("username", testData.get("username") != null ? testData.get("username") : "")
                .when()
                .get("/order-report/meta-data/order-types")  
                .then() 
                .extract().response(); 
              JsonPath response;
              String contentType = responseObj.getContentType();
              if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
                String xmlResponse = responseObj.asString();
                JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
                JSONObject jsonData = jsonResponse.getJSONObject("xml");
                String jsonString = jsonData.toString();
                response = new JsonPath(jsonString);
        
              } else {  
                response = responseObj.jsonPath(); 
              }  
         
                if (responseObj.statusCode() == 200) {
					System.out.println("Description: Success");
        
      if (response.get("_metadata") != null) {        
      if (response.get("_metadatahasNext") != null) {  
                MatcherAssert.assertThat(response.get("_metadatahasNext"), instanceOf(Boolean.class));  
          }
        
      if (response.get("_metadatacount") != null) {  
                MatcherAssert.assertThat(response.get("_metadatacount"), instanceOf(String.class));  
          }
        
      if (response.get("_metadatatotalCount") != null) {  
                MatcherAssert.assertThat(response.get("_metadatatotalCount"), instanceOf(String.class));  
          }
        
      if (response.get("_metadatarequestId") != null) {  
                MatcherAssert.assertThat(response.get("_metadatarequestId"), instanceOf(String.class));  
          }
        
      if (response.get("_metadatachannel") != null) {  
                MatcherAssert.assertThat(response.get("_metadatachannel"), instanceOf(String.class));  
          }
        
      if (response.get("_metadatatotalFailedOrderCount") != null) {  
                MatcherAssert.assertThat(response.get("_metadatatotalFailedOrderCount"), instanceOf(String.class));  
          }
        
      if (response.get("_metadatatotalCompletedOrderCount") != null) {  
                MatcherAssert.assertThat(response.get("_metadatatotalCompletedOrderCount"), instanceOf(String.class));  
          }
        
      if (response.get("_metadatatotalPendingOrderCount") != null) {  
                MatcherAssert.assertThat(response.get("_metadatatotalPendingOrderCount"), instanceOf(String.class));  
          }
        
      if (response.get("_metadatatotalInProgressOrderCount") != null) {  
                MatcherAssert.assertThat(response.get("_metadatatotalInProgressOrderCount"), instanceOf(String.class));  
          }
  
          }
        
      if (response.get("results") != null) {        
                for (int i = 0; i < response.getList("results").size(); i++) {        
                  }      
                MatcherAssert.assertThat(response.getList("results"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 400) {
					System.out.println("Description: Bad Request");
        
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
if (responseObj.statusCode() == 401) {
					System.out.println("Description: Unauthorized");
        
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
if (responseObj.statusCode() == 403) {
					System.out.println("Description: Forbidden");
        
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
if (responseObj.statusCode() == 404) {
					System.out.println("Description: Not Found");
        
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
if (responseObj.statusCode() == 405) {
					System.out.println("Description: Method Not allowed");
        
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
if (responseObj.statusCode() == 409) {
					System.out.println("Description: Conflict");
        
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
if (responseObj.statusCode() == 500) {
					System.out.println("Description: Internal Server Error");
        
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
