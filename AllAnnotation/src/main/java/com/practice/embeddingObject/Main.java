package com.practice.embeddingObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		//Creating Student object
		Student student = new Student();		
		student.setName("Omkar");
		
		//Creating Certificate object for student
		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 months");
		
		student.setCertificate(certificate);
		
		session.save(student);
		
		tx.commit();
		
		session.close();
		

	}

}
