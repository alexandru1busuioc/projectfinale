package com.alex.transfer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.alex.transfer.dto.Transfer;

@ExtendWith(SpringExtension.class)
public class TransferServiceImplTest {
	
	@InjectMocks
	TransferServiceImpl transferServiceImpl;
	
	@Test
	void testTransferFund() {
		Transfer transfer = new Transfer();	
		String message = transferServiceImpl.transferFund(transfer);
		assertEquals("Succesfully transfered",message);
	}

}
