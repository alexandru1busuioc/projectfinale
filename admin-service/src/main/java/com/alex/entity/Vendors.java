package com.alex.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Vendors {

	@Id
	private Long id;
	private String name;
	private String description;
}
