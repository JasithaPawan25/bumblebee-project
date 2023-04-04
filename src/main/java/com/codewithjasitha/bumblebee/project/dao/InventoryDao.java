package com.codewithjasitha.bumblebee.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithjasitha.bumblebee.project.model.Inventory;

public class InventoryDao {
	public DBConnector getDBConnector() {
		DBConnectorFactory factory = new DBConnectorFactoryImpl();
		return factory.getDBConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DBConnector connector =getDBConnector();
		return connector.getDbConnection();	
	} 
	
	
	public boolean addInventory(Inventory inventory) throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();		
		String query = "INSERT INTO inventory (inventory_name,quantity) VALUES (?,?)";
		
		PreparedStatement ps = connection .prepareStatement(query);
		ps.setString(1,inventory.getInventoryName());
		ps.setDouble(2,inventory.getInventoryQty());
		
		int result = ps.executeUpdate() ;
		ps.close();
		connection.close();
		
		return result>0;
	}
	
	public Inventory getSpecificProduct(int inventoryCode)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();		
		
		String query ="SELECT * FROM inventory WHERE id =?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1,inventoryCode);
		ResultSet rs = ps.executeQuery();	
		Inventory inventory = new Inventory();
		while(rs.next()) {
			inventory.setInventoryCode(rs.getInt("id"));
			inventory.setInventoryName(rs.getString("inventory_name"));
			inventory.setInventoryQty(rs.getInt("quantity"));
		}
		
		ps.close();
		connection.close();
		
		return inventory;
	}
	
	public List<Inventory> getAllInventory()  throws ClassNotFoundException, SQLException{
		
		Connection connection =getConnection();		
		
		String query ="SELECT * FROM inventory";
		Statement st =connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		while(rs.next()) {
			Inventory inventory = new Inventory();
			inventory.setInventoryCode(rs.getInt("id"));
			inventory.setInventoryName(rs.getString("inventory_name"));
			inventory.setInventoryQty(rs.getInt("quantity"));
			
			inventoryList.add(inventory);
		}
		
		st.close();
		connection.close();
				
		return inventoryList;
	}
	
	public boolean updateInventory(Inventory inventory)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();	
		
		String query = "UPDATE inventory SET inventory_name=? ,quantity=? WHERE id=?";
		
		PreparedStatement ps =connection.prepareStatement(query);
		ps.setString(1, inventory.getInventoryName());
		ps.setInt(2, inventory.getInventoryQty());
		ps.setInt(3, inventory.getInventoryCode());
		
		int  result =ps.executeUpdate();
		ps.close();
		connection.close();
		return result > 0;
	}
	
	public boolean deleteInventory(int inventoryCode)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();	
		
		String  query = "DELETE FROM inventory WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,inventoryCode);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result>0;
	}
}
