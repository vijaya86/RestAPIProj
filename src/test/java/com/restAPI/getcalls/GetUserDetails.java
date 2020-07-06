package com.restAPI.getcalls;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class GetUserDetails {
	
	
	@Test(enabled=false)
	public void getAPITestMethod1(){
		given().log().all().
		when().log().all().
		get("http://ergast.com/api/f1/2017/circuits.json").
		then().log().all().
		assertThat().body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));
		}
	@Test(enabled=false)
	public void getAPITestMethod2() {
		Response response=
		given().log().all().
		when().log().all().
		get("http://ergast.com/api/f1/2017/circuits.json");
		int statusCode=response.getStatusCode();
		System.out.println("Status code is"+statusCode);
		Assert.assertEquals(statusCode, 200);
		}
	@Test()
	public void getApiTestMethod3() {
		RestAssured.baseURI="http://ergast.com";
		given().log().all().
		when().log().all().
		get("/api/f1/2017/circuits.json").
		then().log().all().
		     assertThat().statusCode(200).
		and().
		     contentType(ContentType.JSON).
		 and().header("Content-Length", "4551");
	}
	@Test()
	public void getAPTQueryParamTest() {
		given().param("text", "test").
		when().log().all().
		get("http://md5.jsontest.com").
		then().assertThat().
		body("md5",equalTo("098f6bcd4621d373cade4e832627b4f6"));
	}
@DataProvider(name="provider")
public Object[][] dataproviderMethod() {
	return new Object [][]{
		{"2017",20},
		{"2016", 21},
		{"1966",9}
		
	};

}
	@Test(dataProvider="provider")
	public void dataprodingTest(String seasonyr, int num) {
		//given().pathParam(parameterName, parameterValue)
		
}
}
