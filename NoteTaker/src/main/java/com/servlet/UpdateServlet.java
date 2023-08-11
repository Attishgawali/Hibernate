package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entites.Note;
import com.helper.HibernateUtil;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("note_id").trim());
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 Transaction transaction = session.beginTransaction();
		 
		 Note note =(Note) session.get(Note.class, id);
		 note.setTitle(title);
		 note.setContent(content);
		 note.setAddedDate(new Date());
		 
		 transaction.commit();
		 session.close();
		 
		 response.sendRedirect("show_notes.jsp");

	}



}
