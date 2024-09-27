// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /categories_post for http method type POST in rest-assured framework

RoostTestHash=f3f2689232


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

public class categoriesPostTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/categoriesPostTest.csv");
    }

  
    @Test  
    public void categoriesPost_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "http://localhost:8080/applicationPetstore/rest";  
  
                Response response = given()
                .when()
                .post("/categories")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == default) {
					System.out.println("Description: successful operation");
				}
  
            }  
    }
}
