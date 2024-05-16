package com.exterro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringFilters2Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringFilters2Application.class, args);
		Internet_Connection obj =context.getBean(Internet_Connection.class);
		obj.connect();
		
		Internet_Connection obj2=context.getBean(Internet_Connection.class);
		obj2.connect();
	}	

}
