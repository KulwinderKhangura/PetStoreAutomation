package api.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	//here we are creating the Tests for user 
	
	//first we have to prepare the data with faker class
	
	Faker faker;
	//faker will generate the data 
	User userPayload;
	// after generating the data we have to send that data to the user class
	
	// this variable is used for logger file
	public Logger logger;
	
	
	@BeforeClass
	public void setup() {
		
		faker = new Faker();
		userPayload = new User();
		
	
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	
		//here we have intiate the variable
		
		logger = LogManager.getLogger(this.getClass());
	
		logger.debug("*****Debugging*********");
	
	}
	
	// now we going to start writing the test
	
	@Test(priority = 1)
	public void testPostUser() {
		
		//here we are calling the createUser method which is present in the 
		// UserEndPoints class and passing the data as a UserPayload
		//and it will return Response
		logger.info("******Creating the User********");
		Response response=	UserEndPoints.createUser(userPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("******User is created********");
		
	}
	
	@Test(priority = 2)
	public void testGetuserByName() {
		
		//here we getting the username 
		//we are using the UserEndPoints.readUser class and passing the username only
		//we are using this keyboard which is used for userPayLoad and referring the variable which is created in this clss
		
		logger.info("******Reading the User info********");
		
		Response response=	UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	
		logger.info("******User info is displayed********");
		
	}
	
	
	@Test(priority = 3)
	public void testUpdateUserByName() {
		//here first we are updating the user and then validating if the user got updated or no
		
		//Update the information
		logger.info("******Updating the User********");
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		// three upper points will new create the data 
		Response response=	UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	
		logger.info("******User is updated********");
		
		//checking the data after updatation
		
		Response responseAfteUpdate=	UserEndPoints.readUser(this.userPayload.getUsername());
		responseAfteUpdate.then().log().all();
		
		Assert.assertEquals(responseAfteUpdate.getStatusCode(), 200);
		
	}
	
	
	@Test(priority = 4)
	public void testDeleteUserByName() {
		
		logger.info("******deleting the User********");
		
			Response response=	UserEndPoints.deleteUser(this.userPayload.getUsername());
			response.then().log().all();
	
	
			Assert.assertEquals(response.getStatusCode(), 200);
	
			logger.info("******User is deleted********");
			
	}
	
	
	
	 
	
}
