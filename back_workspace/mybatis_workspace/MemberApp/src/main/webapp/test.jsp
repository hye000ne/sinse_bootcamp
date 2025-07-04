<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	/* 
		자바 코드 안에 로직이 아닌 설정 정보를 직접 작성하면 유지보수성이 떨어짐 
		개발자는 자바 코드 밖에 외부 설정파일로 자원 관리가 가능한데 이걸 JNDI(Java Naming Directory Interface)라 한다.
		설정 정보를 외부에 두고서 이름으로 찾아서 자원을 접근하는 기술
		이 실습은 여러 자원들 중 JNDI로 관리할 대상이 아파치에서 만든 커넥션 풀인 것 뿐이다.
	*/
	InitialContext context = new InitialContext();

	// server.xml에 명시된 jndi/mysql 이라는 이름으로 검색 시작
	DataSource ds = (DataSource)context.lookup("java:comp/env/jndi/mysql");
	Connection conn = ds.getConnection();
	out.print(conn);
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