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
import com.codewithjasitha.bumblebee.project.model.Inventory;
import com.codewithjasitha.bumblebee.project.service.CategoryService;
import com.codewithjasitha.bumblebee.project.service.InventoryService;

public class InventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InventoryService service;
	
	public InventoryController () {
		service = InventoryService.getInventoryInstance();
	}


	//entry points
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("type");

		if(type != null && type.equals("specific")) {
			searchSpecificInventory(request,response);
		}else {
			searchAllInventory(request,response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =request.getParameter("type");

		if(type != null && type.equals("add")) {
			addInventory(request,response);
		}else if(type != null && type.equals("update")) {
			updateInventory(request,response);
		}else if(type != null && type.equals("delete")) {
			deleteInventory(request,response);
		}
	}
	
	//category methods
	
		private void addInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String message = "";
			
			String inventoryName = request.getParameter("inventoryName");
			int  quantity = Integer.parseInt(request.getParameter("inventoryQty"));
			
			Inventory inventory = new Inventory(inventoryName,quantity);
			try {
				boolean result = service.registerInventory(inventory);
				if(result) {
					message = "The inventory has been successfully Added! inventory Name : "+inventoryName;
				}else {
					message = "The inventory has been Failed Added! inventory Name : "+inventoryName;
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			
			request.setAttribute("message",message);
			RequestDispatcher rd = request.getRequestDispatcher("register-inventory.jsp");
			rd.forward(request, response);
				
		}
		
		private void searchSpecificInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String message = "";
			Inventory inventory = new Inventory();
			int inventoryCode = Integer.parseInt(request.getParameter("inventoryCode"));
			try {
				inventory =service.getSpecificInventory(inventoryCode);
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			request.setAttribute("message",message);
			request.setAttribute("inventory",inventory);
			RequestDispatcher rd = request.getRequestDispatcher("update-inventory.jsp");	
			rd.forward(request, response);	
			
		}
		
		private void searchAllInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String message = "";
			List<Inventory> inventoryList;
			
			try {
				inventoryList = service.getallinventory();
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
				inventoryList = new ArrayList<Inventory>();
			}
			
			request.setAttribute("message",message);
			request.setAttribute("inventoryList",inventoryList);
			RequestDispatcher rd = request.getRequestDispatcher("inventory.jsp");
			
			rd.forward(request, response);
		}

		private void updateInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String message = "";
			
			int inventoryCode = Integer.parseInt(request.getParameter("inventoryCode"));
			String inventoryName = request.getParameter("inventoryName");
			int inventoryQty = Integer.parseInt(request.getParameter("inventoryQty"));
			
			Inventory invetory = new Inventory(inventoryCode,inventoryName,inventoryQty);
			
			
			try {
				boolean result = service.editInventory(invetory);
				if(result) {
					message = "invetory has been successfully updated ! invetory code : "+ invetory.getInventoryCode();
				}else {
					message = "invetory has been failed to update ! invetory code : "+ invetory.getInventoryCode();
				}
					
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("message",message);
			RequestDispatcher rd = request.getRequestDispatcher("update-inventory.jsp");	
			rd.forward(request, response);	
			
		}
		
		private void deleteInventory(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String message = "";
			
			int inventoryCode = Integer.parseInt(request.getParameter("inventoryCode"));
			try {
				boolean result = service.deleteInventory(inventoryCode);
				if(result) {
					message = "Inventory has been successfully deleted ! Inventory code : "+ inventoryCode;
				}else {
					message = "Inventory has been failed to delete ! Inventory code : "+ inventoryCode;
				}
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			//request.setAttribute("message",message);
			response.sendRedirect("inventory");
		}
		

}
