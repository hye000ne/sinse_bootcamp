<%@page import="com.sinse.memberapp.model.Emp"%>
<%@page import="java.util.List"%>
<%@page import="com.sinse.memberapp.repository.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	EmpDAO empDAO = new EmpDAO();
	List<Emp> list = empDAO.selectAll();
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
			<th>사원번호</th>
			<th>사원명</th>
			<th>업무</th>
			<th>관리자</th>
			<th>고용일</th>
			<th>급여</th>
			<th>커미션</th>
			<th>부서명</th>
			<th>부서위치</th>
		</tr>
		<% for(Emp emp : list) {%>
			<tr align="center">
				<td><%= emp.getEmpno() %></td>
				<td><%= emp.getEname() %></td>
				<td><%= emp.getJob() %></td>
				<td><%= emp.getMgr() %></td>
				<td><%= emp.getHiredate() %></td>
				<td><%= emp.getSal() %></td>
				<td><%= emp.getComm() %></td>
				<td><%= emp.getDept().getDname() %></td>
				<td><%= emp.getDept().getLoc() %></td>
			</tr>
		<% } %>
	</table>
</body>
</html>