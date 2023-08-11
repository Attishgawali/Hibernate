package com.practice.CacheHibernate.secondLevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SecondCacheExample {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg2.xml").buildSessionFactory();
		

		
		
		
		//************* Session 1 Open *************
		Session session1 = sessionFactory.openSession();

		Transaction transaction = session1.beginTransaction();
		transaction.commit();
		
		Employee employee =(Employee) session1.get(Employee.class, 201);
		System.out.println(employee);
		
		session1.close();
		// *********** Session 1 Close *************
		
		
		
		//************* Session 2 Open **************
		Session session2 = sessionFactory.openSession();

		Transaction transaction2 = session2.beginTransaction();
		transaction2.commit();
		
		Employee employee2 =(Employee) session2.get(Employee.class, 201);
		System.out.println(employee2);
		
		session2.close();
		//************* Session 2 Close **************
		

	}

}
