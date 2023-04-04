<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"  %>  

<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Bumble Bee - Brand</title>
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
				            <li><a class="dropdown-item" href="update-brand.jsp">Upadate Brand</</a></li>
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
					<li class="nav-item" style="background-color: transparent; position:relative; right:-150%;">
          			<a class="nav-link" href="customerinfo">Customer Info</a>
        		</li>

		      </ul>
		    </div>
		</nav>
				<p>${message}</p>
		<hr/>
		
	<table class="table table-success  table-striped-columns">
		  <thead>
		    <tr>
		      <th scope="col">Brand Code</th>
		      <th scope="col">Brand Name</th>
		      <th scope="col">Brand Year</th>
		      <th scope="col">Delete</th>
		    </tr>
		  </thead>
		  <tbody>
		  <tag:forEach var="brand" items="${brandList}">
			   <tr>
			      <td>${brand.brandCode}</td>
			      <td>${brand.brandName}</td>
			      <td>${brand.brandYear}</td>
			      <td>
			      <form method="post" action="brand">
			      <input type="hidden" name="brandCode" value="${brand.brandCode}" />
			      <input type="hidden" name="type" value="delete" />
			      <button type="submit" class="btn btn-success">Delete</button>
			      </form>
			      </td>
			    </tr>
		  </tag:forEach>
		   
		   
		  </tbody>
		</table>
		
		
		
	</div>

</body>
</html>