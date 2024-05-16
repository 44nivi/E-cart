package com.exterro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class User_Controller_Cart {
	
	@Autowired
	User_cart service;
	
	@PostMapping("addtocart")
	public ResponseEntity<?> addStudent( Product prod){
		return ResponseEntity.ok(prodrepo.save(prod));
	}

}
