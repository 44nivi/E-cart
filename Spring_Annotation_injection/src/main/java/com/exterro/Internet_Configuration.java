package com.exterro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("cab")
public class Internet_Configuration {
@Autowired(required=true)
@Qualifier("abc")
private Lan_Connection obj;
private float ip_Address;
private String domain;
public float getIp_Address() {
	return ip_Address;
}
public void setIp_Address(float ip_Address) {
	this.ip_Address = ip_Address;
}
public String getDomain() {
	return domain;
}
public void setDomain(String domain) {
	this.domain = domain;
}
public void switchon() {
	obj.ip();
	System.out.println("the internet connection configuration is successful");
}
}
