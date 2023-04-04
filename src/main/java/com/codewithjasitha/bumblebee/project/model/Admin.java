package com.codewithjasitha.bumblebee.project.model;

public class Admin {
	private int id;
	private String userName;
	private String password;
	
	public Admin(int id,String userName,String password) {
		this.id = id;
		this.userName =userName;
		this.password = password;
	}
	
	public Admin(String userName,String password) {
		this.userName =userName;
		this.password = password;
	}
	
	public Admin() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}