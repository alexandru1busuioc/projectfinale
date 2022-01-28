package com.alex.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Items {

	@Id
	private Long id;
	private String name;
	private Long vendor_id;
	private String description;
	private String price;
}
