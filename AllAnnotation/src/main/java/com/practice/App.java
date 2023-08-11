package com.practice;

import java.io.FileInputStream;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try{
    		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    		
    		Session session = sessionFactory.openSession();
    		
    		Transaction transaction = session.beginTransaction();
    		

    		//Creating Address
//    		Address address = new Address();
//    		address.setCity("nashik");
//    		address.setStreet("Shirdi-higheay");
//    		address.setOpen(true);
//    		address.setAddedDate(new Date(12));
//    		address.setX(2.2);
    		
    		//Inserting image
//    		FileInputStream fis = new FileInputStream("src/main/java/isro.jpg");
//    		byte[] data = new byte[fis.available()];
//    		fis.read(data);
//    		address.setImage(data);
    		

//    		session.save(address);
    		
    		
    		transaction.commit();
    		System.out.println("Done...");
    		
    		session.close();
    		sessionFactory.close();
    		

    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
