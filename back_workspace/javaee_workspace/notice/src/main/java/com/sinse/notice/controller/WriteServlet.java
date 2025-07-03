package com.sinse.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트의 글쓰기 요청을 처리하는 서버측의 서블릿 정의
public class WriteServlet extends HttpServlet{
	
	@Override
	//클라이언트의 요청방식에 따라dpXXX()방식이 달라진다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청받기
		//전송된 데이터에 대한 언어 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//클라이언트(브라우저)에게 응답하는 HTML 문서가 UTF-8로 인코딩되어 있다고 알려주는 역할입니다.
		response.setContentType("text/html;charset=UTF-8");

		//text/html과 같은 파일의 종류, 유형을 가리켜 마입타입(MIMEType)이라고한다
		//application/json; text/xml, image/jpeg
		
		String title = request.getParameter("title");//제목
		String writer = request.getParameter("writer");//글쓴이
		String content = request.getParameter("content");//내용
		
		System.out.println("title = "+ title);
		System.out.println("writer = "+ writer);
		System.out.println("content =" + content);
		
		PrintWriter out = response.getWriter();
		
		
		//DB연결
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "shop", "1234"); 
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert  into notice(title, writer, content) values(?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			
			
			//응답 정보만 만듦.(실질적인 응답은 톰캣서버가 담당)
			int result = pstmt.executeUpdate();//DML 수행
			if (result>0) {				
				
				out.print("<!DOCTYPE html>");
				out.print("<html>");
				out.print("<head>");
				out.print("<meta charset=\"UTF-8\">");
				out.print("<script>");
				out.print("alert('고양이가 보냈습니다, 이건 새창에서 보내는 알러트입니다.');");
				out.print("location.href='/notice/list';");				
				out.print("</script>");
				out.print("</head>");
				out.print("</html>");
				
			}else {
				out.print("<script>");
				out.print("alert('고양이가 못보냈습니다~');");
				out.print("history.back();");//브라우저의 뒤로가기 버튼과 동일		
				out.print("</script>");
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
