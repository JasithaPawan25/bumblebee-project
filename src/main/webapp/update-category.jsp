<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"  %>   
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
	
<meta charset="ISO-8859-1">
<title>BumbleBee-Category</title>
</head>
<body>
	<div class="container">
		
		<nav class="navbar navbar-expand-lg bg-body-tertiary mt-2">
			    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			    <a><b>Bumble Bee</b></a>
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			       <li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            Product
				          </a>
				          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <li><a class="dropdown-item" href="welcome">ProductList</a></li>
				            <li><a class="dropdown-item" href="update-product.jsp">Update And Search Product</</a></li>
				            <li><a class="dropdown-item" href="register-product.jsp">Register Product</a></li>
				          </ul>
				</li>
				 <li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            Category
				          </a>
				          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <li><a class="dropdown-item" href="category">CategoryList</a></li>
				            <li><a class="dropdown-item" href="update-category.jsp">Upadate Category</</a></li>
				            <li><a class="dropdown-item" href="register-category.jsp">Register Category</a></li>
				          </ul>
				</li>
				<li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            Brand
				          </a>
				          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <li><a class="dropdown-item" href="brand">BrandList</a></li>
				            <li><a class="dropdown-item" href="update-brand.jsp">Update Brand</</a></li>
				            <li><a class="dropdown-item" href="register-brand.jsp">Register Brand</a></li>
				          </ul>
				</li>
				<li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            Inventory
				          </a>
				          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <li><a class="dropdown-item" href="inventory">InventoryList</a></li>
				            <li><a class="dropdown-item" href="update-inventory.jsp">Update Inventory</</a></li>
				            <li><a class="dropdown-item" href="register-inventory.jsp">Register Inventory</a></li>
				          </ul>
				</li>
				</li>
					<li class="nav-item" style="background-color: transparent; position:relative; right:-150%;">
          			<a class="nav-link" href="customerinfo">Customer Info</a>
        		</li>
			          
	
			      </ul>
			    </div>
			</nav>
					<p>${message}</p>
			<hr/>
			
			<h3>Search Category</h3>
			<form method="get" action="category" >
			<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">Category Code</label>
				  <input type="number" class="form-control" id="exampleFormControlInput1" name="categoryCode" placeholder="Enter code...">
				</div>			
					<input type="hidden" name="type" value="specific">
				<button type="submit" class="btn btn-success">Search Category</button>	
			</div>
		</form>
		<br/>
		<div class="container">
		<h3>Update Product</h3>
		<form method="post" action="category" >
			<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">Category Code</label>
				  <input type="text" readonly="readonly" class="form-control" id="exampleFormControlInput1" name="categoryCode" value="${category.categoryCode}">
				</div>	
			<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">Category Name</label>
				  <input type="text" class="form-control" id="exampleFormControlInput1" name="categoryName" value="${category.categoryName}" >
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">Category Description</label>
				  <input type="text" class="form-control" id="exampleFormControlInput1" name="categoryDescription" value="${category.categoryDescription}"  >
					<input type="hidden" name="type" value="update">
				</div>
				<button type="submit" class="btn btn-success">Update Category</button>	
			</div>
		</form>
		</div>	
			
	</div>
</body>
</html>