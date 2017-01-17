package com.oren.practicehelper.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.oren.practicehelper.jpa.entities.UserStock;
import com.oren.practicehelper.services.UserStockService;

@RestController
@RequestMapping("/userstock")
public class UserStockController {

	@Autowired
	private UserStockService userStockService;
	
	@RequestMapping(value="/buy", method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody UserStock userStock, UriComponentsBuilder ucBuilder) {
		userStockService.saveUserStock(userStock);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/userstock/find/{id}").buildAndExpand(userStock.getId()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/sell/{id}", method=RequestMethod.GET)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") long id, UriComponentsBuilder ucBuilder) {
		userStockService.deleteUserStock(id);
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@RequestMapping("/findbyuserid/{userId}")
	public UserStock[] findByUserId(@PathVariable String userId) {
		return userStockService.findUserStocks(userId);
	}
	
	@RequestMapping("/findbyid/{id}")
	public UserStock findById(@PathVariable long id) {
		return userStockService.findStock(id);
	}
	
}
