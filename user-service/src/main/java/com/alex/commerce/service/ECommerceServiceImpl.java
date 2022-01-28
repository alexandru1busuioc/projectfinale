package com.alex.commerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.commerce.dto.Transaction;
import com.alex.commerce.dto.Transfer;
import com.alex.commerce.feignclient.TransferClient;
import com.alex.commerce.model.Product;

@Service
public class ECommerceServiceImpl implements ECommerceService {
	
	@Autowired
	TransferClient transferClient;

	static List<Product> products = new ArrayList<>();
	
	static List<Transaction> transactions = new ArrayList<>();
	
	static {
		Product p1 = new Product();
		p1.setName("Samsung Galaxy S10 phone");
		p1.setPieces(20);
		p1.setPrice(1000);
		products.add(p1);
		
		Product p2 = new Product();
		p2.setName("IPhone S6 phone");
		p2.setPieces(40);
		p2.setPrice(200);
		products.add(p2);
		
		Product p3 = new Product();
		p3.setName("Samsung TV");
		p3.setPieces(50);
		p3.setPrice(450);
		products.add(p3);
		
	}
	
	@Override
	public List<Product> searchProductLike(String name) {
		List<Product> retrievedProducts = new ArrayList<>();
		products.stream()
				.filter(p -> p.getName().contains(name))
				.forEach(retrievedProducts::add);

		return retrievedProducts;
	}

	@Override
	public String buyProduct(Transaction transaction) {
		for(Product p : transaction.getProducts()) {
			for(Product product: products) {
				if(p.getName().equalsIgnoreCase(product.getName())) {
					product.setPieces(product.getPieces()-p.getPieces());
				}
			}
		}
		 
		Transfer transfer = new Transfer();
		transfer.setAmount(transaction.getAmount());
		transfer.setFrom(transaction.getFrom());
		transfer.setRemarks(transaction.getRemarks());
		transfer.setTo("DF08343SFDS03");
		String message = transferClient.transferFund(transfer);
		transactions.add(transaction);
		
		return message;
	}

	@Override
	public List<Transaction> getHistory() {
		return transactions;
	}

	@Override
	public List<Product> getInventory() {
		return products;
	}

}
