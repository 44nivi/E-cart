package com.exterro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Count_repo extends JpaRepository<Cart_quantity,Integer>{


	Integer countByProductid(String productid);






}
