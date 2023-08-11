package com.practice.cretiria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.practice.HibernateUtil;
import com.practice.Student;

public class CretiriaAPI {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria c = session.createCriteria(Student.class);
		c.add(Restrictions.eq("city", "nashik"));
		
		List <Student> students = c.list();
		
		for(Student s: students) {
			System.out.println(s.getName()+ " " + s.getCity());
		}

		transaction.commit();
		session.close();

	}

}
