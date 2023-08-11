package com.practice.cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.Answer;
import com.practice.HibernateUtil;
import com.practice.Question;

public class Example {

	public static void main(String[] args) {
		
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Question q =new Question();
        q.setId(303);
        q.setQuestion("What is Python");
        
        Answer ans1= new Answer();
        ans1.setId(403);
        ans1.setAnswer("Python is programming lang");
        
        Answer ans2= new Answer();
        ans2.setId(404);
        ans2.setAnswer("Python is use for ML");
        
        List<Answer> answers = new ArrayList<Answer>();
        answers.add(ans1);
        answers.add(ans2);
        
        q.setAnswer(answers);
        
        
        //Here  we use CascadingType ALL in Question Class so we not need to save answers of question separately
        session.save(q);
        
        
        
        transaction.commit();
        session.close();
        

	}

}
