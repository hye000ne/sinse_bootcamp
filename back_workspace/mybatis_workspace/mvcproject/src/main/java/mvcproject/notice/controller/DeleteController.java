package mvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

public class DeleteController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		noticeDAO.delete(Integer.parseInt(request.getParameter("notice_id")));
	}
	
	public boolean isForward() {
		return false;
	}
	
	public String getViewName() {
		return "/notice/delete/view";
	}
}