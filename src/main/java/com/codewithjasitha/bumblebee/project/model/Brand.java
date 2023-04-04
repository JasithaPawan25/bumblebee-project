package com.codewithjasitha.bumblebee.project.model;

public class Brand {
	private int brandCode;
	private String brandName;
	private int brandYear;
	
	public Brand(int brandCode,String brandName,int brandYear) {
		this.brandCode = brandCode;
		this.brandName =brandName;
		this.brandYear = brandYear;
	}
	
	public Brand(String brandName,int brandYear) {
		this.brandName =brandName;
		this.brandYear = brandYear;
	}
	
	public Brand() {
		
	}

	public int getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(int brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getBrandYear() {
		return brandYear;
	}

	public void setBrandYear(int brandYear) {
		this.brandYear = brandYear;
	}
	
	
		
}
