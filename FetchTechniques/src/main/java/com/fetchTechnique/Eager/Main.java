package com.fetchTechnique.Eager;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		try {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			//Creating Student Obejct 
//			Student s1 = new Student();
//			s1.setSid(101);
//			s1.setSname("Attish");
//			
//			Book b1 = new Book();
//			b1.setBid(201);
//			b1.setBname("English"); 
//			b1.setStudent(s1);
//			
//			Book b2 = new Book();
//			b2.setBid(202);
//			b2.setBname("Math");
//			b2.setStudent(s1);
//			
//			ArrayList<Book> books = new ArrayList<Book>();
//			books.add(b1);
//			books.add(b2);
//			
//			s1.setBooks(books);
//			
//			session.save(s1);
//			session.save(b1);
//			session.save(b2);
			
			tx.commit();
			
			Student stu =(Student) session.get(Student.class, 101);
//			System.out.println(stu.getSname());
			for(Book b: stu.getBooks()) {
				System.out.println(b);
			}
			
			
		
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
