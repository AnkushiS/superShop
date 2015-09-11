<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>    
<style type="text/css">
    .bs-example{
    	margin-top: 10%;
    	margin-left: 40%;
    	margin-right: 20%;
    	marfin-bottom: 40%;
    }
    
</style>
</head>
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
	
	<h4>
	Payment Successful
	</h4>
	<div>
	${message}
	</div>
	
	<div class="bs-example">
	
	${form_sub}
	</div>
	<div class="bs-example">
	
	${form_back}
	</div>
</body>
</html>