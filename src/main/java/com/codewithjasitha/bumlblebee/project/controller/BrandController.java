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

import com.codewithjasitha.bumblebee.project.model.Brand;
import com.codewithjasitha.bumblebee.project.service.BrandService;


public class BrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BrandService service;
	
	public BrandController () {
		service = BrandService.getBrandServiceInstance();
	}

	//entry points
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificBrand(request,response);
		}else {
			searchAllBrand(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addBrand(request,response);
		}else if(type != null && type.equals("update")) {
			updateBrand(request,response);
		}else if(type != null && type.equals("delete")) {
			deleteBrand(request,response);
		}
	}
	
		//brands methods
	
		private void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String message = "";
			
			String brandName = request.getParameter("brandName");
			int brandYear = Integer.parseInt(request.getParameter("brandYear"));
			
			Brand brand = new Brand(brandName,brandYear);
			try {
				boolean result = service.registerBrand(brand);
				if(result) {
					message = "The brand has been successfully Added! brand Name : "+brandName;
				}else {
					message = "The brand has been Failed Added! brand Name : "+brandName;
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			
			request.setAttribute("message",message);
			RequestDispatcher rd = request.getRequestDispatcher("register-brand.jsp");
			rd.forward(request, response);
				
		}
		
		private void searchSpecificBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String message = "";
			Brand brand = new Brand();
			int brandCode = Integer.parseInt(request.getParameter("brandCode"));
			try {
				brand =service.getSpecificBrand(brandCode);
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			request.setAttribute("message",message);
			request.setAttribute("brand",brand);
			RequestDispatcher rd = request.getRequestDispatcher("update-brand.jsp");	
			rd.forward(request, response);	
			
		}
		
		private void searchAllBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String message = "";
			List<Brand> brandList;
			
			try {
				brandList = service.getallbrand();
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
				brandList = new ArrayList<Brand>();
			}
			
			request.setAttribute("message",message);
			request.setAttribute("brandList",brandList);
			RequestDispatcher rd = request.getRequestDispatcher("brand.jsp");
			
			rd.forward(request, response);
		}

		private void updateBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String message = "";
			
			int brandCode = Integer.parseInt(request.getParameter("brandCode"));
			String brandName = request.getParameter("brandName");
			int brandYear =  Integer.parseInt(request.getParameter("brandYear"));
			
			Brand brand = new Brand(brandCode,brandName,brandYear);
			
			
			try {
				boolean result = service.editBrand(brand);
				if(result) {
					message = "brand has been successfully updated ! category code : "+ brand.getBrandCode();
				}else {
					message = "brand has been failed to update ! category code : "+ brand.getBrandCode();
				}
					
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("message",message);
			RequestDispatcher rd = request.getRequestDispatcher("update-brand.jsp");	
			rd.forward(request, response);	
			
		}	
		
		private void deleteBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String message = "";
			
			int brandCode = Integer.parseInt(request.getParameter("brandCode"));
			try {
				boolean result = service.deleteBrand(brandCode);
				if(result) {
					message = "Brand has been successfully deleted ! Brand code : "+ brandCode;
				}else {
					message = "Brand has been failed to delete ! Brand code : "+ brandCode;
				}
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			response.sendRedirect("brand");
		}

}
