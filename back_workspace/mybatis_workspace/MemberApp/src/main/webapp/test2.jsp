<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.sinse.memberapp.mybatis.MybatisConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	MybatisConfig conf = MybatisConfig.getInstance();
	SqlSession sqlSession = conf.getSqlSession();
	out.print(sqlSession);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	
</body>
</html>