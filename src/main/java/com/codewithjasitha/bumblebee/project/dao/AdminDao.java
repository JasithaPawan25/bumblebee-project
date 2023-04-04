package com.codewithjasitha.bumblebee.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codewithjasitha.bumblebee.project.model.Admin;
import com.codewithjasitha.bumblebee.project.model.Category;

public class AdminDao {
		
	public DBConnector getDBConnector() {
		DBConnectorFactory factory = new DBConnectorFactoryImpl();
		return factory.getDBConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DBConnector connector =getDBConnector();
		return connector.getDbConnection();	
	} 
	
	public boolean getSpecificAdmin(String userName, String password)  throws ClassNotFoundException, SQLException {
		
		Connection connection =getConnection();
		
		String query = "SELECT username, password FROM bumblebee.admin WHERE username = ? AND password = ?;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, userName);
		ps.setString(2,password);
		ResultSet rs = ps.executeQuery();	
		
		boolean result = rs.next();
		
		rs.close();
		ps.close();
		connection.close();
		
		return result;
	}
}
