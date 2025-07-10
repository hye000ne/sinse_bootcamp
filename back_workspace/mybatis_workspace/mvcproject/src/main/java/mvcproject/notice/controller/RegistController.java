package mvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcproject.notice.domain.Notice;
import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

public class RegistController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice notice = new Notice();
		notice.setTitle(request.getParameter("title"));
		notice.setWriter(request.getParameter("writer"));
		notice.setContent(request.getParameter("content"));
		
		noticeDAO.insert(notice);
	}
	
	public boolean isForward() {
		return false; // 포워딩 말고 브라우저로 하여금 새로 들어오게 함
	}
	
	public String getViewName() {
		return "/notice/regist/view";
	}
}
