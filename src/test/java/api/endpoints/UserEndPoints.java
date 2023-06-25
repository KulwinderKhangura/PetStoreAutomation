package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	// UserEndPoint class keeps the Crud methods
	// Crud ----> create --- get ---- update ---- delete
	// This class Created for perform create, Read, update, delete requests for user
	// ApI

	// payload is called request body

	public static Response createUser(User payload) {
		//User is a class and created in the api.payload package
		// This part is connected with the route class

		Response res = given()
				.contentType(ContentType.JSON)// This info we willl get from the swagger document
				.accept(ContentType.JSON)//// This info we willl get from the swagger document
				.body(payload)

				.when()
				.post(Routes.post_url);

		return res;

	}

//this method is used to read data 
	public static Response readUser(String userName) {

		Response res = given()
				.pathParam("username", userName)

				.when()
				.get(Routes.get_url);

		return res;

	}
	
	
	
	public static Response updateUser(String userName, User payload) {

		// This part is connected with the route class

		Response res = given()
				.contentType(ContentType.JSON)// This info we willl get from the swagger document
				.accept(ContentType.JSON)//// This info we willl get from the swagger document
				.pathParam("username", userName)
				.body(payload)
				

				.when()
				.put(Routes.update_url);

		return res;

	}
	
	
	
	public static Response deleteUser(String userName) {

		Response res = given()
				.pathParam("username", userName)

				.when()
				.delete(Routes.delete_url);

		return res;

	}
	
	
	

}
