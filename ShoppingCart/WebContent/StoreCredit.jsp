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
<script type="text/javascript">	
	function showDiv() {
   document.getElementById('welcomeDiv').style.display = "block";
	}
		
	</script> 	
	  
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
	
	
         <div class="form-group" style="width:30%">
              <a class="btn btn-primary btn-lg" role="button" onclick="showDiv()">Apply for Store Credit</a>
        </div>
        
        <form action="storeCredit" method="get" class="bs-example" style="display:none;" id="welcomeDiv">
        <div  class="bs-example"  style="width:30%">
  			<input type="text" class="form-control" name= "credit" placeholder="Add Credit" ><br/>
			<input class="btn btn-primary btn-lg" type="submit" value="add credit" ></input>
		</div>
  	</form>   
	
	<div>
	${message}
	</div>