<%@page import = "Util.DBConnection"%>
<%@page import = "java.sql.*"%>
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/Products.js"></script>
<% 
		String ID = request.getParameter("ID");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String Description = request.getParameter("Description");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String active = request.getParameter("status");
		
		try{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into products values(?,?,?,?,?,?,?)");
			ps.setString(1,ID);
			ps.setString(2,name);
			ps.setString(3,category);
			ps.setString(4,Description);
			ps.setString(5,price);
			ps.setString(6,quantity);
			ps.setString(7,active);
			ps.executeUpdate();
		
	
			
		}catch(Exception e){
			
			System.out.println(e);

		

		}
%>