package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinse.mvcapp.blood.model.BloodManager;
import com.sinse.mvcapp.color.model.ColorManager;

public class DispatcherServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getRequestURI().equals("/blood.do")) {
			String blood = req.getParameter("bloodType");
			BloodManager manager = new BloodManager();
			String result = manager.getAdvice(blood);
			
			HttpSession session = req.getSession();
			session.setAttribute("msg", result);
			resp.sendRedirect("/blood/result.jsp");
		} else if(req.getRequestURI().equals("/color.do")) {
			String color = req.getParameter("color");
			ColorManager manager = new ColorManager();
			String result = manager.getAdvice(color);
			
			HttpSession session = req.getSession();
			session.setAttribute("msg", result);
			resp.sendRedirect("/color/result.jsp");
		}
	}
}
