package com.practice.pagination;

import org.hibernate.query.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.HibernateUtil;
import com.practice.Student;

public class HQLpagination {
		
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        
        Query q = session.createQuery("from Student");
        q.setFirstResult(0);
        q.setMaxResults(10);
        
        List<Student> students = q.list();
        
        for(Student s: students) {
        	 System.out.println(s.getName()+ " : "+ s.getCity());
        }
        
       
        
        
        
        transaction.commit();
        session.close();
		
	}
}
