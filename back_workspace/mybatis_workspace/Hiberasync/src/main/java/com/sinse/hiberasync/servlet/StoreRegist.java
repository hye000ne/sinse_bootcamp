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

public class StoreRegist extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO = new StoreDAO();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//필터가 제대로 동작한다면, 따로 인코딩 작업 안해줘도 됨
		String foodTypeSel = request.getParameter("foodTypeSel"); // select 유형 value 값
		String storeName = request.getParameter("storeName");
		String tel = request.getParameter("tel");
		
		logger.debug("foodTypeSel : " + foodTypeSel);
		logger.debug("storeName : " + storeName);
		logger.debug("tel : " + tel);
		
		Store store = new Store();
		FoodType foodType = new FoodType();
		foodType.setFood_type_id(Integer.parseInt(foodTypeSel));
		
		store.setStore_name(storeName);
		store.setTel(tel);
		store.setFoodType(foodType);//부모 객체 주입

		// 응답 정보를 html이 아닌 json으로 생성하여 보내자
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Message message = new Message(); 
		Gson gson = new Gson();
		// 등록
		try {
			storeDAO.insert(store);
			// 200, 500 HTTP Status 코드: 서버가 클라이언트에게 응답 시 보내는 코드 (성공/실패)
			// IETF(Internet Engineering Task Force) - 인터넷 표준 프로토콜을 정의하는 국제 조직이 정함
			response.setStatus(HttpServletResponse.SC_CREATED); // 201
		} catch (StoreException e) {
			e.printStackTrace();
			message.setResult("fail");
			message.setMsg(e.getMessage());
			out.print(gson.toJson(message));
		}
	}
}
