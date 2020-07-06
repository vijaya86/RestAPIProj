package com.QA.Auth;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getoAuth2Token{
	
	@Test()
	public void getAuth() {
		RequestSpecification request=RestAssured.given().formParam("client_id", "PracticingOauth1").
		formParam("client_secret", "497994df4006172d8af63df32b4b7875").
		formParam("grant_type", "client_credentials");
		Response response=request.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}

}
