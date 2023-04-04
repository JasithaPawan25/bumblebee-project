package com.codewithjasitha.bumblebee.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codewithjasitha.bumblebee.project.dao.ProductDao;
import com.codewithjasitha.bumblebee.project.model.Product;

public class ProductService {
	
	private  static  ProductService productServiceobj;
	
	public ProductService() {
		
	}
	
	public static synchronized ProductService getProductServiceInstance() {
		if(productServiceobj == null) {
			productServiceobj = new ProductService();
			
		}
		
		return productServiceobj;
	}
	
	private ProductDao getProductDao() {
		return new ProductDao();
	}
	
	//product services
	
	public boolean registerProduct(Product product) throws ClassNotFoundException, SQLException {
		
		return getProductDao().addProduct(product);
	}
	
	public Product getSpecificProduct(int productCode) throws ClassNotFoundException, SQLException {
		return getProductDao().getSpecificProduct(productCode);
	}
	
	public List<Product> getallproducts() throws ClassNotFoundException, SQLException{
		return getProductDao().getAllProducts();
	}
	
	public boolean editProduct(Product product) throws ClassNotFoundException, SQLException {
		return getProductDao().updateProduct(product);
	}
	
	public boolean deleteProduct(int productCode) throws ClassNotFoundException, SQLException {
		return getProductDao().deleteProduct(productCode);
	}
	
	
	

}
