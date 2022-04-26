package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	final String DBURL = "jdbc:mysql://localhost:3306/electrogriddb";
    final String DBUSER = "root";
    final String DBPASSWORD = "root";

    public Connection getConnection() {
        
    	Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            
			//for testing
			System.out.println("Connection Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return con;
    }

}
