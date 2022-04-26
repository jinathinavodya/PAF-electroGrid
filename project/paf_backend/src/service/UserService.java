package service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;

import model.User;


@Path("Users")
public class UserService {

	private User userObj = new User();
	
	//get all user details
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return userObj .readUsers();
	}
	
	//get details of one user
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String readItems(@PathParam("id") String id) {
		return userObj .readUser(id);
	}
	
	//insert a user
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem( String userData) 
	{
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
		
		//Read the values from JSON obj
		String userName = userObject.get("userName").getAsString();
		String userNIC = userObject.get("userNIC").getAsString();
		String userPhoneNo = userObject.get("userPhoneNo").getAsString();
		String userEmail = userObject.get("userEmail").getAsString();
		
		String output = userObj.insertUser(userName, userNIC, userPhoneNo, userEmail);
		
		return output;
	}
	
	//update a user
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem( String userData) {
		
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
		
		//Read the values from the JSON object 
		 String userID = userObject.get("userID").getAsString();
		 String userName = userObject.get("userName").getAsString();
		 String userNIC = userObject.get("userNIC").getAsString();
		 String userPhoneNo = userObject.get("userPhoneNo").getAsString();
		 String userEmail = userObject.get("userEmail").getAsString();
		 
		 String output = userObj.updateUser(userID , userName, userNIC, userPhoneNo, userEmail);
	 
		return output;
	}
	
	//delete a user
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem( @PathParam("id") String id) 
	{
		String output = userObj.deleteUser(id);
		return output;
	}
	
	
}
