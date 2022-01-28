package com.alex.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alex.entity.Vendors;
import com.alex.repository.VendorsRepository;

@Component
public class VendorsWriter implements ItemWriter<Vendors>{
	@Autowired
	private VendorsRepository repo;

	@Override
	@Transactional
	public void write(List<? extends Vendors> vendors) throws Exception {
		repo.saveAll(vendors);
	}
}
