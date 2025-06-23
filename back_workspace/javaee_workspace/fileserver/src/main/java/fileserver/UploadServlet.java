package fileserver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UploadServlet extends HttpServlet {
	// 클라이언트의 요청이 Post방식이므로, doXXX형 중 doPost() 재정의해야함
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("post 요청 받음");

		int maxLimit = 1*1024*1024; //1M
		// 파일 업로드 컴포넌트 중 cos.jar 써보자
		MultipartRequest multi = new MultipartRequest(req, "C:\\lecture_workspace\\back_workspace\\javaee_workspace\\fileserver\\src\\main\\webapp\\data", maxLimit,"utf-8");
	}

	
}