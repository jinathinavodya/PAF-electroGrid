package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.DBConnect;

public class





Payment {

private DBConnect connection = new DBConnect();
	
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
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, Integer.parseInt(accountID));
			preparedStmt.setDouble(3, Double.parseDouble(amount));
			preparedStmt.setString(4, payMethod);
			preparedStmt.setString(5, payDate);
			
			//execute statement
			preparedStmt.execute();
			con.close();
			
			output = "Payment Inserted Successfully!";
			
		} catch (Exception e) {
			
			output = "Error while inserting the payment.";
			System.err.println(e.getMessage());
		}
		
		return output;
		
	}
	
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
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String paymentID = Integer.toString(rs.getInt("paymentID"));
				String accountID = Integer.toString(rs.getInt("accountID"));
				String amount = Double.toString(rs.getDouble("amount"));
				String payMethod = rs.getString("payMethod");
				String payDate = rs.getString("payDate");
				
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
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String paymentID = Integer.toString(rs.getInt("paymentID"));
				String accountID = Integer.toString(rs.getInt("accountID"));
				String amount = Double.toString(rs.getDouble("amount"));
				String payMethod = rs.getString("payMethod");
				String payDate = rs.getString("payDate");
				
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

	public String deletePayment(String payID) {
		String output="";
		
		try {
			
			Connection con = connection.getConnection();
			if(con == null) {
				return "Error while connecting to database for deleting";
			}
			
			//create a prepared statement
			String query = "DELETE FROM payments WHERE paymentID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding value
			preparedStmt.setInt(1, Integer.parseInt(payID));
			
			//execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Payment Deleted successfully.";
			
		} catch (Exception e) {
			output = "Error while deleting the payment.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	public String updatePayment(String ID, String accountID, String amount, String payMethod, String payDate) {
		
		String output = "";
		
		try {
			
			
			Connection con = connection.getConnection();
			if(con == null) {
				
				return "Error connecting to database";
			}
			
			String query = "UPDATE payments SET accountID=?, amount=?, payMethod=?, payDate=? where paymentID=? ";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1, Integer.parseInt(accountID));
			preparedStmt.setDouble(2, Double.parseDouble(amount));
			preparedStmt.setString(3, payMethod);
			preparedStmt.setString(4, payDate);
			preparedStmt.setInt(5, Integer.parseInt(ID));
			
			 // execute the statement
			 preparedStmt.execute();
			 
			 con.close();
			 
			 output = "Payment Updated successfully";
			
			
		}catch(Exception e) {
			
			output = "Error while updating the payment.";
			System.err.println(e.getMessage());
			 
		}
		
		
		return output;
	}
}
