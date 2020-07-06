package com.QA.Auth;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AuthBasic {
	
	@Test()
	public void basicAuth() {
		given().auth().preemptive().basic("admin", "admin").
		when().
		get("http://the-internet.herokuapp.com/basic_auth").
		then().assertThat().statusCode(200);
		}
	@Test()
	public void oAuth2Test() {
		given().log().all().auth().oauth2("c0tWKbBjszsIm9CFDrZU54eqRFPovP-1Q50Z").
		when().log().all().
		get("https://gorest.co.in/public-api/users?first_name=Elvia").
		then().log().all().assertThat().statusCode(200);
	
	}
	@Test()
	public void oAuth2Test2() {
		given().header("Authorization"," Bearer c0tWKbBjszsIm9CFDrZU54eqRFPovP-1Q50Z").queryParam("first_name", "Elvia").
		when().
		get("https://gorest.co.in/public-api/users").
		then().log().all().assertThat().statusCode(200);
		
		
	}
}