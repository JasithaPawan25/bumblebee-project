package com.codewithjasitha.bumlblebee.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithjasitha.bumblebee.project.model.Brand;
import com.codewithjasitha.bumblebee.project.service.AdminService;
import com.codewithjasitha.bumblebee.project.service.BrandService;

public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private AdminService service;
	
	public AdminLoginController () {
		service = AdminService.getAdminServiceInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("type");
		
		if(type != null && type.equals("login")) {
			AdminLogin(request,response);
		}
	}
	
	private void AdminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			boolean result = service.isAdminLoginValid(username,password);
			if(result) {
				// If login is successful, redirect the user to the home page
	            response.sendRedirect("welcome");
	            return;
			}else {
				 message = "Invalid username or password";
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		  request.setAttribute("message", message);
		  RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		  rd.forward(request, response);
			
	}

}
