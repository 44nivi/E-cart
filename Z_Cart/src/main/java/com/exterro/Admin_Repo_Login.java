package com.exterro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Admin_Repo_Login extends JpaRepository<Admin, String> {


	Admin findByNameAndPassword(String name, String password);
}