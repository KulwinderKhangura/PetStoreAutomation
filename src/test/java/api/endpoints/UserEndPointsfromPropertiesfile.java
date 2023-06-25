package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import javax.mail.Quota.Resource;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPointsfromPropertiesfile {

	//this class is taking data form the properties file
	//first we have to create a method which going to load the properties file
	
	
	//method created for getting URL's from properties file
	static ResourceBundle	getURL(){
		//when we call this method it gonna load the properties file
		ResourceBundle routes = ResourceBundle.getBundle("routes");//here routes is properties file name
		return routes;
		//this method will return the ResourcesBundle 
	}

	
	
	public static Response createUser(User payload) {
		
		String	post_url=	getURL().getString("post_url");
		//getURl is static method and return type is routes and routes give data in String format
		
		Response res = given()
				.contentType(ContentType.JSON)// This info we willl get from the swagger document
				.accept(ContentType.JSON)//// This info we willl get from the swagger document
				.body(payload)

				.when()
				//.post(Routes.post_url) this one is coming from the routes class
				.post(post_url); // this is coming from the properties file

		return res;

	}

//this method is used to read data 
	public static Response readUser(String userName) {

		String	get_url=	getURL().getString("get_url");
		//getURl is static method and return type is routes and routes give data in String format
		
		Response res = given()
				.pathParam("username", userName)

				.when()
				//.get(Routes.get_url)this one is coming from the routes class
				
				.get(get_url); //this is coming from the properties file


		return res;

	}
	
	
	
	public static Response updateUser(String userName, User payload) {

		String	put_url=	getURL().getString("update_url");
		//getURl is static method and return type is routes and routes give data in String format
	
		
		
		
		// This part is connected with the route class

		Response res = given()
				.contentType(ContentType.JSON)// This info we willl get from the swagger document
				.accept(ContentType.JSON)//// This info we willl get from the swagger document
				.pathParam("username", userName)
				.body(payload)
				

				.when()
				//.put(Routes.update_url);
				.put(put_url);

		return res;

	}
	
	
	
	public static Response deleteUser(String userName) {

		
		String	delete_url=	getURL().getString("delete_url");
		//getURl is static method and return type is routes and routes give data in String format
	
		
		
		Response res = given()
				.pathParam("username", userName)

				.when()
				//.delete(Routes.delete_url);
				.delete(delete_url);

		return res;

	}
	
	
	

}
