package com.practice.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.practice.HibernateUtil;
import com.practice.Student;

public class SQLExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        
        //SQL Query
        String q= "select * from student"; //here student refers to table
        NativeQuery nq = session.createSQLQuery(q);
        		
        List<Object[]> students = nq.list();
        
        for(Object[] s: students) {
        	System.out.println(Arrays.toString(s));
        }

	}

}
