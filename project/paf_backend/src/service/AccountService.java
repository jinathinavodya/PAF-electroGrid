package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Account;

@Path("Accounts")
public class AccountService {


	private Account accObj = new Account();
	
	//get all acc
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readAccounts() {
		return accObj.readAccounts();
	}
	
	//get acc
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String readAccounts(@PathParam("id") String id) {
		return accObj.readAccount(id);
	}
	
	//add acc
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAccount( String accData) 
	{
		JsonObject accObject = new JsonParser().parse(accData).getAsJsonObject();
		
		//Read the values from the JSON object 
		String city = accObject.get("city").getAsString();
		String buildingNo = accObject.get("buildingNo").getAsString();
		String totalAmtToPay = accObject.get("totalAmtToPay").getAsString();
		String userID = accObject.get("userID").getAsString();
		
		String output = accObj.insertAccount( city,  buildingNo,  totalAmtToPay,  userID);
		
		return output;
	}
	
	//update acc details
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAccount( String accData) {
		
		JsonObject accObject = new JsonParser().parse(accData).getAsJsonObject();
		
		//Read the values from the JSON object 
		String accountID = accObject.get("accountID").getAsString();
		String city = accObject.get("city").getAsString();
		String buildingNo = accObject.get("buildingNo").getAsString();
		String totalAmtToPay = accObject.get("totalAmtToPay").getAsString();
		String userID = accObject.get("userID").getAsString();
		 
		 String output = accObj.updateAccount( accountID,  city,  buildingNo,  totalAmtToPay,  userID);
	 
		return output;
	}
	
	//delete acc
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAccount( @PathParam("id") String id) 
	{
		String output = accObj.deleteAccount(id);
		return output;
	}
	
}
