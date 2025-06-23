<%@page import="com.sinse.notice.model.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!// !를 선언하면, 선언부라 하여 멤버변수와 멤버메서드를 작성할 수 있다.
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/shop";
	String user = "shop";
	String pwd = "1234";

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public void connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
%>

<% connect();

	int noticeId = Integer.parseInt(request.getParameter("notice_id"));
	
	StringBuffer sql = new StringBuffer();
	sql.append("select * from notice where notice_id="+noticeId);//유저가 선택한 pk
	pstmt = con.prepareStatement(sql.toString());
	rs = pstmt.executeQuery();
	out.print(sql.toString());
	
	Notice notice = null;
	if (rs.next()) {
		notice = new Notice();
		
		notice.setNotice_id(rs.getInt("notice_id"));
		notice.setTitle(rs.getString("title"));
		notice.setWriter(rs.getString("writer"));
		notice.setRegdate(rs.getString("regdate"));
		notice.setContent(rs.getString("content"));
		notice.setHit(rs.getInt("hit"));
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<style>
			body {font-family: Arial, Helvetica, sans-serif;}
			* {box-sizing: border-box;}
			
			input[type=text], select, textarea {
			  width: 100%;
			  padding: 12px;
			  border: 1px solid #ccc;
			  border-radius: 4px;
			  box-sizing: border-box;
			  margin-top: 6px;
			  margin-bottom: 16px;
			  resize: vertical;
			}
			
			input[type=button] {
			  background-color: #04AA6D;
			  color: white;
			  padding: 12px 20px;
			  border: none;
			  border-radius: 4px;
			  cursor: pointer;
			}
			
			input[type=button]:hover {
			  background-color: #45a049;
			}
			
			.container {
			  border-radius: 5px;
			  background-color: #f2f2f2;
			  padding: 20px;
			}
		</style>
		<!-- 서머노트링크 -->
		<!-- CDN(Content delivery network -->
		<!-- include libraries(jQuery, bootstrap) -->
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
		<!-- 제이쿼리 추가돼있음 -->
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		
		<!-- include summernote css/js -->
		<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {// addEventListener("load", function(){});과 동일...
			 	$('#summernote').summernote();
			
			//버튼에 클릭이벤트 연결
				$('input[type="button"]').click(()=>{
					//직접 mysql연동이 불가능하므로, 웹 서버에 프로그램에게 부탁할거야(request)
					//입력 양식의 범위를 설정하는 태그인 form태그를 이용하여 입력양식을 서버에 전송하자.
					//http 프로토콜에서 서버에 데이터를 전송할 때는 POST방식을 사용해야 한다.
					$("form").submit();//전송이 발생
				});
			
			});
		</script>
		
	</head>
	<body>
	
		<h3>Contact Form</h3>
		
		<div class="container">
		<!-- 얘 뭐하는건지,, -->
		  <form method="post" action="/notice/write"><!-- 포스트 쓸거야,  루트폴더로.-->
		    <label for="fname">제목</label>
		    <input type="text" id="fname" name="title" value=<%= notice.getTitle() %>>
		
		    <label for="lname">작성자</label>
		    <input type="text" id="lname" name="writer" value=<%= notice.getWriter() %>>
		
			<!-- name은 중복허용, http내에서 파라미터로도 사용될 수 있음 -->
		    <label for="subject">내용</label>
		    <textarea id="summernote" name="content" value=<%= notice.getContent() %> style="height:200px"></textarea>
		
		    <input type="button" value="수정">
		    <input type="button" value="삭제">
		    <input type="button" value="목록">
		  </form>
		</div>
	
	</body>
</html>
