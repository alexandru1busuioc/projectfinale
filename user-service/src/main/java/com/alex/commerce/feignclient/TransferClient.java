package com.alex.commerce.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alex.commerce.dto.Transfer;

@FeignClient(value = "transfer-service", url = "http://localhost:8082/transfer/transfers")
public interface TransferClient {
	
	@PostMapping("/fundtransfer")
	public String transferFund(@RequestBody Transfer transfer);

}
