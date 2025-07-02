<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String bg = request.getParameter("bg");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(()=>{
		$("button").click(()=>{
			location.href="/color/main.jsp?bg="+$("select").val(); 
		});
	});
	</script>
</head>
<body bgcolor="<%=bg%>">
	<select>
		<option <%if(bg.equals("red")) { %> selected <% } %> value="red">red</option>
		<option <%if(bg.equals("blue")) { %> selected <% } %> value="blue">blue</option>
		<option <%if(bg.equals("orange")) { %> selected <% } %> value="orange">orange</option>
		<option <%if(bg.equals("green")) { %> selected <% } %> value="green">green</option>
	</select>
	
	<button>배경색 바꾸기</button>	
</body>
</html>