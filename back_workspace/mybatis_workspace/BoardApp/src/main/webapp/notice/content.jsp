<%@page import="com.sinse.boardapp.model.Notice"%>
<%@page import="com.sinse.boardapp.repository.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	NoticeDAO noticeDAO = new NoticeDAO();
	Notice notice = noticeDAO.select(Integer.parseInt(request.getParameter("id")));
%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>
	<style>
		body {
			font-family: Arial, Helvetica, sans-serif;
		}
		
		* {
			box-sizing: border-box;
		}
		
		input[type=text], select, textarea {
			width: 100%;
			padding: 12px;
			border: 1px solid #ccc;
			border-radius: 4px;
			box-sizing: border-box;
			margin-top: 6px;
			margin-bottom: 16px;
			resize: vertical;
		}
		
		input[type=button] {
			background-color: #04AA6D;
			color: white;
			padding: 12px 20px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}
		
		input[type=button]:hover {
			background-color: #45a049;
		}
		
		.container {
			border-radius: 5px;
			background-color: #f2f2f2;
			padding: 20px;
		}
	</style>
	<script>
		$(()=>{
			// 서머노트 연동
			$("#content").summernote({
		        height: 250,
				<%-- code: "<%= notice.getContent() %>" --%>
			});
		});
	</script>
</head>
<body>
	<h3>Contact Form</h3>

	<div class="container">
		<form>
			<label for="title">Title</label> 
			<input type="text" id="title" name="title" value=<%= notice.getTitle() %>>
			
			<label for="writer">Writer</label> 
			<input type="text" id="writer" name="writer" value=<%= notice.getWriter() %>>
			
			<label for="content">Content</label>
			<textarea id="content" name="content" style="height: 200px"> <%= notice.getContent() %></textarea>
		</form>
	</div>

</body>
</html>
