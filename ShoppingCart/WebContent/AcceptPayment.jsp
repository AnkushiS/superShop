<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Example of Bootstrap 3 Vertical Form Layout</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
<style type="text/css">
    .bs-example{
    	margin-top: 10%;
    	margin-left: 40%;
    	margin-right: 20%;
    	marfin-bottom: 40%;
    }
    
</style>
<body>
<nav class="navbar navbar-dark bg-primary" >
		<div class="container-fluid">
			<a class="navbar-brand" style="background-color: #e3f2fd" href="Login.html">Shop</a>
			<a class="navbar-brand" style="background-color: #e3f2fd" href="MoreItems">Browse</a>
			<a class="navbar-brand" style="background-color: #e3f2fd" href="cart">Cart</a>
			<a class="navbar-brand" style="background-color: #e3f2fd" href="Admin">Admin</a>
			<a class="navbar-brand" style="background-color: #e3f2fd" href="StoreCredit.jsp">Store Credit</a>
			<a class="navbar-brand" style="background-color: #e3f2fd" href="Register?method=post">Logout</a>
		</div>
	</nav>
	
	<form action=Pay method="post" class='bs-example'>
    	<h3> Card Details </h3>
        
        <div class="input-group input-group-sm" style="width:30%">
		  
		  	<label> Full Name 
  			<input type="text" class="form-control" name= "cardname" placeholder="Name on the Card" aria-describedby="sizing-addon3">
  			</label>
  			
  			<label> Card Number 
  			<input type="text" class="form-control" name= "cardnum" placeholder="Card Number" aria-describedby="sizing-addon3">
  			</label>
  			</div>
  			<div>
  			<label> Shipping Address 
  			<input type="text" class="form-control" name= "shipadr1" placeholder="Shipping Adr 1" aria-describedby="sizing-addon3">
  			<input type="text" class="form-control" name= "shipadr2" placeholder="Shipping Adr 2" aria-describedby="sizing-addon3">
  			<input type="text" class="form-control" name= "shipcode" placeholder="Zipcode" aria-describedby="sizing-addon3">
  			</label>
  			
  			<label> Billing Address 
  			<input type="text" class="form-control" name= "billadr1" placeholder="billping Adr 1" aria-describedby="sizing-addon3">
  			<input type="text" class="form-control" name= "billadr2" placeholder="billping Adr 2" aria-describedby="sizing-addon3">
  			<input type="text" class="form-control" name= "billcode" placeholder="Zipcode" aria-describedby="sizing-addon3">
  			</label>
  			
		</div>
	
        <div>
	         <div class="form-group" style="width:30%" style="margin-above:20%">
	        <input class="btn btn-primary btn-lg" type=submit value='submit' name=sub >
	        </div>
        </div>          
    </form>
   
        



</body>
</html>