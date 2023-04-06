package com.codewithjasitha.bumblebee.project.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codewithjasitha.bumblebee.project.model.Category;

class CategoryServiceTest {


	@Test
	void testRegisterCategory() throws ClassNotFoundException, SQLException {
		CategoryService service = new CategoryService();
				// create a new Category object with test data
				Category category = new Category("Test Category", "Test Description");
				// register the category
				boolean result = service.registerCategory(category);
				// assert that the registration was successful
				assertTrue(result,"this should true with the data input");
	}

	@Test
	void testGetSpecificCategory() throws ClassNotFoundException, SQLException {
				CategoryService service = new CategoryService();
				Category category = service.getSpecificCategory(3);
				// assert that the category was retrieved successfully
				assertNotNull(category);
				// assert that the retrieved category has the correct code
				assertEquals(3, category.getCategoryCode());
			    
	}

	@Test
	void testGetallcategory() throws ClassNotFoundException, SQLException {
		// get all categories
		CategoryService service = new CategoryService();
		List<Category> categories = service.getallcategory();
		// assert that the list is not null
		assertNotNull(categories);
		// assert that the list is not empty
		assertFalse(categories.isEmpty(),"this should not null");
	}

	@Test
	void testEditCategory() throws ClassNotFoundException, SQLException {
				// get a specific category by code
				CategoryService service = new CategoryService();
				Category category = service.getSpecificCategory(3);
				// modify the category's name and description
				category.setCategoryName("New Name");
				category.setCategoryDescription("New Description");
				// edit the category
				boolean result = service.editCategory(category);
				// assert that the edit was successful
				assertTrue(result);
			
	}

	@Test
	void testDeleteCategory() throws ClassNotFoundException, SQLException {
				CategoryService service = new CategoryService();
				boolean result = service.deleteCategory(4);
				assertTrue(result,"product sholud deleted");

	}

}
