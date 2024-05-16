package com.exterro;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class file_upload {

@Id
@GeneratedValue
private int Empid;

@Column
String	name;
String email; 
String pass; 
String cpass;

@Column
@Lob
Blob blob;



public file_upload(String name, String email, Blob blob, String pass, String cpass) {
	super();
	this.name = name;
	this.email = email;
	this.blob = blob;
	this.pass = pass;
	this.cpass = cpass;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Blob getresume() {
	return blob;
}
public void setresume(Blob resume) {
	this.blob = blob;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getCpass() {
	return cpass;
}
public void setCpass(String cpass) {
	this.cpass = cpass;
}

}
