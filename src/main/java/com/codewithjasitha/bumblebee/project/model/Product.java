package com.codewithjasitha.bumblebee.project.model;

public class Product {
	private int productCode;
	private String productName;
	private double productPrice;
	
	public Product(int productCode,String productName,double productPrice) {
		this.productCode = productCode;
		this.productName =productName;
		this.productPrice = productPrice;
	}
	
	public Product(String productName,double productPrice) {
		this.productName =productName;
		this.productPrice = productPrice;
	}
	
	public Product() {
		
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
