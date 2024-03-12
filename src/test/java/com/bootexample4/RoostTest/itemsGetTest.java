// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /items_get for http method type GET in rest-assured framework

RoostTestHash=59ea07a9a1


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

public class itemsGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/itemsGetTest.csv");
    }

  
    @Test  
    public void itemsGet_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "http://localhost:8080/applicationPetstore/rest";  
  
                Response response = given()
				.pathParam("start", testData.get("start") != null ? testData.get("start") : "")
				.pathParam("max", testData.get("max") != null ? testData.get("max") : "")
                .when()
                .get("/items")  
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
      
              if (response.jsonPath().get("imagePath") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("imagePath"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("unitCost") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("unitCost"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("product") != null) {      
              if (response.jsonPath().get("product.id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("product.id"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("product.version") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("product.version"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("product.name") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("product.name"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("product.name").length(), lessThanOrEqualTo(30));
  
                MatcherAssert.assertThat(response.jsonPath().getString("product.name").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.jsonPath().get("product.description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("product.description"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("product.description").length(), lessThanOrEqualTo(3000));
  
                MatcherAssert.assertThat(response.jsonPath().getString("product.description").length(), greaterThanOrEqualTo(0));
  
          }
      
              if (response.jsonPath().get("product.category") != null) {      
              if (response.jsonPath().get("product.category.id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("product.category.id"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("product.category.version") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("product.category.version"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("product.category.name") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("product.category.name"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("product.category.name").length(), lessThanOrEqualTo(30));
  
                MatcherAssert.assertThat(response.jsonPath().getString("product.category.name").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.jsonPath().get("product.category.description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("product.category.description"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("product.category.description").length(), lessThanOrEqualTo(3000));
  
                MatcherAssert.assertThat(response.jsonPath().getString("product.category.description").length(), greaterThanOrEqualTo(0));
  
          }
  
          }
  
          }
				}
  
            }  
    }
}
