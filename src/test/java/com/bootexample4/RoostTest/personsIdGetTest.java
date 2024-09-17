// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /recipients/persons/{id}_get for http method type GET in rest-assured framework

RoostTestHash=131d25110f


*/

// ********RoostGPT********
package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
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

public class personsIdGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/persons_idGetTest.csv");
    }

  
    @Test  
    public void personsIdGet_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = https://virtserver.swaggerhub.com/credentialregister/wallet/1.0.0;  
  
                Response response = given()
				.pathParam("id", testData.get("id") != null ? testData.get("id") : "")
				.header("Token", testData.get("API_KEY"))
                .when()
                .get("/recipients/persons/{id}")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
      
              if (response.jsonPath().get("id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("initials") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("initials"), matchesPattern("^[A-Z]{1,6}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("initials"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("firstName") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("firstName"), matchesPattern("^[\p{L} .'-]{1,50}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("firstName"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("middleName") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("middleName"), matchesPattern("^[\p{L} .'-]{1,20}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("middleName"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("lastName") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("lastName"), matchesPattern("^[\p{L} .'-]{2,50}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("lastName"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("birthDate") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("birthDate"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("birthPlace") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("birthPlace"), matchesPattern("^[\p{L} .,'-]{2,100}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("birthPlace"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("phone") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("phone"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("email") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("email"), matchesPattern("^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("email"), instanceOf(String.class));MatcherAssert.assertThat(
                  response.jsonPath().getString("email"),
                  Matchers.matchesPattern("^[^\s@]+@[^\s@]+\.[^\s@]+$")
                ); 
  
          }
      
              if (response.jsonPath().get("postalCode") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("postalCode"), matchesPattern("^[0-9]{4}[A-Z]{2}$|^[0-9]{4,5}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("postalCode"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("houseNumber") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("houseNumber"), matchesPattern("^\d{1,6}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("houseNumber"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("houseNumberPostfix") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("houseNumberPostfix"), matchesPattern("^[a-zA-Z .,_'-]{0,20}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("houseNumberPostfix"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("countryCode") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("countryCode"), matchesPattern("^[A-Z]{2}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("countryCode"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("reference") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("reference"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("reference").length(), lessThanOrEqualTo(100));
  
          }
      
              if (response.jsonPath().get("createdAt") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("createdAt"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("updatedAt") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("updatedAt"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Bad Request");
      
              if (response.jsonPath().get("error") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("error") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("error"), matchesPattern("^validation/.*$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("value") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("value"), instanceOf(undefined.class));  
          }
      
              if (response.jsonPath().get("field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("field"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("schema_field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("schema_field"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 401) {
					System.out.println("Description: Authentication Required");
      
              if (response.jsonPath().get("error") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("error") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("error"), matchesPattern("^validation/.*$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("value") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("value"), instanceOf(undefined.class));  
          }
      
              if (response.jsonPath().get("field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("field"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("schema_field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("schema_field"), instanceOf(String.class));  
          }
				}
  
            }  
    }
}
