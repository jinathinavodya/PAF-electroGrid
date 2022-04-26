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

import model.Payment;


@Path("Payments")
public class PaymentService {


	private Payment payObj = new Payment();
	
	//get all Payment details
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPayments() {
		return payObj.readPayments();
	}
	
	//get details of one Payment
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String readPayments(@PathParam("id") String id) {
		return payObj.readPayment(id);
	}
	
	//insert a Payment
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment( String payData) 
	{
		JsonObject payObject = new JsonParser().parse(payData).getAsJsonObject();
		
		//Read the values from the JSON object 
		String accountID = payObject.get("accountID").getAsString();
		String amount = payObject.get("amount").getAsString();
		String payMethod = payObject.get("payMethod").getAsString();
		String payDate = payObject.get("payDate").getAsString();
		
		String output = payObj.insertPayment( accountID,  amount,  payMethod,  payDate);
		
		return output;
	}
	
	//update a Payment
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment( String payData) {
		
		JsonObject payObject = new JsonParser().parse(payData).getAsJsonObject();
		
		//Read the values from the JSON object 
		String paymentID = payObject.get("paymentID").getAsString();
		String accountID = payObject.get("accountID").getAsString();
		String amount = payObject.get("amount").getAsString();
		String payMethod = payObject.get("payMethod").getAsString();
		String payDate = payObject.get("payDate").getAsString();
		 
		 String output = payObj.updatePayment( paymentID,  accountID,  amount,  payMethod,  payDate);
	 
		return output;
	}
	
	//delete a Payment
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment( @PathParam("id") String id) 
	{
		String output = payObj.deletePayment(id);
		return output;
	}
}
