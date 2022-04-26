package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.DBConnect;

public class Account {

	private DBConnect connection = new DBConnect();
	
	
	//add acc
	public String insertAccount (String city, String buildingNo, String totalAmtToPay, String userID) {
		
		String output ="";
		
		try {
			
			Connection conn = connection.getConnection();
			
			if(conn == null) {
				return "Error while connecting to database";
			}
			
			//create a prepared statement
			String query = "INSERT INTO accounts (`accountID`,`city`, `buildingNo`, `totalAmtToPay`, `userID`)"
							+ "VALUES (?,?,?,?,?)";
			PreparedStatement prepStmt = conn.prepareStatement(query);
			
			//binding values
			prepStmt.setInt(1, 0);
			prepStmt.setString(2, city);
			prepStmt.setString(3, buildingNo);
			prepStmt.setDouble(4, Double.parseDouble(totalAmtToPay));
			prepStmt.setInt(5, Integer.parseInt(userID));
			
			//execute statement
			prepStmt.execute();
			conn.close();
			
			output = "Account Inserted Successfully!";
			
		} catch (Exception e) {
			
			output = "Error while inserting account.";
			System.err.println(e.getMessage());
		}
		
		return output;
		
	}
	
	//get all acc
	public String readAccounts() {

		String output = "";
		
		try {
			Connection conn = connection.getConnection();
			
			if(conn == null) {
				return "Error while connecting to database";
			}
			
			//prepare the html table to be displayed
			output= "<table border=\"1\">"
					+ "		<tr>"
					+ "			<th>Account ID</th>"
					+ "			<th>City</th>"
					+ "			<th>Building Number</th>"
					+ "			<th>Total Amount To Pay</th>"
					+ "			<th>User ID</th>"
					+ "		</tr>";
			
			String query = "SELECT * FROM accounts";
			Statement stmt = conn.createStatement();
			ResultSet rsset = stmt.executeQuery(query);
			
			while(rsset.next()) {
				String accountID = Integer.toString(rsset.getInt("accountID"));
				String city = rsset.getString("city");
				String buildingNo = rsset.getString("buildingNo");
				String totalAmtToPay = Double.toString(rsset.getDouble("totalAmtToPay"));
				String userID = Integer.toString(rsset.getInt("userID"));
				
				//add a row into html table
				output += "<tr>";
				output += 	"<td>" + accountID +  "</td>";
				output += 	"<td>" + city +  "</td>";
				output += 	"<td>" + buildingNo +  "</td>";
				output += 	"<td>" + totalAmtToPay +  "</td>";
				output += 	"<td>" + userID +  "</td>";
				output += 	"</tr>";
				
			}
			
			conn.close();
			
			//completing html table
			output += 	"</table>";
			
		} 
		catch (Exception e) 
		{
			output="Error while reading the accounts.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	//get acc
	public String readAccount(String ID) {
		String output = "";
		
		try {
			Connection conn = connection.getConnection();
			
			if(conn == null) {
				return "Error while connecting to database";
			}
			
			//prepare the html table to be displayed
			output= "<table border=\"1\">"
					+ "		<tr>"
					+ "			<th>Account ID</th>"
					+ "			<th>City</th>"
					+ "			<th>Building Number</th>"
					+ "			<th>Total Amount To Pay</th>"
					+ "			<th>User ID</th>"
					+ "		</tr>";
			
			String query = "SELECT * FROM accounts WHERE accountID="+ID;
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				String accountID = Integer.toString(rset.getInt("accountID"));
				String city = rset.getString("city");
				String buildingNo = rset.getString("buildingNo");
				String totalAmtToPay = Double.toString(rset.getDouble("totalAmtToPay"));
				String userID = Integer.toString(rset.getInt("userID"));
				
				//add a row into html table
				output += "<tr>";
				output += 	"<td>" + accountID +  "</td>";
				output += 	"<td>" + city +  "</td>";
				output += 	"<td>" + buildingNo +  "</td>";
				output += 	"<td>" + totalAmtToPay +  "</td>";
				output += 	"<td>" + userID +  "</td>";
				output += 	"</tr>";
				
			}
			
			conn.close();
			
			//completing html table
			output += 	"</table>";
			
		} 
		catch (Exception e) 
		{
			output="Error while reading the accounts.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	//delete acc
	public String deleteAccount(String accID) {
		String output="";
		
		try {
			
			Connection conn = connection.getConnection();
			if(conn == null) {
				return "Error while connecting to database for deleting";
			}
			
			//create a prepared statement
			String query = "DELETE FROM accounts WHERE accountID=?";
			
			PreparedStatement prepStmt = conn.prepareStatement(query);
			
			//binding value
			prepStmt.setInt(1, Integer.parseInt(accID));
			
			//execute the statement
			prepStmt.execute();
			conn.close();
			
			output = "Account Deleted successfully.";
			
		} catch (Exception e) {
			output = "Error while deleting the account.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	//update acc details
	public String updateAccount(String ID, String city, String buildingNo, String totalAmtToPay, String userID) {
		
		String output = "";
		
		try {
			
			
			Connection conn = connection.getConnection();
			if(conn == null) {
				
				return "Error connecting to database";
			}
			
			String query = "UPDATE accounts SET city=?, buildingNo=?, totalAmtToPay=?, userID=? where accountID=? ";
			
			PreparedStatement prepStmt = conn.prepareStatement(query);
			
			//binding values
			prepStmt.setString(1, city);
			prepStmt.setString(2, buildingNo);
			prepStmt.setDouble(3, Double.parseDouble(totalAmtToPay));
			prepStmt.setInt(4, Integer.parseInt(userID));
			prepStmt.setInt(5, Integer.parseInt(ID));
			
			 // execute the statement
			prepStmt.execute();
			 
			 conn.close();
			 
			 output = "Account Updated successfully";
			
			
		}catch(Exception e) {
			
			output = "Error while updating the account.";
			System.err.println(e.getMessage());
			 
		}
		
		
		return output;
	}
}
