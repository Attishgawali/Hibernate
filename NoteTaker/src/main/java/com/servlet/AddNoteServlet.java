package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entites.Note;
import com.helper.HibernateUtil;


public class AddNoteServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			//string into DB
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Note note = new Note(title,content,new Date());
			
			session.save(note);
			
			transaction.commit();
			
			session.close();
			
			PrintWriter out = response.getWriter();
			
			out.print("<h1 style='text-align: center'>Note Added Successfully </h1> <br>"
					+ "<h2 style='text-align: center'><a href='show_notes.jsp'>Show All Notes</a></h2>");
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
