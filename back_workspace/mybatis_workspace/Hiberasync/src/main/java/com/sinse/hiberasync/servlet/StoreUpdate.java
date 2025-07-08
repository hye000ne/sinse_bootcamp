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
import com.sinse.hiberasync.model.FoodType;
import com.sinse.hiberasync.model.Store;
import com.sinse.hiberasync.repository.StoreDAO;
import com.sinse.hiberasync.util.Message;

public class StoreUpdate extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO = new StoreDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeId = request.getParameter("storeId");
		String foodTypeId = request.getParameter("foodTypeSel");
		String storeName = request.getParameter("storeName");
		String tel = request.getParameter("tel");
		
		logger.debug("storeId: " + storeId);
		logger.debug("foodTypeId: " + foodTypeId);
		logger.debug("storeName: " + storeName);
		logger.debug("tel: " + tel);
		
		Store store = new Store();
		FoodType foodType = new FoodType();
		foodType.setFood_type_id(Integer.parseInt(foodTypeId));

		store.setStore_id(Integer.parseInt(storeId));
		store.setStore_name(storeName);
		store.setTel(tel);
		store.setFoodType(foodType);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Message message = new Message();
		Gson gson = new Gson();
		
		try {
			storeDAO.update(store);
			message.setResult("success");
			message.setMsg("수정 성공");
			response.setStatus(HttpServletResponse.SC_CREATED); // 201
		} catch (StoreException e) {
			e.printStackTrace();
			message.setResult("fail");
			message.setMsg(e.getMessage());
		}
		out.print(gson.toJson(message));
	}
}
