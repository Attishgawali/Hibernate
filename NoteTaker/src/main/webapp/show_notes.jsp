<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.entites.Note"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.helper.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<h2>Your Notes :</h2>

		<%
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		Query q = session2.createQuery("from Note");
		List<Note> list = q.list();

		for (Note note : list) {
		%>

		<div class="card mt-3 text-center">
			<img class="card-img-top m-4 mx-auto" style="max-width: 100px"
				src="img/notes.png" alt="Card image cap">
			<div class="card-body pt-0">
				<h5 class="card-title"><%=note.getTitle()%></h5>
				<p class="card-text"><%= note.getContent()%></p>
				<p class="card-text"><b style="color: #4477CE; font-size: 18px; "><%= note.getAddedDate() %></b></p>
				<a href="DeleteServlet?note_id=<%=note.getId()%>" class="btn btn-danger">Delete</a>
				<a href="update_note.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Update</a>
			</div>
		</div>


		<%
		}

		session2.close();
		%>

	</div>

</body>
</html>