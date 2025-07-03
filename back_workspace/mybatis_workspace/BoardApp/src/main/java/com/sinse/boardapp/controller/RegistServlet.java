package com.sinse.boardapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.boardapp.model.Notice;
import com.sinse.boardapp.repository.NoticeDAO;

public class RegistServlet extends HttpServlet {
	NoticeDAO dao;

	public RegistServlet() {
		dao = new NoticeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 파라미터 인코딩
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		System.out.println(title + ", " + writer + ", " + content);

		Notice notice = new Notice();

		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);

		try {
			dao.insert(notice);
			out.print("<script>");
			out.print("	alert('등록성공');");
			out.print(" location.href='/notice/list.jsp';"); //목록 페이지를 재요청
			out.print("</script>");
		} catch (NoticeException e) {
			out.print("<script>");
			out.print("	alert("+e.getMessage()+");");
			out.print("</script>");
			e.printStackTrace();
		}
	}
}
