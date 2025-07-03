package com.sinse.boardapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.boardapp.exception.CommentException;
import com.sinse.boardapp.model.Comment;
import com.sinse.boardapp.mybatis.MybatisConfig;

public class CommentDAO {
	MybatisConfig config = MybatisConfig.getInstance();
	
	//모든 레코드 가져오기
	public List<Comment> seletAll() {
		return null;
	}
	
	//모든 레코드 가져오기
	public List<Comment> seletByNewsId(int news_id) {
		SqlSession sqlSession = config.getSqlSession();
		List<Comment> list = sqlSession.selectList("Comment.selectByNewsId", news_id);
		sqlSession.close();
				
		return list;
	}
	
	//한건 가져오기
	public Comment select(int comment_id) {
		return null;
	}
	
	//한건 넣기
	public void insert(Comment comment) {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.insert("Comment.insert", comment);
		if(result < 1) throw new CommentException("등록 실패");
		sqlSession.commit();
		sqlSession.close();
	}
	
	//한건 수정
	public void update(Comment comment) {
		
	}
	
	//한건 삭제
	public void delete(int comment_id) {
		
	}
}
