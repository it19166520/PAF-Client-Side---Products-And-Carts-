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
	$("#alertSuccess").text();
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
	var products = getProductCard(
		$("#name").val().trim(),
		$("#category").val().trim(),
		$("#Description").val().trim(),
		$("#price").val().trim(),
		$("#quality").val().trim(),
		$("#status").val());
	
		$("#colProducts").append(products);
		$("#alertSuccess").text("Saved successfully.");
		$("#alertSuccess").show();
		$("#formProducts")[0].reset();
});

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
	
	// Product quantity
	if ($("#quantity").val().trim() == "")
	{
	return "*Insert product quantity.!";
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