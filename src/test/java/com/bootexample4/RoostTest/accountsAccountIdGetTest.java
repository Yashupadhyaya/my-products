// ********RoostGPT********
/*
Test generated by RoostGPT for test test-postman1 using AI Type Open AI and AI Model gpt-4-1106-preview

Test generated for /v1/accounts/{account-Id}_get for http method type GET in rest-assured framework

RoostTestHash=58d301af11


*/

// ********RoostGPT********
package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class accountsAccountIdGetTest {
  
    @Test  
    public void accountsAccountIdGet_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "accounts_account-IdGetTest.csv"))) {  
            String headerLine = reader.readLine();  
            String[] headers = headerLine.split(",");  
  
            String line;  
            while ((line = reader.readLine()) != null) {  
                String[] data = line.split(",");  
  
                // Create a map of header to data  
                Map<String, String> map = new HashMap<>();  
                for (int i = 0; i < headers.length; i++) {  
                    map.put(headers[i], data[i]);  
                }  
                
  
                Response response = given()
				.pathParam("account-Id", map.get("account-Id") != null ? map.get("account-Id") : "")
				.pathParam("Consent-ID", map.get("Consent-ID") != null ? map.get("Consent-ID") : "")
				.pathParam("withBalance", map.get("withBalance") != null ? map.get("withBalance") : "")
				.pathParam("Content-Type", map.get("Content-Type") != null ? map.get("Content-Type") : "")
				.pathParam("PSU-ID", map.get("PSU-ID") != null ? map.get("PSU-ID") : "")
                .when()
                .get("/v1/accounts/{account-Id}")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: Success");
      
              if (response.jsonPath().get("account") != null) {      
              if (response.jsonPath().get("account.resourceId") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.resourceId"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.iban") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.iban"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.bic") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.bic"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.pan") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.pan"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.bban") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.bban"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.currency") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.currency"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.accountType") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.accountType"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.cashAccountType") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.cashAccountType"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.name") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.name"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.balances") != null) {      
                for (int i = 0; i < response.jsonPath().getList("account.balances").size(); i++) {      
              if (response.jsonPath().get("account.balances["+ i +"].balanceType") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.balances["+ i +"].balanceType"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.balances["+ i +"].lastChangeDateTime") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.balances["+ i +"].lastChangeDateTime"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.balances["+ i +"].referenceDate") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.balances["+ i +"].referenceDate"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.balances["+ i +"].balanceAmount") != null) {      
              if (response.jsonPath().get("account.balances["+ i +"].balanceAmount.currency") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.balances["+ i +"].balanceAmount.currency"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("account.balances["+ i +"].balanceAmount.amount") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account.balances["+ i +"].balanceAmount.amount"), instanceOf(Integer.class));  
          }
  
          }
      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("account.balances"), instanceOf(List.class));
  
          }
      
              if (response.jsonPath().get("account._links") != null) {      
              if (response.jsonPath().get("account._links.type") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account._links.type"), instanceOf(undefined.class));  
          }
      
              if (response.jsonPath().get("account._links.properties") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("account._links.properties"), instanceOf(undefined.class));  
          }
  
          }
  
          }
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
