
    package com.bootexample4.api_tests;
  
    import com.intuit.karate.Results;
    import com.intuit.karate.Runner;
    // import com.intuit.karate.http.HttpServer;
    // import com.intuit.karate.http.ServerConfig;
    import org.junit.jupiter.api.Test;
  
    import static org.junit.jupiter.api.Assertions.assertEquals;
  
    class ApiTest {
  
        @Test
        void testAll() {
            String alphavantage_get_resolved_8bef8e59c6_url = System.getenv().getOrDefault("ALPHAVANTAGE_GET_RESOLVED_8BEF8E59C6_URL", "https://www.alphavantage.co");
String finnhub_e706fccd58_url = System.getenv().getOrDefault("FINNHUB_E706FCCD58_URL", "https://finnhub.io/api/v1");
String alphavantage_get_resolved_8bef8e59c6_auth_token = System.getenv().getOrDefault("ALPHAVANTAGE_GET_RESOLVED_8BEF8E59C6_AUTH_TOKEN", "1LEA56BMETM4187W");
String finnhub_e706fccd58_auth_token = System.getenv().getOrDefault("FINNHUB_E706FCCD58_AUTH_TOKEN", "cq6e1uhr01qlbj5011b0cq6e1uhr01qlbj5011bg");
            Results results = Runner.path("src/test/java/com/bootexample4/api_tests")
                    .systemProperty("ALPHAVANTAGE_GET_RESOLVED_8BEF8E59C6_URL",alphavantage_get_resolved_8bef8e59c6_url)
.systemProperty("FINNHUB_E706FCCD58_URL",finnhub_e706fccd58_url)
.systemProperty("ALPHAVANTAGE_GET_RESOLVED_8BEF8E59C6_AUTH_TOKEN", alphavantage_get_resolved_8bef8e59c6_auth_token)
.systemProperty("FINNHUB_E706FCCD58_AUTH_TOKEN", finnhub_e706fccd58_auth_token)
                    .reportDir("testReport").parallel(1);
            assertEquals(0, results.getFailCount(), results.getErrorMessages());
        }
  
    }
