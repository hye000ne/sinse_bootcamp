package imagecloud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

// 클라이언트가 전송한 텍스트 데이터, 바이너리 데이터까지 처리해보기
public class UploadServlet extends HttpServlet {
	String savePath = "C:/lecture_workspace/back_workspace/javaee_workspace/imagecloud/src/main/webapp/public"; //바이너리 파일이 저장될 서버의 경로
	int maxLimit = 3*1024*1024;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");	
		resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
		// 업로드 처리
		try {
			MultipartRequest multi = new MultipartRequest(req, savePath, maxLimit, "utf-8");
			System.out.println("업로드 성공");
			// 텍스트 파라미터 추출
			String title = multi.getParameter("title");
			System.out.println("전송된 제목은 " + title);
			out.print("전송된 제목은 " + title);
			// 1) 이미 서버에 저장되어버린, 이미지를 개발자가 원하는 이미지로 교체
			// 2) 클라이언트 측에서 파일명을 결정짓고 업로드하면 이과정은 불필요

			// 순서없는 컬렉션 객체를 처리할 때 사용되는 도구가 2가지 유형이 있다.(Enumeration, Iterator)
			Enumeration en =  multi.getFileNames();
			while(en.hasMoreElements()){
				String param = (String)en.nextElement();
//				out.println("업로드 된 파라미터명은 " + param);
				
				String filename = multi.getOriginalFileName(param);
				out.println("업로드 된 파일 명은 " + filename);
				
			}
			
			
			
		} catch (IOException e) {
			System.out.println("업로드 실패, 용량 등을 확인하세요.");
			e.printStackTrace();
		}
		
	}

}
