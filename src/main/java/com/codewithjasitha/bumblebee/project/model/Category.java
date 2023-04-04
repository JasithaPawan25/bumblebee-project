package com.codewithjasitha.bumblebee.project.model;

public class Category {
	private int categoryCode;
	private String categoryName;
	private String categoryDescription;
	
	public Category(int categoryCode,String categoryName,String categoryDescription) {
		this.categoryCode = categoryCode;
		this.categoryName =categoryName;
		this.categoryDescription = categoryDescription;
	}
	
	public Category(String categoryName,String categoryDescription) {
		this.categoryName =categoryName;
		this.categoryDescription = categoryDescription;
	}
	
	public Category() {
		
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
}
