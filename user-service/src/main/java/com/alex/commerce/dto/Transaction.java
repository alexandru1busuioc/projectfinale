package com.alex.commerce.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.alex.commerce.model.Product;

public class Transaction {
	@NotEmpty
	private String from;
	
	private double amount;
	@NotEmpty
	private List<Product> products;
	@NotEmpty
	private String remarks;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
}
