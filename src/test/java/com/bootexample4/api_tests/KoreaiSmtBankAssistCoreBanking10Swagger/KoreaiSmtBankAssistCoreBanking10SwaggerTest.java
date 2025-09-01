
package com.bootexample4.api_tests;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KoreaiSmtBankAssistCoreBanking10SwaggerTest {

	@Test
	void testAll() {
		String petstoreapihost = System.getenv().get("PETSTORE_API_HOST");
		Results results = Runner
			.path("src/test/java/com/bootexample4/api_tests/KoreaiSmtBankAssistCoreBanking10Swagger")
			.systemProperty("PETSTORE_API_HOST", petstoreapihost)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
