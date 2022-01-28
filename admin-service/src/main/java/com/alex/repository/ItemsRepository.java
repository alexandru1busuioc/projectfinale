package com.alex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Long>{

}
