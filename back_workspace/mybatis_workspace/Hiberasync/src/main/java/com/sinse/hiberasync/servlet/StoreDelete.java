package com.sinse.hiberasync.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.sinse.hiberasync.exception.StoreException;
import com.sinse.hiberasync.repository.StoreDAO;
import com.sinse.hiberasync.util.Message;

public class StoreDelete extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO = new StoreDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeId = request.getParameter("storeId");
		
		logger.debug("storeId: " + storeId);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Message message = new Message();
		Gson gson = new Gson();
		try {
			storeDAO.delete(Integer.parseInt(storeId));
			message.setResult("success");
			message.setMsg("삭제 성공");
			response.setStatus(HttpServletResponse.SC_CREATED); // 201
		} catch (StoreException e) {
			e.printStackTrace();
			message.setResult("fail");
			message.setMsg(e.getMessage());
		}
		out.print(gson.toJson(message));
	}
}
