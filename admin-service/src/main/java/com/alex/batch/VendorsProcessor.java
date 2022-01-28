package com.alex.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alex.entity.Vendors;
import com.alex.repository.VendorsRepository;

@Component
public class VendorsProcessor implements ItemProcessor<Vendors, Vendors> {

	@Autowired
	private VendorsRepository vendorsRepo;

	@Override
	public Vendors process(Vendors vendors) throws Exception {
		return vendors;
	}

}
