package com.oren.practicehelper.services;

import com.oren.practicehelper.jpa.entities.UserStock;

public interface UserStockService {
	
	public void saveUserStock(UserStock userStock);
	
	public UserStock[] findUserStocks(String userId);
	
	public UserStock findStock(long id);
	
	public void deleteUserStock(long id);
}
