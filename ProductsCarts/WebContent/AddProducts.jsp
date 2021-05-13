<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "Util.DBConnection"%>
<%@page import = "java.sql.*"%>


<!DOCTYPE html>
<html>
<head>
<title>Add Products</title>
<link rel="stylesheet" href="css/homee-style.css">
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/Products.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>


</head>
    <!--Header-->
    <br>
    <div class="topnav sticky">
    
         
            <center></center>
            <li><a  href="AddProduct.jsp">Add New Product <i class='fas fa-plus-square'></i></a></li>
            <li><a href="AllProductEditProduct.jsp">All Products & Edit Products <i class='fab fa-elementor'></i></a>
            <li><a href="messagesReceived.jsp">Messages Received <i class='fas fa-comment-alt'></i></a></li>
            <li><a href="ordersReceived.jsp">Orders Received <i class="fas fa-archive"></i></a></li>
            <li><a href="cancelOrders.jsp">Cancel Orders <i class='fas fa-window-close'></i></a></li>
            <li><a href="deliveredOrders.jsp">Delivered Orders <i class='fas fa-dolly'></i></a></li>
  
          </div>
                    
              <div class="topnav sticky"  >
               <div class="search-container">
                <form action="searchHome.jsp" method="post">
					    	<input type = "text" placeholder="Search Item" name= "search">
					    	<button type = "Submit">Search</button>
					    
					    </form>
               
             </div>
            </div>
           <br>

<body>
			
					    
		<%--Get id and display the interface --%>
		<%
		int ID=1;
		try{
			
			Connection con=DBConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("Select max(id) from products");
			
			while(rs.next())
			{
				ID=rs.getInt(1);
				ID=ID+1;
			}
		}catch(Exception e){
			
			
		}
		
		%>
		
		
		
	
		
		<%--Create form to add products --%>		    

		<center><div class="div1">
		<form id="formProducts" action ="AddProducts.jsp"  method= "post" ><br><b>
			<div class="card">
 			
  					<div class="container">
    		<h3><b><i>Product ID :-  <%out.println(ID); %><i></b></h3> 
  				</div>
			</div>
			<br><br>
			Item Name<br> <input type ="text" name = "name" id="name" placeholder = "Enter the item name.." ><br><br>
			Item Category<br> <input type ="text" name = "category" id="category" placeholder = "Enter the item category.." ><br><br>
			Item Description<br> <input type ="text" name = "Description" id="Description" placeholder = "Enter the item description.." ><br><br>
			Item Price<br> <input type ="text" name = "price" id="price" placeholder = "Enter the item price.." ><br><br>
			Quantity<br> <input type ="text" name = "quantity" id="quantity" placeholder = "Enter the quantity of the item.." ><br><br>
			Item Activation<br> <select  name = "status" id="status" >
							<option value = "">  </option>
							<option value = "Yes"> Yes </option>
							<option value = "No"> No </option>
							</select><br><br>
			<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">				
			<div id="alertSuccess" class="alert alert-success"></div>
			<div id="alertError" class="alert alert-danger"></div>
			
			<button class="button1" id="btnSave"><span>Add Details </span></button>
				    
		</form>
		</div>
		
		<br>
		<div class="row">
			<div class="col-12" id="colProducts">
		</div>
</div>	
</body>
</html>