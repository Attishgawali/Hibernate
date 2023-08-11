 package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 // Get the SessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        

        //Open new session
        Session session = sessionFactory.openSession();
        
        //Start Transaction
        Transaction transaction = session.beginTransaction();
        
        //Perform database opernation
        Student student = new Student(102,"Tejas","Nashik");
        
        session.save(student);
        
        //Commit the tansaction
        transaction.commit();

        
    }
}
