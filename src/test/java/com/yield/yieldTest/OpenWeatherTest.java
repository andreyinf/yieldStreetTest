package com.yield.yieldTest;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;


public class OpenWeatherTest {
	
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.request(Method.GET, "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	String responseBody = response.getBody().asString();
	JsonPath jsonPathEvaluator = response.jsonPath();
	
	@Test
	 public void WeatherStatusCode() {
		assertTrue(StatusCode());
	 }
	
	@Test
	public void WeatherRegionName() {
		String region = jsonPathEvaluator.get("name");
		System.out.println("Region received from Response: " + region);
		assertEquals(region, "London");
	}
	
	@Test
	public void WeatherTempInformation() {
		assertTrue(responseBody.contains("temp"));
	}
	
	public boolean StatusCode() {
		System.out.println("Response Body is =>  " + responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Response code is =>  " + statusCode);
		return statusCode==200;
	}
	
}
