package com.exterro;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin_Regi,Integer> {

	Admin findByNameAndPassword(String name, String password);

	/* Admin findByName(String fname); */


	
}
