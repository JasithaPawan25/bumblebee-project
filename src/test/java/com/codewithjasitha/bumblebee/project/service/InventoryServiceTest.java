package com.codewithjasitha.bumblebee.project.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;
import com.codewithjasitha.bumblebee.project.model.Inventory;
import org.junit.jupiter.api.Test;

class InventoryServiceTest {

	@Test
	void testRegisterInventory() throws ClassNotFoundException, SQLException {
		InventoryService service = new InventoryService();
		
		// create a new Inventory object with test data
		Inventory inventory = new Inventory("Test Inventory", 100);
		
		// register the Inventory
		boolean result = service.registerInventory(inventory);
		
		// assert that the registration was successful
		assertTrue(result);
	}

	@Test
	void testGetSpecificInventory() throws ClassNotFoundException, SQLException {
		InventoryService service = new InventoryService();
		Inventory inventory = service.getSpecificInventory(3);
		// assert that the inventory was retrieved successfully
		assertNotNull(inventory);
		// assert that the retrieved inventory has the correct code
		assertEquals(3, inventory.getInventoryCode());
	}

	@Test
	void testGetallinventory() throws ClassNotFoundException, SQLException {
		// get all inventory
		InventoryService service = new InventoryService();
		List<Inventory> inventory = service.getallinventory();
		// assert that the list is not null
		assertNotNull(inventory);
		// assert that the list is not empty
		assertFalse(inventory.isEmpty(),"this should not null");
	}

	@Test
	void testEditInventory() throws ClassNotFoundException, SQLException {
				// get all inventory
				InventoryService service = new InventoryService();
				Inventory inventory = service.getSpecificInventory(3);
				// modify the inventory name and quantity
				inventory.setInventoryName("New Inventory");
				inventory.setInventoryQty(2022);
				// edit the inventory
				boolean result = service.editInventory(inventory);
				// assert that the edit was successful
				assertTrue(result);
	}

	@Test
	void testDeleteInventory() throws ClassNotFoundException, SQLException {
		// get all inventory
		InventoryService service = new InventoryService();
		// delete a inventory by its code
		boolean result = service.deleteInventory(4);
		// assert that the deletion was successful
		assertTrue(result,"inventory sholud deleted");
	}

}
