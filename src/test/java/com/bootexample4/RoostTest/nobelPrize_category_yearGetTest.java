// Test generated by RoostGPT for test postman-test using AI Type Azure Open AI and AI Model roost-gpt4-32k

// RoostTestHash=adfce3f1d2

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.hamcrest.MatcherAssert;

public class nobelPrize_category_yearGetTest {

    @Test
    public void nobelPrize_category_year_get_Test() {
        RestAssured.baseURI = System.getenv("BASE_URL");

        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/nobelPrize_category_year_get.csv"))) {
            String headerLine = reader.readLine();
            String[] headers = headerLine.split(",");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                // HashMap for the data
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    map.put(headers[i], data[i]);
                }

                Response response = given()
                        .pathParam("category", map.get("category"))
                        .pathParam("year", map.get("year"))
                        .when()
                        .get("/nobelPrize/{category}/{year}")
                        .then()
                        .contentType(ContentType.JSON)
                        .extract().response();

                //Assertions
                switch (response.statusCode()) {
                    case 200:
                        MatcherAssert.assertThat(response.jsonPath().get("nobelPrize.awardYear"), instanceOf(Integer.class));

                        if (response.jsonPath().get("nobelPrize.laureates") != null) {
                            int laureateSize = response.jsonPath().getList("nobelPrize.laureates").size();

                            for (int i = 0; i < laureateSize; i++) {
                                MatcherAssert.assertThat(response.jsonPath().get("nobelPrize.laureates[" + i + "].id"), instanceOf(Integer.class));
                            }
                        }
                        break;
                    case 400:
                    case 404:
                    case 422:
                        MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));
                        MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));
                        break;
                    default:
                        fail("Unexpected status code: " + response.statusCode());
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
