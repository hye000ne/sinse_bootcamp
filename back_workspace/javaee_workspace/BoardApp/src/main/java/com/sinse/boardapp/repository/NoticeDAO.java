package com.sinse.boardapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.boardapp.model.Notice;
import com.sinse.boardapp.pool.PoolManager;


public class NoticeDAO {
	PoolManager poolManager = PoolManager.getInstance();
	
	public List selectAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = poolManager.getConnection();
			String sql = "select * from notice order by notice_id desc";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			List<Notice> list = new ArrayList<>();
			while(rs.next()) {
				Notice notice = new Notice();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setRegDate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				
				list.add(notice);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoticeException(e.getMessage());
		} finally {
			poolManager.release(con, pstmt, rs);
		}
	}
	
	public Notice select(int noticeId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Notice notice = new Notice();
			con = poolManager.getConnection();
			String sql = "select * from notice where notice_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noticeId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setRegDate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
			}
			
			return notice;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoticeException(e.getMessage());
		}
	}
	
	public void insert(Notice notice) throws NoticeException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = poolManager.getConnection();
			String sql = "insert into notice(title, writer, content) values (?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getWriter());
			pstmt.setString(3, notice.getContent());
			
			int result = pstmt.executeUpdate();
			
			if(result < 1) {
				throw new NoticeException("글 등록 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			poolManager.release(con, pstmt);
		}
	}
	
	public void uspdate() {
		
	}
	
	public void delete() {
		
	}
	
}
