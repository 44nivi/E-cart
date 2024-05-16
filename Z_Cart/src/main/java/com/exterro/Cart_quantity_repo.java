package com.exterro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Cart_quantity_repo extends JpaRepository<Cart_quantity,Integer>{

	//List<Cart_quantity> save(Cart_quantity qty);

	
	List<Cart_quantity> findAll();

}
