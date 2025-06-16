package com.sinse.mysite.test;

// java의 클래스를 이용하여, 나의 이름을 웹브라우저에 출력해보자
// 자바의 클래스 중 오직 java EE 기반의 서버에서만 해석 및 실행될 수 있는 클래스를 서블릿이라고 한다.
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class MyName extends HttpServlet{
	// 부모인 서블릿의 doGet을 오버라이드하자
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 웹브라우저에 보여질 html 문서를 작성해본다

		PrintWriter out = response.getWriter(); // 응답정보를 출력할 스트림 얻기
		out.print("this is my first app!");
	}
}

