package com.sinse.memberapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.memberapp.model.Dept;
import com.sinse.memberapp.mybatis.MybatisConfig;

public class DeptDAO {
	MybatisConfig conf = MybatisConfig.getInstance();
	
	public List<Dept> selectAll() {
		SqlSession sqlSession = conf.getSqlSession();
		List<Dept> list = sqlSession.selectList("Dept.selectAll");
		sqlSession.close();
		
		return list;
	}
}
