package api.endpoints;

// In the Routes class we will maintain only the urls
// From the swagger we will capture the urls 
/* 
Swagger URI --> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}


https://petstore.swagger.io this is the main url 
and whatever comes after this link is called the end point

https://petstore.swagger.io  ---- called base url


*/


public class Routes {

  public static String	base_url = "https://petstore.swagger.io/v2";

  //User model i am using
  
	//baseurl is already creted we do not need to create again
  	// thats why we are using baseurl in post url
  
  public static String post_url = base_url+"/user";
  
  public static String get_url = base_url+"/user/{username}";
  public static String update_url = base_url+"/user/{username}";
  public static String delete_url = base_url+"/user/{username}";
  
  
  //Store module
  	//here we can create the Store module urls
  	
  
  //pet module
  	//here we can create the PET module urls
  
  
  
	
}




















