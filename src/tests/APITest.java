package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APITest {
	@Test
	public void VerifyStatusCode() {
		RestAssured.given()
		.when()
			.get("https://reqres.in/api/users/2?page=2")
		.then()
			.statusCode(200)
			.log().all();
	}
}
