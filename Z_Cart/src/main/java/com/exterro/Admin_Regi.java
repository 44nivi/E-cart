package com.exterro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin_Regi")
public class Admin_Regi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	private String lname;
	private String password;
	private String Rpass;
	private String email;	
	
	
	public Admin_Regi(String name, String lname, String password, String rpass, String email) {
		super();
		this.name = name;
		this.lname = lname;
		this.password = password;
		this.Rpass = rpass;
		this.email = email;
	}
	
	public String getFname() {
		return name;
	}
	public void setFname(String name) {
		this.name = name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPass() {
		return password;
	}
	public void setPass(String password) {
		this.password = password;
	}
	public String getRpass() {
		return Rpass;
	}
	public void setRpass(String rpass) {
		Rpass = rpass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
