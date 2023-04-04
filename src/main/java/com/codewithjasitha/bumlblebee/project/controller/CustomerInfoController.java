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
import com.codewithjasitha.bumblebee.project.model.CustomerInfo;
import com.codewithjasitha.bumblebee.project.service.BrandService;
import com.codewithjasitha.bumblebee.project.service.CustomerInfoService;

public class CustomerInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CustomerInfoService service;
  
    public CustomerInfoController() {
    	service = CustomerInfoService.getCustomerInfoServiceInstance();
    }
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			//searchSpecificCustomerInfo(request,response);
		}else {
			searchAllCustomerInfo(request,response);
		}
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}
	
	private void searchAllCustomerInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		List<CustomerInfo> customerinfoList;
		
		try {
			customerinfoList = service.getallcustomerinfo();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			customerinfoList = new ArrayList<CustomerInfo>();
		}
		
		request.setAttribute("message",message);
		request.setAttribute("customerinfoList",customerinfoList);
		RequestDispatcher rd = request.getRequestDispatcher("customerinfo.jsp");
		
		rd.forward(request, response);
	}

}
