<%@page import="com.sinse.memberapp.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 이 서블릿에 요청을 시도할때, 웹컨테이너에서는 세션 객체를 생성하면서 동시에 세션 ID가 할당되어짐
	// 그리고 이 세션 아이디는 톰캣이 보내는 응답정보에 쿠키형태로 존재하게 됨
	// 단, 세션과 세션아이디는 매 요청마다 만들어지는게 아니라, 클라이언트가 요청 시 톰캣이 발급한 쿠기가 존재하지 않을 때는 새로만들고
	// 요청 후 일정시간동안 아무런 재요청이 없을 때는 사용하지 않는 것으로 판단하여 새롭게 세션 할당
	
	// 만일 이 페이지의 요청 자가 로그인 성공한 사람이라면 세션에 loginMember라는 이름으로 담겨있음
	Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<%= member.getName() %>님 안녕하세요.
</body>
</html>