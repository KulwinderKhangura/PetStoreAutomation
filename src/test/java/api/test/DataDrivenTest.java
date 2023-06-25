package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {
	
	//here we are creating the test cases using XLutilities file
	// XLUtilies file has certain methods 
	// Dataprovider class is used to read data from the excel file using XLUtilities file methods
	
	// testPostuser method need data which is coming from DataProvider class
	//to extract the data from the DataProvider class we are using the dataProvider annotation 
	
	//if dataprovider class is available in the same class(in test class), then we donnot to specify the dataProviderClass
	// if not then write to dataproviderclass name
	
	
	
	//if data is available 5 times in excel this test will repeat 5 times without any loop
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostuser(String userID, String userName,String fname, String lname, String useremail, String pwd, String ph) {
		
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		
		
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
