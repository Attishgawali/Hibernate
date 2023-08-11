<%@page import="com.entites.Note"%>
<%@page import="com.helper.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Note : NoteTaker</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<h2>Update Your Note Here</h2>
		<%
		Long id = Long.parseLong(request.getParameter("note_id"));
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		Note note = (Note) s.get(Note.class, id);
		%>

		<form action="UpdateServlet" method="get">
			<input type="hidden" name="note_id" value="<%= note.getId()%>">
			<div class="form-group">
				<label for="title">Note Title</label> 
				<input
					name="title"
					value="<%=note.getTitle() %>"
					type="text" 
					class="form-control" 
					id="title"
					aria-describedby="emailHelp" 
					placeholder="Enter title">
			</div>
			
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea 
				name="content"
				rows="15" 
				cols="30" 
				id="content" 
				class="form-control" 
				placeholder="Enter Note here ..."><%=note.getContent()%></textarea>
			</div>

			<button type="submit" class="btn btn-primary">Update Note</button>
		</form>
	</div>
</body>
</html>