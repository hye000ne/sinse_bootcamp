package com.sinse.memberapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinse.memberapp.exception.MemberNotFoundException;
import com.sinse.memberapp.model.Member;
import com.sinse.memberapp.repository.MemberDAO;

public class LoginServlet extends HttpServlet {
	MemberDAO memberDAO = new MemberDAO();
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd"); 

		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		
		Member loginMember=null;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		try {
			loginMember = memberDAO.login(member);
			//로그인 성공 시, 세션 객체에 저장 / 이 코드는 서블릿이라 개발자가 자료형으로 제어
			HttpSession session = request.getSession();
			session.setAttribute("member", loginMember);
			
			out.print("alert('"+loginMember.getName()+"님 안녕하세요!');");
			out.print("location.href='/index.jsp';");
		} catch (MemberNotFoundException e) {
			out.print("alert('"+e.getMessage()+"');");
			out.print("history.back();");
			
			e.printStackTrace();
		}
		out.print("</script>");
	}
}
