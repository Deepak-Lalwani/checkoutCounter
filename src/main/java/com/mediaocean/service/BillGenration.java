package com.mediaocean.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediaocean.beans.GeneratedBill;
import com.mediaocean.beans.Products;

@Component
public class BillGenration {

	ObjectMapper mapper = new ObjectMapper();

	public GeneratedBill genrateBill(List<Products> productList, String phnumber)
			throws JsonProcessingException {

		double total_tax = 0;
		double total_amount = 0;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();
	String billNumber=dateFormat.format(date)+phnumber;
	List<Products> tempList = productList;
		for (Products p : tempList) {
				double tax = getTax(p);
				p.setTax(tax);
				total_tax += tax;
				total_amount += p.getPrice();
		}
		GeneratedBill bill = new GeneratedBill();
		bill.setBillNumber(billNumber);
		bill.setPhoneNumber(phnumber);
		bill.setTotal_tax(total_tax);
		bill.setAmount(total_amount);
		bill.setProdList(tempList);
		bill.setPayableAmount(total_tax + total_amount);
		return bill;
	}

	private double getTax(Products p) {

		double tax = 0;
		switch (p.getCategory()) {
		case "A":
			tax = p.getPrice() * 0.10;
			break;
		case "B":
			tax = p.getPrice() * 0.20;
			break;
		case "C":
			tax = 0;
			break;

		default:
			break;
		}
		return tax;
	}

	public List<Products> showAllPrroducts() {
		List<Products> productList = new ArrayList<>();
		Products p1 = new Products();
		p1.setBarcode("1");
		p1.setCategory("A");
		p1.setPrice(100.0);
		p1.setTax(0);

		Products p2 = new Products();
		p2.setBarcode("2");
		p2.setCategory("A");
		p2.setPrice(200.0);
		p2.setTax(0);

		Products p3 = new Products();
		p3.setBarcode("3");
		p3.setCategory("B");
		p3.setPrice(300.0);

		p3.setTax(0);

		Products p4 = new Products();
		p4.setBarcode("4");
		p4.setCategory("B");
		p4.setPrice(400.0);
		p4.setTax(0);

		Products p5 = new Products();
		p5.setBarcode("5");
		p5.setCategory("C");
		p5.setPrice(100.0);
		p5.setTax(0);

		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);
		productList.add(p5);

		
		
		return productList;
	}

	
	
}
