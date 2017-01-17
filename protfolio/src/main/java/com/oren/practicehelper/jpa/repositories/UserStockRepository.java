package com.oren.practicehelper.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oren.practicehelper.jpa.entities.UserStock;

public interface UserStockRepository extends CrudRepository<UserStock, Long>{
	
	public UserStock[] findStocksByUserId(String id);

}
