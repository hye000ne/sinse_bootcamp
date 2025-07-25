<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% int totalRecord=961; // 총 레코드 수 
	int pageSize=10; // 페이지 당 보여질 레코드 수 
	int totalPage=totalRecord/pageSize + (totalRecord%pageSize==0? 0 : 1); // 총 페이지 수 
	// int totalPage=(int)Math.ceil((float)totalRecord/pageSize); 
	int blockSize=10; 
	int currentPage=1; // 현재 유저가 보고있는 페이지 
	if(request.getParameter("currentPage") !=null) {
		currentPage=Integer.parseInt(request.getParameter("currentPage")); 
	} 
	int firstPage=currentPage - (currentPage-1) % 10; //블럭당 시작 페이지 
	int lastPage=((firstPage + (blockSize-1))> totalRecord) ? totalRecord : (firstPage + (blockSize-1)); //블럭당 마지막 페이지
%>
<%= "totalRecord=" +totalRecord+"<br>" %>
<%= "pageSize=" +pageSize+"<br>" %>
<%= "totalPage=" +totalPage+"<br>" %>
<%= "blockSize=" +blockSize+"<br>" %>
<%= "currentPage=" +currentPage+"<br>" %>
<%= "firstPage=" +firstPage+"<br>" %>
<%= "lastPage=" +lastPage+"<br>" %>
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

.pageNum {
	font-size: 27;
	font-weight: bold;
	color: red;
}
</style>
</head>

<body>
	<table>
		<tr>
			<th>No</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Points</th>
		</tr>
		<% for(int i=1+(blockSize*(currentPage-1));i<=blockSize*currentPage;i++) {
												%>
		<tr>
			<td><%= i %></td>
			<td>Jill</td>
			<td>Smith</td>
			<td>50</td>
		</tr>
		<% } %>
		<tr>
			<td colspan="4" align="center"><a
				href="/board/list.jsp?currentPage=<%= firstPage-1 %>">◀</a> <% for(int i=firstPage;i<=lastPage;i++) { %>
				<a <% if(i==currentPage) { %> class="pageNum" <% } %>
				href="/board/list.jsp?currentPage=<%=i %>">[ <%=i%>]
			</a> <% } %> <a href="/board/list.jsp?currentPage=<%= lastPage+1 %>">▶</a>
			</td>
		</tr>
	</table>
</body>

</html>