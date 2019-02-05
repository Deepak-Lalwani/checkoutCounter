package com.mediaocean.beans;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GeneratedBill {

	private List<Products> prodList;
	private String phoneNumber;
	private double amount;
	private double total_tax;
	private String billNumber;

	private double payableAmount;
	
	public double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public List<Products> getProdList() {
		return prodList;
	}
	public void setProdList(List<Products> prodList) {
		this.prodList = prodList;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getTotal_tax() {
		return total_tax;
	}
	public void setTotal_tax(double total_tax) {
		this.total_tax = total_tax;
	}
	@Override
	public String toString() {
		return "GeneratedBill [prodList=" + prodList + ", phoneNumber=" + phoneNumber + ", amount=" + amount
				+ ", total_tax=" + total_tax + ", billNumber=" + billNumber + ", payableAmount=" + payableAmount + "]";
	}
	
	

	
}
