package com.alex.commerce.service;

import java.util.List;

import com.alex.commerce.dto.Transaction;
import com.alex.commerce.model.Product;

public interface ECommerceService {

	List<Product> searchProductLike(String name);

	String buyProduct(Transaction transaction);

	List<Transaction> getHistory();

	List<Product> getInventory();

}
