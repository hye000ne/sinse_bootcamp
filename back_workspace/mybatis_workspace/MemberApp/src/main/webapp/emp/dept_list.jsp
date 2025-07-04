<%@page import="com.sinse.memberapp.model.Dept"%>
<%@page import="java.util.List"%>
<%@page import="com.sinse.memberapp.repository.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	DeptDAO deptDAO = new DeptDAO();
	List<Dept> list = deptDAO.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<table width="100%">
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>부서위치</th>
			<th>사원수</th>
		</tr>
		<% for(Dept dept : list) {%>
			<tr align="center">
				<td><%= dept.getDeptno() %></td>
				<td><%= dept.getDname() %></td>
				<td><%= dept.getLoc() %></td>
				<td><%= dept.getEmpList().size() %></td>
			</tr>
		<% } %>
	</table>
</body>
</html>