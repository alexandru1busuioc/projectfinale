package com.alex.commerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alex.commerce.dto.Transaction;
import com.alex.commerce.model.Product;
import com.alex.commerce.service.ECommerceService;

@RestController
public class ECommerceController {

	@Autowired
	ECommerceService eCommerceService;
	 
	@GetMapping("/productLike")
	public ResponseEntity<List<Product>> searchProductLike(@RequestParam String name){
		return new ResponseEntity<>( eCommerceService.searchProductLike(name),HttpStatus.OK);
	}
	
	@PostMapping("/product")
	public ResponseEntity<String> buyProduct(@RequestBody @Valid Transaction transaction) {
		return new ResponseEntity<>( eCommerceService.buyProduct(transaction),HttpStatus.OK);
	}
	
	@GetMapping("/history")
	public ResponseEntity<List<Transaction>> getHistory(){
		return new ResponseEntity<>( eCommerceService.getHistory(),HttpStatus.OK);
	}
	
	@GetMapping("/inventory")
	public ResponseEntity<List<Product>> getInventory(){
		return new ResponseEntity<>( eCommerceService.getInventory(),HttpStatus.OK);
	}

}
