package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GetAndLoad {
	 public static void main( String[] args ) {

 	try{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		//Creating Person 
//		Person person1 = new Person();
//		person1.setName("Attish");
//		person1.setCourse("Java");
		
//		Person person2 = new Person();
//		person2.setName("Tejas");
//		person2.setCourse("Python");
		
//		Person person2 = new Person();
//		person2.setName("Tejas");
//		person2.setCourse("Python");
		
		//saving persons object to database
//		session.save(person1);
//		session.save(person2);
		
		
		
		//*************** GET method ***************
		
//		Person person = session.get(Person.class, 1);  // As object call first time get will hot database
//		Person person2 = session.get(Person.class, 1); // Here as object with id 1 is alreday call in previous session and 
//														it is stored in session cache memory hence get will not 
//														hit database again it will simply return previous object
//		System.out.println(person);
//		System.out.println(person2.getName()+ " :"+person2.getCourse());
		
		
		
		
		
		//*****************LOAD Method *********************
		
//		Person p = session.load(Person.class, 2); //till here load method will return only proxy(imaginary) object and 
												 // not hit database till now
		
//		System.out.println(p.getCourse()); //when any method on object is called not laod hit database to get real object
		

		
		
		transaction.commit();
		System.out.println("Done...");
		
		session.close();
		sessionFactory.close();
		

	}catch(Exception e) {
		e.printStackTrace();
	}
 	
	}


}
