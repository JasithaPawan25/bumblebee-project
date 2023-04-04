package com.codewithjasitha.bumlblebee.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithjasitha.bumblebee.project.model.Product;
import com.codewithjasitha.bumblebee.project.service.ProductService;

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService service;
	
	public ProductController () {
		service = ProductService.getProductServiceInstance();
	}
	

	//entry points
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificProduct(request,response);
		}else {
			searchAllProducts(request,response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type =request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addProduct(request,response);
		}else if(type != null && type.equals("update")) {
			updateProduct(request,response);
		}else if(type != null && type.equals("delete")) {
			deleteProduct(request,response);
		}
	}
	
	//methods
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		String productName = request.getParameter("productname");
		double  price = Double.parseDouble(request.getParameter("productprice"));
		
		Product product = new Product(productName,price);
		try {
			boolean result = service.registerProduct(product);
			if(result) {
				message = "The Product has been successfully Added! Product Name : "+productName;
			}else {
				message = "The Product has been Failed Added! Product Name : "+productName;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message",message);
		RequestDispatcher rd = request.getRequestDispatcher("register-product.jsp");
		rd.forward(request, response);
			
	}
	
	private void searchSpecificProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		Product product = new Product();
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		try {
			product =service.getSpecificProduct(productCode);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message",message);
		request.setAttribute("product",product);
		RequestDispatcher rd = request.getRequestDispatcher("update-product.jsp");	
		rd.forward(request, response);
		
		
		
	}
	
	private void searchAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		List<Product> productList;
		
		try {
		 productList = service.getallproducts();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			productList = new ArrayList<Product>();
		}
		
		request.setAttribute("message",message);
		request.setAttribute("productList",productList);
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		
		rd.forward(request, response);
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		String productName = request.getParameter("productName");
		Double productPrice = Double.parseDouble(request.getParameter("productPrice"));
		
		Product product = new Product(productCode,productName,productPrice);
		
		
		try {
			boolean result = service.editProduct(product);
			if(result) {
				message = "Product has been successfully updated ! Product code : "+ product.getProductCode();
			}else {
				message = "Product has been failed to update ! Product code : "+ product.getProductCode();
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message",message);
		RequestDispatcher rd = request.getRequestDispatcher("update-product.jsp");	
		rd.forward(request, response);
		
		
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = "";
		
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		try {
			boolean result = service.deleteProduct(productCode);
			if(result) {
				message = "Product has been successfully deleted ! Product code : "+ productCode;
			}else {
				message = "Product has been failed to delete ! Product code : "+ productCode;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		//request.setAttribute("message",message);
		response.sendRedirect("welcome");
	}

}
