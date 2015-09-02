<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
<script type="text/javascript">
function validateForm()
{
    if(document.frm.username.value=="")
    {
      alert("User Name should not be left blank");
      document.frm.username.focus();
      return false;
    }
    else if(document.frm.pwd.value=="")
    {
      alert("Password should not be left blank");
      document.frm.pwd.focus();
      return false;
    }
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
		</div>
	</nav>
	
	<h4> Create a user name</h4>
	
	<div class="bs-example">
	 <form action=Register method="get" onSubmit="return validateForm()">
    	
    	  <div class="input-group input-group-sm" style="width:30%">
        
        	 <span class="input-group-addon" id="sizing-addon3">@</span>
  			<input type="text" class="form-control" name= "user_name" placeholder="Username" aria-describedby="sizing-addon3">
  			
		</div>

        <div class="form-group" style="width:30%">
            <label for="Password">Password</label>
            <input type="password" class="form-control" name="Password" placeholder="Password">
        </div>
        
        <div class="form-group" style="width:30%">
            
            <input type="submit" class="btn btn-primary btn-lg" name="submit" value="submit">
        </div>
        
         </form>
       </div>          
  
</body>
</html>