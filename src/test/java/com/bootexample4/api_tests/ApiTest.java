
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
            String alphavantage_get_resolved_url = System.getenv().getOrDefault("ALPHAVANTAGE_GET_RESOLVED_URL", "https://www.alphavantage.co");
String finnhub_url = System.getenv().getOrDefault("FINNHUB_URL", "https://finnhub.io/api/v1");
String alphavantage_get_resolved_auth_token = System.getenv().getOrDefault("ALPHAVANTAGE_GET_RESOLVED_AUTH_TOKEN", "1LEA56BMETM4187W");
String finnhub_auth_token = System.getenv().getOrDefault("FINNHUB_AUTH_TOKEN", "cq6e1uhr01qlbj5011b0cq6e1uhr01qlbj5011bg");
            Results results = Runner.path("src/test/java/com/bootexample4/api_tests")
                    .systemProperty("ALPHAVANTAGE_GET_RESOLVED_URL",alphavantage_get_resolved_url)
.systemProperty("FINNHUB_URL",finnhub_url)
.systemProperty("ALPHAVANTAGE_GET_RESOLVED_AUTH_TOKEN", alphavantage_get_resolved_auth_token)
.systemProperty("FINNHUB_AUTH_TOKEN", finnhub_auth_token)
                    .reportDir("testReport").parallel(1);
            assertEquals(0, results.getFailCount(), results.getErrorMessages());
        }
  
    }
