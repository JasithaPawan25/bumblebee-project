package com.codewithjasitha.bumblebee.project.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithjasitha.bumblebee.project.dao.BrandDao;
import com.codewithjasitha.bumblebee.project.model.Brand;

public class BrandService {
	private  static  BrandService brandServiceobj;
	
	public BrandService() {
		
	}
	
	public static synchronized BrandService getBrandServiceInstance() {
		if(brandServiceobj == null) {
			brandServiceobj = new BrandService();		
		}
		
		return brandServiceobj;
	}
	
	private BrandDao getBrandDao() {
		return new BrandDao();
	}
	
	//brand services
	
	public boolean registerBrand(Brand brand) throws ClassNotFoundException, SQLException {
		
		return getBrandDao().addBrand(brand);
	}
	
	public Brand getSpecificBrand(int brandCode) throws ClassNotFoundException, SQLException {
		return getBrandDao().getSpecificBrand(brandCode);
	}
	
	public List<Brand> getallbrand() throws ClassNotFoundException, SQLException{
		return getBrandDao().getAllBrand();
	}
	
	public boolean editBrand(Brand brand) throws ClassNotFoundException, SQLException {
		return getBrandDao().updateBrand(brand);
	}
	
	public boolean deleteBrand(int brandCode) throws ClassNotFoundException, SQLException {
		return getBrandDao().deleteBrand(brandCode);
	}
	
	
}
