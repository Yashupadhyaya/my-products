// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /products_get for http method type GET in rest-assured framework

RoostTestHash=dad9f0399b


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

public class productsGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/productsGetTest.csv");
    }

  
    @Test  
    public void productsGet_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "http://localhost:8080/applicationPetstore/rest";  
  
                Response response = given()
				.pathParam("start", testData.get("start") != null ? testData.get("start") : "")
				.pathParam("max", testData.get("max") != null ? testData.get("max") : "")
                .when()
                .get("/products")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
      
              if (response.jsonPath().get("id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("version") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("version"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("name") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("name"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("name").length(), lessThanOrEqualTo(30));
  
                MatcherAssert.assertThat(response.jsonPath().getString("name").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("description").length(), lessThanOrEqualTo(3000));
  
                MatcherAssert.assertThat(response.jsonPath().getString("description").length(), greaterThanOrEqualTo(0));
  
          }
      
              if (response.jsonPath().get("category") != null) {      
              if (response.jsonPath().get("category.id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("category.id"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("category.version") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("category.version"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("category.name") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("category.name"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("category.name").length(), lessThanOrEqualTo(30));
  
                MatcherAssert.assertThat(response.jsonPath().getString("category.name").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.jsonPath().get("category.description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("category.description"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("category.description").length(), lessThanOrEqualTo(3000));
  
                MatcherAssert.assertThat(response.jsonPath().getString("category.description").length(), greaterThanOrEqualTo(0));
  
          }
  
          }
				}
  
            }  
    }
}
