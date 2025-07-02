package com.sinse.boardapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.boardapp.model.Notice;
import com.sinse.boardapp.mybatis.MybatisConfig;

public class NoticeDAO {
	MybatisConfig config = MybatisConfig.getInstance(); 
	
	public List<Notice> selectAll() {
		SqlSession sqlSession = config.getSqlSession();
		List<Notice> list = sqlSession.selectList("Notice.selectAll");
		sqlSession.close();
		return list;
	}
	
	public Notice select(int noticeId) {
		SqlSession sqlSession = config.getSqlSession();
		Notice notice = sqlSession.selectOne("Notice.select", noticeId);
		sqlSession.close();
		return notice;
	}
	
	public void insert(Notice notice) throws NoticeException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.insert("Notice.insert", notice);
		sqlSession.commit();
		sqlSession.close();
		if(result < 1) throw new NoticeException("등록 실패");
	}
	
	public void update(Notice notice) throws NoticeException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.update("Notice.update", notice);
		sqlSession.commit();
		sqlSession.close();
		if(result < 1) throw new NoticeException("수정 실패");
	}
	
	public void delete(int noticeId) throws NoticeException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.delete("Notice.delete", noticeId);
		sqlSession.commit();
		sqlSession.close();
		if(result < 1) throw new NoticeException("삭제 실패");
	}
}
