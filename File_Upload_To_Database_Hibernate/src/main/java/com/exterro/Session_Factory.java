package com.exterro;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Session_Factory {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

	try {
	// Create the SessionFactory from hibernate.cfg.xml
	return new Configuration().configure("hiber.cfg.xml").buildSessionFactory();
	} catch (Throwable ex) {
	// Make sure you log the exception, as it might be swallowed
	System.err.println("Initial SessionFactory creation failed." + ex);
	throw new ExceptionInInitializerError(ex);
	}
	}

	public static void shutdown() {
	// Close caches and connection pools
	getSessionFactory().close();
	}

	public static SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return sessionFactory;
	}
}
