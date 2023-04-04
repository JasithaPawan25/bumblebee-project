package com.codewithjasitha.bumblebee.project.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.codewithjasitha.bumblebee.project.model.Product;

public class ProductDao {
	
	
	public DBConnector getDBConnector() {
		DBConnectorFactory factory = new DBConnectorFactoryImpl();
		return factory.getDBConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DBConnector connector =getDBConnector();
		return connector.getDbConnection();	
	} 
	
	
	public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();		
		String query = "INSERT INTO product (productname,productprice) VALUES (?,?)";
		
		PreparedStatement ps = connection .prepareStatement(query);
		ps.setString(1,product.getProductName());
		ps.setDouble(2,product.getProductPrice());
		
		int result = ps.executeUpdate() ;
		ps.close();
		connection.close();
		
		return result>0;
	}
	
	public Product getSpecificProduct(int productCode)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();		
		
		String query ="SELECT * FROM product WHERE productCode =?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1,productCode);
		ResultSet rs = ps.executeQuery();	
		Product product = new Product();
		while(rs.next()) {
			product.setProductCode(rs.getInt("productcode"));
			product.setProductName(rs.getString("productname"));
			product.setProductPrice(rs.getDouble("productprice"));
		}
		
		ps.close();
		connection.close();
		
		return product;
	}
	
	public List<Product> getAllProducts()  throws ClassNotFoundException, SQLException{
		
		Connection connection =getConnection();		
		
		String query ="SELECT * FROM product";
		Statement st =connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Product> productList = new ArrayList<Product>();
		while(rs.next()) {
			Product product = new Product();
			product.setProductCode(rs.getInt("productcode"));
			product.setProductName(rs.getString("productname"));
			product.setProductPrice(rs.getDouble("productprice"));
			
			productList.add(product);
		}
		
		st.close();
		connection.close();
				
		//return new ArrayList<Product>();
		return productList;
	}
	
	public boolean updateProduct(Product product)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();	
		
		String query = "UPDATE product SET productname=? ,productprice=? WHERE productcode=?";
		
		PreparedStatement ps =connection.prepareStatement(query);
		ps.setString(1, product.getProductName());
		ps.setDouble(2, product.getProductPrice());
		ps.setInt(3, product.getProductCode());
		
		int  result =ps.executeUpdate();
		ps.close();
		connection.close();
		return result > 0;
	}
	
	public boolean deleteProduct(int productCode)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();	
		
		String  query = "DELETE FROM PRODUCT WHERE productcode = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,productCode);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result>0;
	}
	
}
