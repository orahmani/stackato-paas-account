package com.oren.practicehelper.services.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oren.practicehelper.jpa.entities.UserStock;
import com.oren.practicehelper.jpa.repositories.UserStockRepository;
import com.oren.practicehelper.services.UserStockService;

@Service
@Transactional
public class UserStockServiceImpl implements UserStockService{
	
	@Autowired
	private UserStockRepository userStockRepository;


	@Override
	public void saveUserStock(UserStock userStock) {
		userStock.setDate(new Date(System.currentTimeMillis()));
		userStockRepository.save(userStock);
	}


	@Override
	public UserStock[] findUserStocks(String userId) {
		UserStock[] userStock = null;
		try{
			userStock = userStockRepository.findStocksByUserId(userId);
		}catch(Exception e){
			throw e;
		}
		return userStock;
	}


	@Override
	public void deleteUserStock(long id) {
		userStockRepository.delete(id);
	}


	@Override
	public UserStock findStock(long id) {
		return userStockRepository.findOne(id);
	}

}
