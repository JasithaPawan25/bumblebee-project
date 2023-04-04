package com.codewithjasitha.bumblebee.project.model;

public class CustomerInfo {
	private int customerCode;
	private String customerFullname;
	private String customerDOB;
	private double customerLoanBalance;
	private double customerUsedAmount;
	private String customerInstallmentPlan;
	
	public CustomerInfo(String customerFullname,String customerDOB,double customerLoanBalance,double customerUsedAmount,String customerInstallmentPlan) {
		this.customerFullname =customerFullname;
		this.customerDOB = customerDOB;
		this.customerLoanBalance =customerLoanBalance;
		this.customerUsedAmount =customerUsedAmount;
		this.customerInstallmentPlan =customerInstallmentPlan;
	}
	public CustomerInfo() {
		
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerFullname() {
		return customerFullname;
	}
	public void setCustomerFullname(String customerFullname) {
		this.customerFullname = customerFullname;
	}
	public String getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}
	public double getCustomerLoanBalance() {
		return customerLoanBalance;
	}
	public void setCustomerLoanBalance(double customerLoanBalance) {
		this.customerLoanBalance = customerLoanBalance;
	}
	public double getCustomerUsedAmount() {
		return customerUsedAmount;
	}
	public void setCustomerUsedAmount(double customerUsedAmount) {
		this.customerUsedAmount = customerUsedAmount;
	}
	public String getCustomerInstallmentPlan() {
		return customerInstallmentPlan;
	}
	public void setCustomerInstallmentPlan(String customerInstallmentPlan) {
		this.customerInstallmentPlan = customerInstallmentPlan;
	}
	
	
	
	
}
