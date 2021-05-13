package Util;
import java.sql.*;

public class DBConnection {

public static Connection getCon() {
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagement", "root", "");
		return con;
	}
	catch (Exception e) {
		System.out.println("Database connection is not success!!!");
		return null;
	}
	
	
}
}