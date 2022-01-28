package com.alex.transfer.service;

import java.util.List;

import com.alex.transfer.dto.Transfer;
import com.alex.transfer.model.Account;

public interface TransferService {

	String transferFund(Transfer transfer);

	List<Account> getAccounts();

}
