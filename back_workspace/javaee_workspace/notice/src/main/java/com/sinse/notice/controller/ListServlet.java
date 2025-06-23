package com.sinse.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *서블릿은 서버측에서 수행되는 자바 클래스로서 아주 필수적인 기술이다.
 *치명적단점) 디자인표현시 어려움이있다 -> 직접 문자열로 처리해하는 불편함
 *
 *해결책) asp, php 처럼 html과 프로그램 코드를 함께 작성할 수 있는 jsp로 디자인을 표현한다.
 */
//게시물의 목록 요청을 처리하는 서블릿.
public class ListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("I just did");
	}
}
