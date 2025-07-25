package mvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcproject.notice.domain.Notice;
import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

public class DetailController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice notice = noticeDAO.select(Integer.parseInt(request.getParameter("notice_id")));
		request.setAttribute("notice", notice);
	}
	
	public boolean isForward() {
		return true;
	}
	
	public String getViewName() {
		return "/notice/detail/view";
	}
}
