package com.codewithjasitha.bumblebee.project.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithjasitha.bumblebee.project.dao.InventoryDao;
import com.codewithjasitha.bumblebee.project.model.Inventory;

public class InventoryService {
	private  static  InventoryService inventoryServiceobj;
	
	public InventoryService() {
		
	}
	
	public static synchronized InventoryService getInventoryInstance() {
		if(inventoryServiceobj == null) {
			inventoryServiceobj = new InventoryService();
			
		}
		
		return inventoryServiceobj;
	}
	
	private InventoryDao getInventoryDao() {
		return new InventoryDao();
	}
	
	
	//Inventory services
	
	public boolean registerInventory(Inventory inventory) throws ClassNotFoundException, SQLException {
		
		return getInventoryDao().addInventory(inventory);
	}
	
	public Inventory getSpecificInventory(int inventoryCode) throws ClassNotFoundException, SQLException {
		return getInventoryDao().getSpecificProduct(inventoryCode);
	}
	
	public List<Inventory> getallinventory() throws ClassNotFoundException, SQLException{
		return getInventoryDao().getAllInventory();
	}
	
	public boolean editInventory(Inventory inventory) throws ClassNotFoundException, SQLException {
		return getInventoryDao().updateInventory(inventory);
	}
	
	public boolean deleteInventory(int inventoryCode) throws ClassNotFoundException, SQLException {
		return getInventoryDao().deleteInventory(inventoryCode);
	}
}
