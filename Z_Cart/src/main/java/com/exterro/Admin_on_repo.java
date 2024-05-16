package com.exterro;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface Admin_on_repo extends JpaRepositoryImplementation<Admin_add_on, Integer> {

	List<Admin_add_on> findByGender(String gender);

	List<Admin_add_on> findByName(String find);

}
