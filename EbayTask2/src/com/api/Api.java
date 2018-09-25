package com.api;

import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured.*;

public class Api {
	
	
	public static void main (String[] args) throws JSONException
	{
	RestAssured.proxy = null;
	Scanner input = new Scanner(System.in);
	System.out.println("Enter UserId: ");
	String userId = input.next();
	String baseUri = "https://jsonplaceholder.typicode.com";
	Api api = new Api();
	Response response = null;
	response = (Response) RestAssured.given().contentType(ContentType.JSON).relaxedHTTPSValidation().get(baseUri + "/comments/" + userId);
			
	
	String responseBody = response.getBody().asString();
	
	JSONObject json = new JSONObject(responseBody);
	String email = json.getString("email");
	System.out.println("First Task Email :" + email);
	
	String postIdstr = json.getString("postId");
	int postId = Integer.parseInt(postIdstr);
	if(postIdstr != null && postId>= 1 && postId <= 100)
	{
		System.out.println("Valid PostId: " + postId);
		
	}
	
	else
	{
		System.out.println("In-Valid PostId: " + postId);
	}
	
	String title = "Test Title";
	String body = "Test Body";
	
	response = (Response) RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
			.when().body(api.bodyJsonBuilder(title,body))
			.post(baseUri + "/post/").then();
			
	System.out.println("Status Code for 3rd Task :" + response.getStatusCode());
	input.close();	
	
	
	}
	
	
	public String bodyJsonBuilder(String title, String body)
	{
		String jsonBuilder= "";
		jsonBuilder = "{\"userId\": \"500\","
				+"\"id\": \"500\","
				+"\"title\": \"" + title + "\","
				+"\"body\": \"" + body + "\"}";
		
		return jsonBuilder;
	}

}
