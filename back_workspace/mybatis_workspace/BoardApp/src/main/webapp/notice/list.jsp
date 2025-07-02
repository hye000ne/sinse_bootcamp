<%@page import="com.sinse.boardapp.model.Notice"%>
<%@page import="com.sinse.boardapp.repository.NoticeDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! 
	//list.jsp가 톰캣에 의해 서블릿으로 작성될 때 멤버 영역(선언부)
	NoticeDAO noticeDAO;
%>
<%
	//요청을 받는 service() 메서드 영역
	noticeDAO = new NoticeDAO();
	List<Notice> list = noticeDAO.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	
	<style>
		table {
			border-collapse: collapse;
			border-spacing: 0;
			width: 100%;
			border: 1px solid #ddd;
		}
		
		th, td {
			text-align: left;
			padding: 16px;
		}
		
		tr:nth-child(even) {
			background-color: #f2f2f2;
		}
	</style>
	<script>
		$(document).ready(()=>{
			$("#registBtn").click(()=> {
				location.href="/notice/write.jsp"
			});
		});	
	</script>
</head>
<body>
	<h2>게시판</h2>
	<p>목록</p>
	<table>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<% for(int i=0;i<list.size();i++) { %>
			<tr>
				<td><a href="/notice/content.jsp?id=<%= list.get(i).getNotice_id() %>"><%= list.get(i).getNotice_id() %></a></td>
				<td><%= list.get(i).getTitle() %></td>
				<td><%= list.get(i).getWriter() %></td>
				<td><%= list.get(i).getRegDate() %></td>
				<td><%= list.get(i).getHit() %></td>
			</tr>
		<% } %>
		<tr>
			<td colspan="5"><button id="registBtn">글쓰기</button></td>
		</tr>
	</table>
</body>
</html>
