package com.fix.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class CoinDeskAPITest {

//	@Test
	public void validateGETRequestTest() {

		Response response = given().
				            when().
				            get("https://api.coindesk.com/v1/bpi/currentprice.json").
				            then().
				            statusCode(200).
				            extract().
				            response();

//		System.out.println("Response: " + response.prettyPrint());

		response.then().body("bpi.USD.code", equalTo("USD"))
				.body("bpi.GBP.code", equalTo("GBP"))
				.body("bpi.EUR.code", equalTo("EUR"))
				.body("bpi.GBP.description", equalTo("British Pound Sterling"));
	}

}
