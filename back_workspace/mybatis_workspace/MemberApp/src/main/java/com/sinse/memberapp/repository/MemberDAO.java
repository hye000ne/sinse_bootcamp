package com.sinse.memberapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.memberapp.exception.MemberNotFoundException;
import com.sinse.memberapp.model.Member;
import com.sinse.memberapp.mybatis.MybatisConfig;


public class MemberDAO {
	MybatisConfig conf = MybatisConfig.getInstance();
	
	public List<Member> selectAll() {
		SqlSession sqlSession = conf.getSqlSession();
		List<Member> list = sqlSession.selectList("Member.selectAll");
		sqlSession.close();
		
		return list;
	}
	
	public Member login(Member member) {
		SqlSession sqlSession = conf.getSqlSession();
		Member loginMember = sqlSession.selectOne("Member.login", member);
		if(loginMember == null) {
			throw new MemberNotFoundException("해당 회원이 존재하지 않습니다.");
		}
		sqlSession.close();
		
		return loginMember;
	}
}
