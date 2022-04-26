package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.DBConnect;

public class Account {

	private DBConnect connection = new DBConnect();
	
	public String insertAccount (String city, String buildingNo, String totalAmtToPay, String userID) {
		
		String output ="";
		
		try {
			
			Connection con = connection.getConnection();
			
			if(con == null) {
				return "Error while connecting to database";
			}
			
			//create a prepared statement
			String query = "INSERT INTO accounts (`accountID`,`city`, `buildingNo`, `totalAmtToPay`, `userID`)"
							+ "VALUES (?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, city);
			preparedStmt.setString(3, buildingNo);
			preparedStmt.setDouble(4, Double.parseDouble(totalAmtToPay));
			preparedStmt.setInt(5, Integer.parseInt(userID));
			
			//execute statement
			preparedStmt.execute();
			con.close();
			
			output = "Account Inserted Successfully!";
			
		} catch (Exception e) {
			
			output = "Error while inserting account.";
			System.err.println(e.getMessage());
		}
		
		return output;
		
	}
	
	public String readAccounts() {

		String output = "";
		
		try {
			Connection con = connection.getConnection();
			
			if(con == null) {
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
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String accountID = Integer.toString(rs.getInt("accountID"));
				String city = rs.getString("city");
				String buildingNo = rs.getString("buildingNo");
				String totalAmtToPay = Double.toString(rs.getDouble("totalAmtToPay"));
				String userID = Integer.toString(rs.getInt("userID"));
				
				//add a row into html table
				output += "<tr>";
				output += 	"<td>" + accountID +  "</td>";
				output += 	"<td>" + city +  "</td>";
				output += 	"<td>" + buildingNo +  "</td>";
				output += 	"<td>" + totalAmtToPay +  "</td>";
				output += 	"<td>" + userID +  "</td>";
				output += 	"</tr>";
				
			}
			
			con.close();
			
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
	
	
	public String readAccount(String ID) {
		String output = "";
		
		try {
			Connection con = connection.getConnection();
			
			if(con == null) {
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
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String accountID = Integer.toString(rs.getInt("accountID"));
				String city = rs.getString("city");
				String buildingNo = rs.getString("buildingNo");
				String totalAmtToPay = Double.toString(rs.getDouble("totalAmtToPay"));
				String userID = Integer.toString(rs.getInt("userID"));
				
				//add a row into html table
				output += "<tr>";
				output += 	"<td>" + accountID +  "</td>";
				output += 	"<td>" + city +  "</td>";
				output += 	"<td>" + buildingNo +  "</td>";
				output += 	"<td>" + totalAmtToPay +  "</td>";
				output += 	"<td>" + userID +  "</td>";
				output += 	"</tr>";
				
			}
			
			con.close();
			
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

	public String deleteAccount(String accID) {
		String output="";
		
		try {
			
			Connection con = connection.getConnection();
			if(con == null) {
				return "Error while connecting to database for deleting";
			}
			
			//create a prepared statement
			String query = "DELETE FROM accounts WHERE accountID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding value
			preparedStmt.setInt(1, Integer.parseInt(accID));
			
			//execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Account Deleted successfully.";
			
		} catch (Exception e) {
			output = "Error while deleting the account.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	public String updateAccount(String ID, String city, String buildingNo, String totalAmtToPay, String userID) {
		
		String output = "";
		
		try {
			
			
			Connection con = connection.getConnection();
			if(con == null) {
				
				return "Error connecting to database";
			}
			
			String query = "UPDATE accounts SET city=?, buildingNo=?, totalAmtToPay=?, userID=? where accountID=? ";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setString(1, city);
			preparedStmt.setString(2, buildingNo);
			preparedStmt.setDouble(3, Double.parseDouble(totalAmtToPay));
			preparedStmt.setInt(4, Integer.parseInt(userID));
			preparedStmt.setInt(5, Integer.parseInt(ID));
			
			 // execute the statement
			 preparedStmt.execute();
			 
			 con.close();
			 
			 output = "Account Updated successfully";
			
			
		}catch(Exception e) {
			
			output = "Error while updating the account.";
			System.err.println(e.getMessage());
			 
		}
		
		
		return output;
	}
}
