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

import model.Bill;

@Path("Bills")
public class BillService {
	private Bill billObj = new Bill();
	
	//get all bill details
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return billObj.readBills();
	}
	
	//get details of one bill
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String readItems(@PathParam("id") String id) {
		return billObj.readBill(id);
	}
	
	//insert a bill
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem( String billData) 
	{
		JsonObject billObject = new JsonParser().parse(billData).getAsJsonObject();
		
		//Read the values from the JSON object 
		 String accountID = billObject.get("accountID").getAsString();
		 String unitUsage = billObject.get("unitUsage").getAsString();
		 String month = billObject.get("month").getAsString();
		 String year = billObject.get("year").getAsString();
		 String amount = billObject.get("amount").getAsString();
		
		String output = billObj.insertBill(accountID , unitUsage , month , year , amount);
		
		return output;
	}
	
	//update a bill
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem( String billData) {
		
		JsonObject billObject = new JsonParser().parse(billData).getAsJsonObject();
		
		//Read the values from the JSON object 
		 String billID = billObject.get("billID").getAsString();
		 String accountID = billObject.get("accountID").getAsString();
		 String unitUsage = billObject.get("unitUsage").getAsString();
		 String month = billObject.get("month").getAsString();
		 String year = billObject.get("year").getAsString();
		 String amount = billObject.get("amount").getAsString();
		 
		 String output = billObj.updateBill(billID, accountID , unitUsage , month , year , amount);
	 
		return output;
	}
	
	//delete a bill
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem( @PathParam("id") String id) 
	{
		String output = billObj.deleteBill(id);
		return output;
	}
}
