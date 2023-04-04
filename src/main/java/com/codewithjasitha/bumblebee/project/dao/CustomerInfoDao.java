package com.codewithjasitha.bumblebee.project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithjasitha.bumblebee.project.model.CustomerInfo;

public class CustomerInfoDao {
	public DBConnector getDBConnector() {
		DBConnectorFactory factory = new DBConnectorFactoryImpl();
		return factory.getDBConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DBConnector connector =getDBConnector();
		return connector.getDbConnection();	
	} 
	
	public List<CustomerInfo> getAllCustomerdata()  throws ClassNotFoundException, SQLException{
		
		Connection connection =getConnection();		
		
		String query ="SELECT * FROM customers";
		Statement st =connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<CustomerInfo> customerinfoList = new ArrayList<CustomerInfo>();
		while(rs.next()) {
			CustomerInfo customerinfo = new CustomerInfo();
			customerinfo.setCustomerCode(rs.getInt("customer_id"));
			customerinfo.setCustomerFullname(rs.getString("full_name"));
			customerinfo.setCustomerDOB(rs.getString("date_of_birth"));
			customerinfo.setCustomerLoanBalance(rs.getDouble("loan_balance"));
			customerinfo.setCustomerUsedAmount(rs.getDouble("used_amount"));
			customerinfo.setCustomerInstallmentPlan(rs.getString("installment_plan"));

			
			customerinfoList.add(customerinfo);
		}
		
		st.close();
		connection.close();
				
		return customerinfoList;
	}
	
	
}
