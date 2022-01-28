package com.alex.commerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.alex.commerce.dto.Transaction;
import com.alex.commerce.dto.Transfer;
import com.alex.commerce.feignclient.TransferClient;
import com.alex.commerce.model.Product;

@ExtendWith(SpringExtension.class)
public class ECommerceServiceImplTest {

	@InjectMocks
	ECommerceServiceImpl eCommerceServiceImpl;
	
	@Mock
	TransferClient transferClient;
	
	@Test
	public void testBuyProduct() {
		Transaction transaction = new Transaction();
		List<Product> list = new ArrayList<>();
		Product p1 = new Product();
		p1.setName("IPhone S6 phone");
		list.add(p1);
		Product p2 = new Product();
		p2.setName("Samsung TV");
		list.add(p2);
		Transfer transfer = new Transfer();
		transaction.setProducts(list);
		Mockito.when(transferClient.transferFund(transfer)).thenReturn("Succesfully transfered");
		String message = eCommerceServiceImpl.buyProduct(transaction);
		assertEquals("Succesfully transfered",message);
	}
	
}
