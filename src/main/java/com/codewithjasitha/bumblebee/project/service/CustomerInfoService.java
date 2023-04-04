package com.codewithjasitha.bumblebee.project.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithjasitha.bumblebee.project.dao.CustomerInfoDao;
import com.codewithjasitha.bumblebee.project.model.CustomerInfo;

public class CustomerInfoService {
	private  static  CustomerInfoService customerinfoServiceobj;
	
	public CustomerInfoService() {
		
	}
	
	public static synchronized CustomerInfoService getCustomerInfoServiceInstance() {
		if(customerinfoServiceobj == null) {
			customerinfoServiceobj = new CustomerInfoService();
			
		}
		
		return customerinfoServiceobj;
	}
	
	private CustomerInfoDao getCustomerInfoDao() {
		return new CustomerInfoDao();
	}
	
	public List<CustomerInfo> getallcustomerinfo() throws ClassNotFoundException, SQLException{
		return getCustomerInfoDao().getAllCustomerdata();
	}
	
}
