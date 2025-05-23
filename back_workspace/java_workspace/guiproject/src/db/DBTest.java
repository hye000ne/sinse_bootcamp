/*
MySQL 연동해보자
*/
package db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBTest{
	public static void main(String[] args){
		//제어하기를 원하는 드라이버(구현한 구현체) 먼저 로드(method 영역)
		Connection conn = null;
		PreparedStatement pstmt = null;
		String mysqlDriver = "com.mysql.cj.jdbc.Driver";
		String oracleDriver = "oracle.jdbc.driver.OracleDriver";
		
		String mysqlUrl = "jdbc:mysql://localhost:3306/dev";
		String mysqlId = "root";
		String mysqlPass = "1234";
		
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String oracleId = "java";
		String oraclePass = "1234";
		
		try{
			//1단계) 드라이버 로드
			Class.forName(oracleDriver);		//("원하는 드라이버 클래스 명시");
			System.out.println("드라이버 로드 성공");
			
			//2단계) 접속	
			String url = oracleUrl;
			String id = oracleId;
			String pass = oraclePass;
			
			//Connection이란? 접속 성공 후, 그 접속 정보를 가진 인터페이스
			//이 객체가 null이면 접속 실패
			conn = DriverManager.getConnection(url, id, pass);
			if(conn == null) {
				System.out.println("접속 실패");
			} else {
				System.out.println("성공");
				
				//접속이 성공된 이후, 원격지 DB 서버에 SQL문을 네트워크를 통해 전송
				//String sql = "insert into member3(uid, pwd, email) values('scott','3333','sss@daum.net')";	//mysql
				String sql = "insert into member3(member3_id, id, pwd, email)";
				sql += " values(seq_member3.nextval,'james','3333','jjj@gmail.com')"; 
				
				//JDBC(Java DataBase Connectivity) : 자바의 데이터베이스 연동 기술 및 지원 패키지(java.sql 패키지)
				//JDBC에서 쿼리문 수행을 담당하는 인터페이스는 PreparedStatement
				
				//접속이 성공된 이후에 쿼리문 수행이 가능하므로, pstmt 객체의 인스턴스는 Connection 인터페이스로부터 얻어야 함
				pstmt = conn.prepareStatement(sql);
				//준비된 문장으로 쿼리실행
				int result = pstmt.executeUpdate();	//DML 수행시 이 메서드 사용
				if(result > 0) {
					System.out.println("등록 성공");
				} else{
					System.out.println("등록 실패");	
				}
			}
		}catch(ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다.");
		}catch(SQLException e){
			e.printStackTrace();	//에러 순서를 스택 순서로 출력
		}finally{
			/* DB와 스트림과 같은 자원을 차지하는 기술은 사용 후 반드시 닫아야함	
			   안닫으면 메모리를 계속 확보하고 있음
			   만일 웹서버에 이러한 닫지 않은 코드가 올라간다면 동시 자원이 다수 생성
			*/
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException e){
				e.printStackTrace();	
				}
			}
			
		
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
}
