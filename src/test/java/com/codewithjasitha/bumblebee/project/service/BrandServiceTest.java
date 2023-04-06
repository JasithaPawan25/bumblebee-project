package com.codewithjasitha.bumblebee.project.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.codewithjasitha.bumblebee.project.model.Brand;

class BrandServiceTest {

	@Test
	void testRegisterBrand() throws ClassNotFoundException, SQLException {
				BrandService service = new BrandService();
		
				// create a new Brand object with test data
				Brand brand = new Brand("Test Brand", 2022);
				
				// register the brand
				boolean result = service.registerBrand(brand);
				
				// assert that the registration was successful
				assertTrue(result);
	}

	@Test
	void testGetSpecificBrand() throws ClassNotFoundException, SQLException {
		BrandService service = new BrandService();
		Brand brand = service.getSpecificBrand(3);
		// assert that the brand was retrieved successfully
		assertNotNull(brand);
		// assert that the retrieved brand has the correct code
		assertEquals(3, brand.getBrandCode());
	}

	@Test
	void testGetallbrand() throws ClassNotFoundException, SQLException {
		
				// get all brand
				BrandService service = new BrandService();
				List<Brand> brand = service.getallbrand();
				// assert that the list is not null
				assertNotNull(brand);
				// assert that the list is not empty
				assertFalse(brand.isEmpty(),"this should not null");
	}

	@Test
	void testEditBrand() throws ClassNotFoundException, SQLException {
		// get a specific brand by code
		BrandService service = new BrandService();
		Brand brand = service.getSpecificBrand(3);
		// modify the brand name and description
		brand.setBrandName("New Brand");
		brand.setBrandYear(2022);
		// edit the brand
		boolean result = service.editBrand(brand);
		// assert that the edit was successful
		assertTrue(result);
	}

	@Test
	void testDeleteBrand() throws ClassNotFoundException, SQLException {
		BrandService service = new BrandService();
		// delete a brand by its code
		boolean result = service.deleteBrand(4);
		// assert that the deletion was successful
		assertTrue(result,"brand sholud deleted");
	}

}
