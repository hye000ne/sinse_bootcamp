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

public class UpdateServlet extends HttpServlet {
	NoticeDAO dao;

	public UpdateServlet() {
		dao = new NoticeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 파라미터 인코딩
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		Notice notice = new Notice();
		String notice_id = request.getParameter("notice_id");
		notice.setNotice_id(Integer.parseInt(notice_id));
		notice.setTitle(request.getParameter("title"));
		notice.setWriter(request.getParameter("writer"));
		notice.setContent(request.getParameter("content"));
		try {
			dao.update(notice);
			out.print("<script>");
			out.print("	alert('수정 성공');");
			out.print(" location.href='/notice/content.jsp?notice_id="+notice_id+"';"); //목록 페이지를 재요청
			out.print("</script>");
		} catch (NoticeException e) {
			out.print("<script>");
			out.print("	alert("+e.getMessage()+");");
			out.print("</script>");
			e.printStackTrace();
		}
	}
}
