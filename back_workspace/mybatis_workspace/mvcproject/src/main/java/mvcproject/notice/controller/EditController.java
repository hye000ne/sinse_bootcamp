package mvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcproject.notice.domain.Notice;
import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

public class EditController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice notice = new Notice();
		notice.setNotice_id(Integer.parseInt(request.getParameter("notice_id")));
		notice.setTitle(request.getParameter("title"));
		notice.setWriter(request.getParameter("writer"));
		notice.setContent(request.getParameter("content"));
		noticeDAO.update(notice);
	}
	
	public boolean isForward() {
		return true;
	}
	
	public String getViewName() {
		return "/notice/update/view";
	}
}
