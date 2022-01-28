package com.alex.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alex.entity.Items;
import com.alex.repository.ItemsRepository;

@Component
public class ItemsProcessor implements ItemProcessor<Items, Items> {

	@Autowired
	private ItemsRepository itemsRepo;

	@Override
	public Items process(Items item) throws Exception {
		return item;
	}

}