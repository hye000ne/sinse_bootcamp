package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinse.mvcapp.color.model.ColorManager;

/**
 * MVC 패턴에 의해 디자인과 로직을 분리시키려면, 중간에 중재가 나서야 하므로, 코드에서 분리
 * 컨트롤러의 5대 업무
 * 1) 요청을 받는다.
 * 2) 요청을 분석한다.
 * 3) 알맞는 로직객체(모델)에 일시킴
 * 4) 결과에 보여질 데이터 보관
 * 5) 알맞는 결과를 보여준다.
 */
public class ColorController extends HttpServlet {
	ColorManager manager = new ColorManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("color");
		String result = manager.getAdvice(color);
		
		HttpSession session = request.getSession();
		session.setAttribute("msg", result);
		
		// 지정된 url로 다시 요청을 시도. 즉, 톰캣이 응답정보를 이용하여 응답 컨텐츠를 보내고 나서 클라이언트가 다시 접속할 주소
		response.sendRedirect("/color/result.jsp");
	}
}
