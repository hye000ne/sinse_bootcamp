package com.sinse.ioproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleTest {
	public static void main(String[] args) {
		/*
		 * 1. 오라클에 접속하기 1) java 언어가 DB를 핸들링하기 위해서는 db를 제작한 벤더사에서 제공하는 구현체인 드라이버를 먼저 메모리에
		 * 로드해야한다. 단, 주의 일반클래스처럼 new 할 수 없고 method 영역에 개발자가 직접 올려야한다.
		 */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");

			// 2. 원격지의 오라클 접속
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "java", "1234");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
