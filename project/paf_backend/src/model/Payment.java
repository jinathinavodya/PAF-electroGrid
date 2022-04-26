package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.DBConnect;

public class


Payment {

private DBConnect connection = new DBConnect();
	//insert payment data
	public String insertPayment (String accountID, String amount, String payMethod, String payDate) {
		
		String output ="";
		
		try {
			
			Connection con = connection.getConnection();
			
			if(con == null) {
				return "Error while connecting to database";
			}
			
			//create a prepared statement
			String query = "INSERT INTO payments (`paymentID`, `accountID`,`amount`, `payMethod`, `payDate` )"
							+ "VALUES (?,?,?,?,?)";
			PreparedStatement prepStat = con.prepareStatement(query);
			
			//binding values
			prepStat.setInt(1, 0);
			prepStat.setInt(2, Integer.parseInt(accountID));
			prepStat.setDouble(3, Double.parseDouble(amount));
			prepStat.setString(4, payMethod);
			prepStat.setString(5, payDate);
			
			//execute statement
			prepStat.execute();
			con.close();
			
			output = "Payment Inserted Successfully!";
			
		} catch (Exception e) {
			
			output = "Error while inserting the payment.";
			System.err.println(e.getMessage());
		}
		
		return output;
		
	}
	//read pay data
	public String readPayments() {

		String output = "";
		
		try {
			Connection con = connection.getConnection();
			
			if(con == null) {
				return "Error while connecting to database";
			}
			
			//prepare the html table to be displayed
			output= "<table border=\"1\">"
					+ "		<tr>"
					+ "			<th>Payment ID</th>"
					+ "			<th>Account ID</th>"
					+ "			<th>Amount</th>"
					+ "			<th>Method Of Payment</th>"
					+ "			<th>Date of Payment</th>"
					+ "		</tr>";
			
			String query = "SELECT * FROM payments";
			Statement stat = con.createStatement();
			ResultSet rSet = stat.executeQuery(query);
			
			while(rSet.next()) {
				String paymentID = Integer.toString(rSet.getInt("paymentID"));
				String accountID = Integer.toString(rSet.getInt("accountID"));
				String amount = Double.toString(rSet.getDouble("amount"));
				String payMethod = rSet.getString("payMethod");
				String payDate = rSet.getString("payDate");
				
				//add a row into html table
				output += "<tr>";
				output += 	"<td>" + paymentID +  "</td>";
				output += 	"<td>" + accountID +  "</td>";
				output += 	"<td>" + amount +  "</td>";
				output += 	"<td>" + payMethod +  "</td>";
				output += 	"<td>" + payDate +  "</td>";
				output += 	"</tr>";
				
			}
			
			con.close();
			
			//completing html table
			output += 	"</table>";
			
		} 
		catch (Exception e) 
		{
			output="Error while reading the payments.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	//read 1 pay data
	public String readPayment(String ID) {
		String output = "";
		
		try {
			Connection con = connection.getConnection();
			
			if(con == null) {
				return "Error while connecting to database";
			}
			
			//prepare the html table to be displayed
			output= "<table border=\"1\">"
					+ "		<tr>"
					+ "			<th>Payment ID</th>"
					+ "			<th>Account ID</th>"
					+ "			<th>Amount</th>"
					+ "			<th>Method Of Payment</th>"
					+ "			<th>Date of Payment</th>"
					+ "		</tr>";
			
			String query = "SELECT * FROM payments WHERE paymentID="+ID;
			Statement stat = con.createStatement();
			ResultSet rSet = stat.executeQuery(query);
			
			while(rSet.next()) {
				String paymentID = Integer.toString(rSet.getInt("paymentID"));
				String accountID = Integer.toString(rSet.getInt("accountID"));
				String amount = Double.toString(rSet.getDouble("amount"));
				String payMethod = rSet.getString("payMethod");
				String payDate = rSet.getString("payDate");
				
				//add a row into html table
				output += "<tr>";
				output += 	"<td>" + paymentID +  "</td>";
				output += 	"<td>" + accountID +  "</td>";
				output += 	"<td>" + amount +  "</td>";
				output += 	"<td>" + payMethod +  "</td>";
				output += 	"<td>" + payDate +  "</td>";
				output += 	"</tr>";
				
			}
			
			con.close();
			
			//completing html table
			output += 	"</table>";
			
		} 
		catch (Exception e) 
		{
			output="Error while reading the payments.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}

	//delete pay raw
	public String deletePayment(String payID) {
		String output="";
		
		try {
			
			Connection con = connection.getConnection();
			if(con == null) {
				return "Error while connecting to database for deleting";
			}
			
			//create a prepared statement
			String query = "DELETE FROM payments WHERE paymentID=?";
			
			PreparedStatement prepStat = con.prepareStatement(query);
			
			//binding value
			prepStat.setInt(1, Integer.parseInt(payID));
			
			//execute the statement
			prepStat.execute();
			con.close();
			
			output = "Payment Deleted successfully.";
			
		} catch (Exception e) {
			output = "Error while deleting the payment.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	//update pay raw
	public String updatePayment(String ID, String accountID, String amount, String payMethod, String payDate) {
		
		String output = "";
		
		try {
			
			
			Connection con = connection.getConnection();
			if(con == null) {
				
				return "Error connecting to database";
			}
			
			String query = "UPDATE payments SET accountID=?, amount=?, payMethod=?, payDate=? where paymentID=? ";
			
			PreparedStatement prepStat = con.prepareStatement(query);
			
			//binding values
			prepStat.setInt(1, Integer.parseInt(accountID));
			prepStat.setDouble(2, Double.parseDouble(amount));
			prepStat.setString(3, payMethod);
			prepStat.setString(4, payDate);
			prepStat.setInt(5, Integer.parseInt(ID));
			
			 // execute the statement
			prepStat.execute();
			 
			 con.close();
			 
			 output = "Payment Updated successfully";
			
			
		}catch(Exception e) {
			
			output = "Error while updating the payment.";
			System.err.println(e.getMessage());
			 
		}
		
		
		return output;
	}
}
