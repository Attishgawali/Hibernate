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
		<h2>Add Your Note Here</h2>

		<form action="AddNoteServlet" method="get">
		
			<div class="form-group">
				<label for="title">Note Title</label> 
				<input
					name="title"
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
				placeholder="Enter Note here ..."></textarea>
			</div>

			<button type="submit" class="btn btn-primary">Add Note</button>
		</form>
	</div>
</body>
</html>