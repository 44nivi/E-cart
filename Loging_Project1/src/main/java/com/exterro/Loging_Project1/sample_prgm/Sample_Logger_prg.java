package com.exterro.Loging_Project1.sample_prgm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sample_Logger_prg {
	public static Logger log = LogManager.getLogger(Sample_Logger_prg.class);

	public static void main(String[] args) {
		System.out.println("Hello World!");
		log.info("Hello this is a debug message");

	}

}
