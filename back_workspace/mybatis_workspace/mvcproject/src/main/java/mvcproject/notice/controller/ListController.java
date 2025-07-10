package mvcproject.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

public class ListController implements Controller {
	NoticeDAO noticeDAO = new NoticeDAO();
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List noticeList = noticeDAO.selectAll();
		request.setAttribute("noticeList", noticeList);
	}
	
	public boolean isForward() {
		return true;
	}
	
	public String getViewName() {
		return "/notice/list/view";
	}
}
