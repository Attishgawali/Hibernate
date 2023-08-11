package com.practice.CacheHibernate.firstLevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
			Session session1 = sessionFactory.openSession();
			Transaction transaction = session1.beginTransaction();
			

			
			transaction.commit();
			
			Student student1 = (Student)session1.get(Student.class, 201);
			System.out.println(student1);
			
			Student student2 = (Student)session1.get(Student.class, 201);
			System.out.println(student2);
			
			
			session1.close();
			
			
			System.out.println(session1.contains(student1));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	

}
