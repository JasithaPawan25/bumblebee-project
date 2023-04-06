package com.codewithjasitha.bumblebee.project.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import com.codewithjasitha.bumblebee.project.model.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codewithjasitha.bumblebee.project.model.Inventory;

class ProductServiceTest {


	@Test
	void testRegisterProduct() throws ClassNotFoundException, SQLException {
		ProductService service = new ProductService();
		
		// create a new Product object with test data
		Product product = new Product("Test Product", 150);
		
		// register the Product
		boolean result = service.registerProduct(product);
		
		// assert that the registration was successful
		assertTrue(result);
	}

	@Test
	void testGetSpecificProduct() throws ClassNotFoundException, SQLException {
		ProductService service = new ProductService();
		Product product = service.getSpecificProduct(3);
		// assert that the product was retrieved successfully
		assertNotNull(product);
		// assert that the retrieved product has the correct code
		assertEquals(3, product.getProductCode());
	}

	@Test
	void testGetallproducts() throws ClassNotFoundException, SQLException {
		// get all products
				ProductService service = new ProductService();
				List<Product> product = service.getallproducts();
				// assert that the list is not null
				assertNotNull(product);
				// assert that the list is not empty
				assertFalse(product.isEmpty(),"this should not null");
	}

	@Test
	void testEditProduct() throws ClassNotFoundException, SQLException {
		// get all product
		ProductService service = new ProductService();
		Product product = service.getSpecificProduct(3);
		// modify the product name and price
		product.setProductName("New product");
		product.setProductPrice(250);
		// edit the product
		boolean result = service.editProduct(product);
		// assert that the edit was successful
		assertTrue(result);
	}

	@Test
	void testDeleteProduct() throws ClassNotFoundException, SQLException {
				// get all product
				ProductService service = new ProductService();
				// delete a product by its code
				boolean result = service.deleteProduct(4);
				// assert that the deletion was successful
				assertTrue(result,"product sholud deleted");
	}

}
