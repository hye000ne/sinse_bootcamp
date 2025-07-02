package com.sinse.boardapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.boardapp.repository.NoticeDAO;

public class DeleteServlet extends HttpServlet {
	NoticeDAO noticeDAO;
	
	public DeleteServlet() {
		noticeDAO = new NoticeDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			noticeDAO.delete(Integer.parseInt(request.getParameter("notice_id")));
			out.print("<script>");
			out.print("alert('등록성공');");
			out.print("location.href='/notice/list.jsp';");
			out.print("</script>");
		} catch (NoticeException e) {
			out.print("<script>");
			out.print("alert('"+e.getMessage()+"');");
			out.print("history.back();");
			out.print("</script>");
			e.printStackTrace();
		}
	}
}
