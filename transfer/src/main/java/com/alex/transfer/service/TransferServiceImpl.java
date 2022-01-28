package com.alex.transfer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alex.transfer.dto.Transfer;
import com.alex.transfer.model.Account;

@Service
public class TransferServiceImpl implements TransferService{

	private static List<Account> accounts = new ArrayList<>(); 
	
	static {
		
		Account account1 = new Account();
		account1.setNumber("FG08903DFDS00");
		account1.setAmount(1000);
		accounts.add(account1);
		
		
		Account account2 = new Account();
		account2.setNumber("DF08343SFDS03");
		account2.setAmount(1000);
		accounts.add(account2);
		
	}
	
	@Override
	public String transferFund(Transfer transfer) {
		accounts.stream()
				.filter(a -> a.getNumber().equalsIgnoreCase(transfer.getFrom()))
				.forEach(a -> a.setAmount(a.getAmount()-transfer.getAmount()));
		
		accounts.stream()
				.filter(a -> a.getNumber().equalsIgnoreCase(transfer.getTo()))
				.forEach(a -> a.setAmount((a.getAmount()+transfer.getAmount())));
		
		return "Succesfully transfered";
	}

	@Override
	public List<Account> getAccounts() {
		return accounts;
	}

}
