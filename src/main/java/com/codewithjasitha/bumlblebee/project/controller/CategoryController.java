package com.codewithjasitha.bumlblebee.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithjasitha.bumblebee.project.model.Category;
import com.codewithjasitha.bumblebee.project.model.Product;
import com.codewithjasitha.bumblebee.project.service.CategoryService;
import com.codewithjasitha.bumblebee.project.service.ProductService;


public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoryService service;
			
			public CategoryController () {
				service = CategoryService.getCategoryServiceInstance();
			}
	
    
	//entry points
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificCategory(request,response);
		}else {
			searchAllCategory(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addCategory(request,response);
		}else if(type != null && type.equals("update")) {
			updateCategory(request,response);
		}else if(type != null && type.equals("delete")) {
			deleteCategory(request,response);
		}
	}
	
	//category methods
	
	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		String categoryName = request.getParameter("categoryName");
		String  description = request.getParameter("categoryDescription");
		
		Category category = new Category(categoryName,description);
		try {
			boolean result = service.registerCategory(category);
			if(result) {
				message = "The category has been successfully Added! Product Name : "+categoryName;
			}else {
				message = "The category has been Failed Added! Product Name : "+categoryName;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message",message);
		RequestDispatcher rd = request.getRequestDispatcher("register-category.jsp");
		rd.forward(request, response);
			
	}
	
	private void searchSpecificCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		Category category = new Category();
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		try {
			category =service.getSpecificCategory(categoryCode);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message",message);
		request.setAttribute("category",category);
		RequestDispatcher rd = request.getRequestDispatcher("update-category.jsp");	
		rd.forward(request, response);	
		
	}
	
	private void searchAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		List<Category> categoryList;
		
		try {
			categoryList = service.getallcategory();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			categoryList = new ArrayList<Category>();
		}
		
		request.setAttribute("message",message);
		request.setAttribute("categoryList",categoryList);
		RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
		
		rd.forward(request, response);
	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		String categoryName = request.getParameter("categoryName");
		String description = request.getParameter("categoryDescription");
		
		Category category = new Category(categoryCode,categoryName,description);
		
		
		try {
			boolean result = service.editCategory(category);
			if(result) {
				message = "category has been successfully updated ! category code : "+ category.getCategoryCode();
			}else {
				message = "category has been failed to update ! category code : "+ category.getCategoryCode();
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message",message);
		RequestDispatcher rd = request.getRequestDispatcher("update-category.jsp");	
		rd.forward(request, response);	
		
	}	
	
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = "";
		
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		try {
			boolean result = service.deleteCategory(categoryCode);
			if(result) {
				message = "Category has been successfully deleted ! Category code : "+ categoryCode;
			}else {
				message = "Category has been failed to delete ! Category code : "+ categoryCode;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		//request.setAttribute("message",message);
		response.sendRedirect("category");
	}

}
