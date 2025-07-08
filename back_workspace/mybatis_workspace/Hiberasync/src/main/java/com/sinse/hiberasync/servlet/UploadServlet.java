package com.sinse.hiberasync.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	String uploadPath;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		uploadPath = config.getServletContext().getRealPath(config.getInitParameter("uploadPath"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("저장할 실제 경로는 " + uploadPath);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		
		// 클라이언트의 요청을 분석(파싱)
		try {
			List<FileItem> list = servletFileUpload.parseRequest(request);
			logger.debug("전송된 컴포넌트의 수는 " + list.size());
			
			for(FileItem fileItem : list) { // <input type="text">, <input type="file">
				if(fileItem.isFormField()) {
					logger.debug(fileItem.getString("utf-8"));
				} else {
					logger.debug("파일명은 : " + fileItem.getName());
					logger.debug("파일크기는 : " + fileItem.getSize());
					// 실제 파일 저장
					fileItem.write(new File(uploadPath, fileItem.getName()));
					HttpSession session = request.getSession();
					session.setAttribute("img", fileItem.getName());
					
				}
			}
			
			response.sendRedirect("/gallery/result.jsp");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
