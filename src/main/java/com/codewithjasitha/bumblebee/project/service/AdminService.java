package com.codewithjasitha.bumblebee.project.service;

import java.sql.SQLException;

import com.codewithjasitha.bumblebee.project.dao.AdminDao;
import com.codewithjasitha.bumblebee.project.dao.BrandDao;
import com.codewithjasitha.bumblebee.project.model.Admin;
import com.codewithjasitha.bumblebee.project.model.Brand;

public class AdminService {
	private  static  AdminService adminServiceobj;
	
	public AdminService() {
		
	}
	
	public static synchronized AdminService getAdminServiceInstance() {
		if(adminServiceobj == null) {
			adminServiceobj = new AdminService();		
		}
		
		return adminServiceobj;
	}
	
	private AdminDao getAdminDao() {
		return new AdminDao();
	}
	
	public boolean isAdminLoginValid(String username, String password) throws ClassNotFoundException, SQLException {

		return getAdminDao().getSpecificAdmin(username, password);
		
	}
}
