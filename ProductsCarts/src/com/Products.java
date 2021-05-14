package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Products {
	
	private Connection connect()
	 {
		 Connection con = null;
		 try
		 {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagement?useTimezone=true&serverTimezone=UTC", "root", "");

		 }
		 catch (Exception e)
		 {		System.out.println("Database connection is not success!!!");
}
		 return con;
	 }
	public String insertItem(String name, String category, String Description, String price,String quantity, String status)
	 {
		 String output = "";
			 try
			 {
			 Connection con = connect();
				 if (con == null)
				 {
					 return "Error while connecting to the database for inserting."; 
				 }
				 
			
			 
				 // create a prepared statement
				 String query = " insert into products(`ID`, `name`, `category`, `Description`,  `price`,`quantity`, `status`)" 
				 + " values (?, ?, ?, ?, ?, ?, ?)";
				 
						 PreparedStatement preparedStmt = con.prepareStatement(query);
						
						 // binding values
						 preparedStmt.setInt(1, 0);
						 preparedStmt.setString(2, name);
						 preparedStmt.setString(3, category);
						 preparedStmt.setString(4, Description);
						 preparedStmt.setDouble(5, Double.parseDouble(price));
						 preparedStmt.setInt(6, Integer.parseInt(quantity));
						 preparedStmt.setString(7, status);
						
						 // execute the statement
						 preparedStmt.execute();
						 con.close();
						 String newProducts = readItems();
						 output = "{\"status\":\"success\", \"data\": \"" +
								 newProducts + "\"}";
				 }
			 
			 
				  catch (Exception e)
				 {
					  output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
							  System.err.println(e.getMessage());
				 }
						
			     return output;
			 }

	
		//read items
			 public String readItems()
			 {
				
				 String output = "";
				
				 try
				 {
					Connection con = connect();
					
						
					if (con == null) 
					{return "Error while connecting to the database for reading."; }
	
					// Prepare the html table to be displayed
					// Prepare the html table to be displayed
					output = "<table border='1'><tr><th>Name</th><th>Category</th>" +
					"<th>Description</th>" +
					"<th>Price RS.</th>" +
					"<th>Quantity</th>" +
					"<th>Status</th>" +
					"<th>Update</th><th>Remove</th></tr>";
					
					 String query = "select * from products";
					 Statement stmt = con.createStatement();
					 ResultSet rs = stmt.executeQuery(query);
					 
					 // iterate through the rows in the result set
						
					 while (rs.next())
					 {
						 String ID = Integer.toString(rs.getInt("ID"));
						 String name = rs.getString("name");
						 String category = rs.getString("category");
						 String Description = rs.getString("Description");
						 String price = Double.toString(rs.getDouble("price"));
						 String quantity = Integer.toString(rs.getInt("quantity"));
						 String status = rs.getString("status");

						 // Add into the html table
						 output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + ID
								 + "'>" + name + "</td>";
						 output += "<td>" + category + "</td>";
						 output += "<td>" + Description + "</td>";
						 output += "<td>" + price + "</td>";
						 output += "<td>" + quantity + "</td>";
						 output += "<td>" + status + "</td>";
					
						
						 // buttons
						 output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-pid='" + ID + "'></td>"
								 + "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-pid='"+ ID + "'></td></tr>";
						 }
					 

						 con.close();
						 
						 // Complete the html table
						 	output += "</table>";
						 	
				 }
				 
				 catch (Exception e)
				 {
					 output = "Error while reading the items.";
					 System.err.println(e.getMessage());
				 }
				 
				 return output;
			}
			 
			 
			public String updateProduct(String ID,String name, String category, String Description, String quantity,String price,String status)
						
			{
				 String output = "";
				
				 try
				 {
					 Connection con = connect();
					 
					 if (con == null)
					 {return "Error while connecting to the database for updating."; }
							
					 // create a prepared statement
							
					 String query = "UPDATE products SET name=?,category=?,Description=?,quantity=?,price=?,status=? WHERE ID=?";
					 PreparedStatement preparedStmt = con.prepareStatement(query);
							
					 // binding values
					 preparedStmt.setString(1, name);
					 preparedStmt.setString(2, category);
					 preparedStmt.setString(3, Description);
					 preparedStmt.setDouble(4, Double.parseDouble(price));
					 preparedStmt.setInt(5, Integer.parseInt(quantity));
					 preparedStmt.setString(6, status);
					 preparedStmt.setInt(7, Integer.parseInt(ID));		
					 // execute the statement
					 preparedStmt.execute();
					 con.close();
							
					 String newProducts = readItems();
					 output = "{\"status\":\"success\", \"data\": \"" +
							 newProducts + "\"}";
				 }
							 
				 catch (Exception e)	
				 {
					 output = "{\"status\":\"error\", \"data\":\"Error while Updating the item.\"}";
							 System.err.println(e.getMessage());
				 }
							
				 return output;
		 }
					
		 public String deleteProduct(String ID)
		{
				 String output = "";
				 try
				 {
					 Connection con = connect();
							
					 if (con == null)
					 {return "Error while connecting to the database for deleting."; }
							
					 // create a prepared statement
					 String query = "delete from products where ID=?";
					 PreparedStatement preparedStmt = con.prepareStatement(query);
						
					 // binding values
					 preparedStmt.setInt(1, Integer.parseInt(ID));
					
					 // execute the statement
					 preparedStmt.execute();
					 con.close();
					 
					 String newProducts = readItems();
					 output = "{\"status\":\"success\", \"data\": \"" +
							 newProducts + "\"}";
				 }
						
				 catch (Exception e)
				 {
					 output = "{\"status\":\"error\", \"data\":\"Error while deleting the item.\"}";					 
					 System.err.println(e.getMessage());
				 }
				 return output;
		}

}
