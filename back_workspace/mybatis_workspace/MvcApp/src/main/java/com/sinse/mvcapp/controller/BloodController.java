package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinse.mvcapp.blood.model.BloodManager;

// 혈액형에 대한 판단 요청을 처리하는 컨트롤러 정의
public class BloodController extends HttpServlet {
	BloodManager bloodManager = new BloodManager();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bloodType = request.getParameter("bloodType");
		String result = bloodManager.getAdvice(bloodType);
		HttpSession session = request.getSession();
		session.setAttribute("msg", result);
		response.sendRedirect("/blood/result.jsp");
	}
}
