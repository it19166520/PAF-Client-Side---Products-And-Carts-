/**
 * 
 */
$(document).ready(function()
{
	$("#alertSuccess").hide();
	$("#alertError").hide();
});


//save------------
$(document).on("click", "#btnSave", function(event)
{
	//clear status messages-----
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text();
	$("#alertError").hide();
	
	//Form validation-------------------
	var status = validateItemForm();
	// If not valid
	if (status != true)
	{
	$("#alertError").text(status);
	$("#alertError").show();
	return;
	}

	//If valid
	$("#formProducts").submit();
});


//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	$("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
	$("#name").val($(this).closest("tr").find('td:eq(0)').text());
	$("#category").val($(this).closest("tr").find('td:eq(1)').text());
	$("#Description").val($(this).closest("tr").find('td:eq(2)').text());
	$("#price").val($(this).closest("tr").find('td:eq(3)').text());
	$("#quantity").val($(this).closest("tr").find('td:eq(4)').text());
	$("#status").val($(this).closest("tr").find('td:eq(5)').text());

	});

//validate The Form
function validateItemForm()
{
	//Validations
	// Product name
	if ($("#name").val().trim() == "")
	{
	return "*Insert product name!";
	}
	
	// Product category
	if ($("#category").val().trim() == "")
	{
	return "*Insert product category.!";
	}
	
	// Product description
	if ($("#Description").val().trim() == "")
	{
	return "*Insert product description.!";
	}
	
	// Product price
	if ($("#price").val().trim() == "")
	{
	return "*Insert product price.!";
	}
	
	// is numerical value of price
	var tmpPrice = $("#price").val().trim();
	if (!$.isNumeric(tmpPrice))
	{
		return "*Insert a numerical value for Product Price.";
	}

	// Product quantity
	if ($("#quantity").val().trim() == "")
	{
	return "*Insert product quantity.!";
	}
	
	// is numerical value 
	var tmpQuan = $("#quantity").val().trim();
	if (!$.isNumeric(tmpQuan))
	{
		return "*Insert a numerical value for Product Quantity.!";
	}
	
	// Product activation
	if ($("*#status").val() == "0")
	{
	return "*Select status!";
	}
	return true;
}


function getProductsCard(name, category, Description,price,quantity,status)
{

	var products = "";
	products += "<div class=\"student card bg-light m-2\
				style=\"max-width: 10rem; float: left;\">";
	products += "<div class=\"card-body\">";
	products += name ;
	products += "<br>";
	products += category ;
	products += "<br>";
	products += category ;
	products += "<br>";
	products += Description ;
	products += "<br>";
	products += price ;
	products += "<br>";
	products += quantity ;
	products += "<br>";
	products += status ;
	products += "</div>";
	products += "<input type=\"button\" value=\"Remove\
				class=\"btn btn-danger remove\">";
	products += "</div>";
	return products;
}