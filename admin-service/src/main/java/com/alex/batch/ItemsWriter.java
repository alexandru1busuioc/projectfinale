package com.alex.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alex.entity.Items;
import com.alex.repository.ItemsRepository;

@Component
public class ItemsWriter implements ItemWriter<Items>{
	@Autowired
	private ItemsRepository repo;

	@Override
	@Transactional
	public void write(List<? extends Items> items) throws Exception {
		repo.saveAll(items);
	}
}
