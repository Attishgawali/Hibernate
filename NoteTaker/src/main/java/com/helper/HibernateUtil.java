package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static SessionFactory sessionFactory;
	
	
	
	public static SessionFactory getSessionFactory() {
		
		try {
			if(sessionFactory==null) {
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}

		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error occur during Intializing session Factory");
		}
		return sessionFactory;
	}
	
	
	
	public void closeFactory() {
		try {
			if(sessionFactory.isOpen()) {
				sessionFactory.close();
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error occur during Closing session Factory");
		}
	}
}
