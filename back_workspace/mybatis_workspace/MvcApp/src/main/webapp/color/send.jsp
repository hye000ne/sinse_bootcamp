<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<form action="/color.do" method="get">
		<select name="color">
			<option value="">색상 선택</option>
			<option value="red">RED</option>
			<option value="blue">BLUE</option>
			<option value="yellow">YELLOW</option>
			<option value="green">GREEN</option>
		</select>
		<button>전송</button>	
	</form>
</body>
</html>