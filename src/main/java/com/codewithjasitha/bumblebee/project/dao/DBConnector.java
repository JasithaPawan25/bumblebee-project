package com.codewithjasitha.bumblebee.project.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnector {
	
	Connection getDbConnection()throws ClassNotFoundException, SQLException;

}
