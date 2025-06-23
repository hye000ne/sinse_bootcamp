package com.sinse.web0618.member.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sinse.web0618.exception.MemberException;
import com.sinse.web0618.member.model.Member;

public class MemberDAO {
	// DB 접속시도는 절대로 DAO에서 시도하면 안됨
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/shop";
	String user = "shop";
	String pwd = "1234";
	
	// throws 목적: 
	public void insert(Member member) throws MemberException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			StringBuffer sql = new StringBuffer();
			sql.append("insert into member(id, pwd, email) values (?,?,?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getEmail());
			
			int result = pstmt.executeUpdate();
			
			if(result == 0) {
				throw new MemberException("회원가입 실패");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new MemberException("회원가입 실패" , e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MemberException("회원가입 실패", e);
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
