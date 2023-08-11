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
    	//********* Transient State ************
    	Student stu = new Student();// it is not reflect in database
    	stu.setId(203);
    	stu.setName("Omkar");
    	stu.setCity("nagar");
  
    	
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	//********* Persistent state *********
    	session.update(stu); //Object transitions to persistent state -session,database
    	stu.setName("Shubham"); //changes reflect in database as well
    	
    	
    	//*********** Detached state *********
    	session.evict(stu);  // Explicitly detach the object
    	stu.setName("Ajinkya"); //changes is not reflect in database 
    	
    	
    	System.out.println(stu.getName());
    	transaction.commit();
    	session.close();
    	
    	

    	
    	
    }
}
