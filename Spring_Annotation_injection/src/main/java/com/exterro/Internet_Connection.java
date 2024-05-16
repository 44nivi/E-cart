package com.exterro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Internet_Connection {
	@Autowired(required=true)
	@Qualifier("cab")
	private Internet_Configuration ob;
	public Internet_Connection() {
		System.out.println("hi i am constructor!!");
	}

	public void connect() {
		ob.switchon();
		System.out.println("Internet connection successful");
	}
}
