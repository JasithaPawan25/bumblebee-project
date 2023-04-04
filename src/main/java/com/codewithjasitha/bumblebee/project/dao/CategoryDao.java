package com.codewithjasitha.bumblebee.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithjasitha.bumblebee.project.model.Category;

public class CategoryDao {
	
	public DBConnector getDBConnector() {
		DBConnectorFactory factory = new DBConnectorFactoryImpl();
		return factory.getDBConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DBConnector connector =getDBConnector();
		return connector.getDbConnection();	
	} 
	
	public boolean addCategory(Category category) throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();		
		String query = "INSERT INTO category (name,description) VALUES (?,?)";
		
		PreparedStatement ps = connection .prepareStatement(query);
		ps.setString(1,category.getCategoryName());
		ps.setString(2,category.getCategoryDescription());
		
		int result = ps.executeUpdate() ;
		ps.close();
		connection.close();
		
		return result>0;
	}
	
	public Category getSpecificCategory(int categoryCode)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();		
		
		String query ="SELECT * FROM category WHERE id =?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1,categoryCode);
		ResultSet rs = ps.executeQuery();	
		Category category = new Category();
		while(rs.next()) {
			category.setCategoryCode(rs.getInt("id"));
			category.setCategoryName(rs.getString("name"));
			category.setCategoryDescription(rs.getString("description"));
		}
		
		ps.close();
		connection.close();
		
		return category;
	}
	
	public List<Category> getAllCategory()  throws ClassNotFoundException, SQLException{
		
		Connection connection =getConnection();		
		
		String query ="SELECT * FROM category";
		Statement st =connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Category> categoryList = new ArrayList<Category>();
		while(rs.next()) {
			Category category = new Category();
			category.setCategoryCode(rs.getInt("id"));
			category.setCategoryName(rs.getString("name"));
			category.setCategoryDescription(rs.getString("description"));
			
			categoryList.add(category);
		}
		
		st.close();
		connection.close();
				
		return categoryList;
	}
	
	public boolean updateCategory(Category category)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();	
		
		String query = "UPDATE category SET name=? ,description=? WHERE id=?";
		
		PreparedStatement ps =connection.prepareStatement(query);
		ps.setString(1, category.getCategoryName());
		ps.setString(2, category.getCategoryDescription());
		ps.setInt(3, category.getCategoryCode());
		
		int  result =ps.executeUpdate();
		ps.close();
		connection.close();
		return result > 0;
	}
	
	public boolean deleteCategory(int categoryCode)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();	
		
		String  query = "DELETE FROM category WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,categoryCode);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result>0;
	}
	
	
}
