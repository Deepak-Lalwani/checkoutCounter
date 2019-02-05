package com.mediaocean.beans;

import org.springframework.stereotype.Component;

@Component
public class Products {

	private String barcode;
	private double price;
	private String category;
	private double tax;
	
	
	
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "ProductInfo [barcode=" + barcode + ", price=" + price + ", category=" + category
				+ ", tax=" + tax + "]";
	}
	
	
}
