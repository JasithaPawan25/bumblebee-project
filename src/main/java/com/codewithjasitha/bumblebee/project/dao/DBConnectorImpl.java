package com.codewithjasitha.bumblebee.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectorImpl implements DBConnector {
	
	@Override
	public Connection getDbConnection() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	String url ="jdbc:mysql://localhost:3306/bumblebee";
	String username="root";
	String  password="root";
	Connection connection = DriverManager.getConnection(url, username, password);
	return connection;
	}
}
