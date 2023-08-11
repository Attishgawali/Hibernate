package com.practice;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		try {
			
			//create session factory from hibernate.cfg.xml
			
//			Configuration configuration = new Configuration();
//			Configuration configure = configuration.configure("hibernate.cfg.xml");
//			sessionFactory = configure.buildSessionFactory();
//			OR 
			
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Failed to create session factory");
			
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
