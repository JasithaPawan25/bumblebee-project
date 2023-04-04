package com.codewithjasitha.bumblebee.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithjasitha.bumblebee.project.model.Brand;
import com.codewithjasitha.bumblebee.project.model.Category;

public class BrandDao {
	
	public DBConnector getDBConnector() {
		DBConnectorFactory factory = new DBConnectorFactoryImpl();
		return factory.getDBConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DBConnector connector =getDBConnector();
		return connector.getDbConnection();	
	} 
	
	public boolean addBrand(Brand brand) throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();		
		String query = "INSERT INTO brands (brand_name,founding_year) VALUES (?,?)";
		
		PreparedStatement ps = connection .prepareStatement(query);
		ps.setString(1,brand.getBrandName());
		ps.setInt(2,brand.getBrandYear());
		
		int result = ps.executeUpdate() ;
		ps.close();
		connection.close();
		
		return result>0;
	}
	
	public Brand getSpecificBrand(int brandCode)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();		
		
		String query ="SELECT * FROM brands WHERE brand_id =?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1,brandCode);
		ResultSet rs = ps.executeQuery();	
		Brand brand = new Brand();
		while(rs.next()) {
			brand.setBrandCode(rs.getInt("brand_id"));
			brand.setBrandName(rs.getString("brand_name"));
			brand.setBrandYear(rs.getInt("founding_year"));
		}
		
		ps.close();
		connection.close();
		
		return brand;
	}
	
	public List<Brand> getAllBrand() throws ClassNotFoundException, SQLException{
		
		Connection connection =getConnection();		
		
		String query ="SELECT * FROM brands";
		Statement st =connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Brand> brandList = new ArrayList<Brand>();
		while(rs.next()) {
			Brand brand = new Brand();
			brand.setBrandCode(rs.getInt("brand_id"));
			brand.setBrandName(rs.getString("brand_name"));
			brand.setBrandYear(rs.getInt("founding_year"));
			
			brandList.add(brand);
		}
		
		st.close();
		connection.close();
				
		return brandList;
	}
	
	public boolean updateBrand(Brand brand)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();	
		
		String query = "UPDATE brands SET brand_name=? ,founding_year=? WHERE brand_id=?";
		
		PreparedStatement ps =connection.prepareStatement(query);
		ps.setString(1, brand.getBrandName());
		ps.setInt(2, brand.getBrandYear());
		ps.setInt(3, brand.getBrandCode());
		
		int  result =ps.executeUpdate();
		ps.close();
		connection.close();
		return result > 0;
	}
	
	public boolean deleteBrand(int brandCode)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();	
		
		String  query = "DELETE FROM brands WHERE brand_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,brandCode);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result>0;
	}	
	
}
