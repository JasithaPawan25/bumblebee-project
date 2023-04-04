package com.codewithjasitha.bumblebee.project.dao;

public class DBConnectorFactoryImpl implements DBConnectorFactory {

	@Override
	public DBConnector getDBConnector() {
		
		return new DBConnectorImpl();
	}

}
