package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entites.Note;
import com.helper.HibernateUtil;


public class DeleteServlet extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Long id = Long.parseLong(request.getParameter("note_id"));
		 
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 Transaction transaction = session.beginTransaction();
		 
		 Note note =(Note) session.get(Note.class, id);
		 
		 session.delete(note);
		 
		 transaction.commit();
		 
		 session.close();
		 
		 response.sendRedirect("show_notes.jsp");

	}


}
