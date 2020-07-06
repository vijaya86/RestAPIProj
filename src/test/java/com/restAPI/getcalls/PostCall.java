package com.restAPI.getcalls;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostCall {
	//first method json payload will give directly
	@Test(enabled=false)
	public void createData() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		given().contentType(ContentType.JSON).
		body("{\"username\" : \"admin\", \"password\": \"password123\" }").
		when().post("/auth").
		then().assertThat().statusCode(200);
		
		}
	//second method json file save one package and file object created and gave path
	//exract()  method is used to get token 
	@Test()
	public void postcallMethod2() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String token=given().contentType(ContentType.JSON).
		body(new File("C:\\Users\\karne\\eclipse-workspace\\RestAPIs\\src\\main\\java\\jsonfiles\\credentials.json")).
		when().post("/auth").
		then().extract().path("token");
		System.out.println(token);
		Assert.assertNotNull(token);
		
		}

}
