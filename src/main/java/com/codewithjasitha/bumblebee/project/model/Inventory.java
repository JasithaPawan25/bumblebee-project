package com.codewithjasitha.bumblebee.project.model;

public class Inventory {
	private int inventoryCode;
	private String inventoryName;
	private int inventoryQty;
	
	public Inventory(int inventoryCode,String inventoryName,int inventoryQty) {
		this.inventoryCode = inventoryCode;
		this.inventoryName =inventoryName;
		this.inventoryQty = inventoryQty;
	}
	
	public Inventory(String inventoryName,int inventoryQty) {
		this.inventoryName =inventoryName;
		this.inventoryQty = inventoryQty;
	}
	
	public Inventory() {
		
	}

	public int getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(int inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public int getInventoryQty() {
		return inventoryQty;
	}

	public void setInventoryQty(int inventoryQty) {
		this.inventoryQty = inventoryQty;
	}
	
	
}
