
package com.bootexample4.api_tests.KoreaiSmtBankAssistCoreBanking10Swagger;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KoreaiSmtBankAssistCoreBanking10SwaggerTest {

	@Test
	void testAll() {
		String PETSTOREAPIHOST = System.getenv().get("PETSTORE_API_HOST");
		String AUTHTOKEN = System.getenv().get("AUTH_TOKEN");
		Results results = Runner
			.path("src/test/java/com/bootexample4/api_tests/KoreaiSmtBankAssistCoreBanking10Swagger")
			.systemProperty("PETSTORE_API_HOST", PETSTOREAPIHOST)
			.systemProperty("AUTH_TOKEN", AUTHTOKEN)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
