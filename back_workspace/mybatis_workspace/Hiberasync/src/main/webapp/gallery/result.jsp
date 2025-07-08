<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<% 
		String imgName = (String)session.getAttribute("img");
	%>
	<img alt="" src="/data/<%= imgName %>" style="width:300px;height:300px">	
</body>
</html>