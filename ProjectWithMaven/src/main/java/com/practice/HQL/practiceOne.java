package com.practice.HQL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.Answer;
import com.practice.HibernateUtil;
import com.practice.Question;
import com.practice.Student;

public class practiceOne {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        
        
        //******* When You get Multiple Objects and you know the type of objects in return is Student ********     
//        Query query = session.createQuery("from Student");
//        List<Student> students = query.list();      
//        for(Student s: students) {
//        	System.out.println(s.getName()+ " "+ s.getCity());
//        }
        
        
        
        //******** When You get Unique Object and you know the type of object in return is Student **********
        //******** and Passing dynamic values in query ***********
//        Query query2 = session.createQuery("from Student as s where s.id=:i and s.city=:c");
//        query2.setParameter("i", 202);
//        query2.setParameter("c", "pune");
//        Student student =(Student) query2.uniqueResult();
//        System.out.println(student);
        
        
        
        
      //********* When You get Multiple Object but You know type of objects in return is NOT Student ***********        
//        Query query3 = session.createQuery("Select name,city from Student");
//        List<Object[]> students2 =(List<Object[]>) query3.list();
//        for(Object[] student: students2) {
//        	System.out.println(student[0] + " " +student[1]);
//        }
        
        
        
        //********* When You get Unique Object but You know type of object in return is NOT Student ***********        
//        Query query4 = session.createQuery("Select name,city from Student where id=201");
//        Object[] student2 =(Object[]) query4.uniqueResult();
//        System.out.println(student2[0] + " " +student2[1]);
        
        
        
        
        //********* Delete Clause ***********
//        Query q = session.createQuery("delete from Student as s where s.city=:c");
//        q.setParameter("c", "nagar");
//        int r = q.executeUpdate();
//        System.out.println(r+" Record Deleted Succesfully");
        
        
        
        
      //********* Update Clause ***********
//      Query q2 = session.createQuery("update Student as s set s.city=:c where s.name=:n");
//      q2.setParameter("c", "Nashik");
//      q2.setParameter("n", "Attish");
//      int result = q2.executeUpdate();
//      System.out.println(result+" updated successfully");
      
      
         //********* Join Column ********
//         Query q3 = session.createQuery("select q.question,q.id,a.answer from Question as q INNER JOIN q.answer as a ");
//         List <Object[]> questions = q3.getResultList();
//         
//         for(Object[] que: questions) {
//        	 System.out.println(Arrays.toString(que));
//         }
        
        transaction.commit();
        session.close();
        

	}

}
