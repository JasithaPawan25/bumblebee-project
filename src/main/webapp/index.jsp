<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
 <%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"  %>   
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
	
<meta charset="ISO-8859-1">
<title>Bumble Bee- Register Category</title>
</head>
<body>
<div class="container">

	
			<hr/>	
			<h1 style="text-align:center;">Welcome To Bumble Bee Online</h1>	
		<div class="card" style="width: 18rem;margin-top:100px; margin-left:500px">
				  <div class="card-body">
					<form method="post" action="admin" >
						<div class="mb-3">
							  <label for="exampleFormControlInput1" class="form-label">User Name</label>
							  <input type="text" class="form-control" id="exampleFormControlInput1" name="username" >
							</div>
							<div class="mb-3">
							  <label for="exampleFormControlTextarea1" class="form-label">Password</label>
							  <input type="text" class="form-control" id="exampleFormControlInput1" name="password" >
								<input type="hidden" name="type" value="login">
							</div>
							<button type="submit" class="btn btn-success">Login</button><p>${message}</p>	
						</div>
					</form>
		</div>
</div>
		
		
		
</body>
</html>

