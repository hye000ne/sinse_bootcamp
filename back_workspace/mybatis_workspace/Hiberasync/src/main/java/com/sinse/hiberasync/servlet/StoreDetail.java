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
import com.sinse.hiberasync.model.Store;
import com.sinse.hiberasync.repository.StoreDAO;
import com.sinse.hiberasync.util.Message;

public class StoreDetail extends HttpServlet {
	StoreDAO storeDAO = new StoreDAO();
	Logger logger = LoggerFactory.getLogger(getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String store_id = request.getParameter("store_id");
		logger.debug("store_id: "+store_id);
		
		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		Message message = new Message();
		
		try {
			Store store = storeDAO.selectById(Integer.parseInt(store_id));
			out.print(gson.toJson(store)); // 클라이언트에게 받을 json 문자열 스트림에 넣기
		} catch (StoreException e) {
			e.printStackTrace();
			message.setResult("fail");
			message.setMsg(e.getMessage());
			out.print(gson.toJson(message));
		}
		
	}
}
