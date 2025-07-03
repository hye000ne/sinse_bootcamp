package com.sinse.boardapp.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	private static MybatisConfig instance;  
	private SqlSessionFactory sqlSessionFactory;
	
	private MybatisConfig() {
		String resource = "com/sinse/boardapp/mybatis/mybatis-config.xml"; // 설정 파일
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);// 설정 파일을 스트림으로 로드
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MybatisConfig getInstance() {
		if(instance == null) instance = new MybatisConfig();

		return instance;
	}
	
	// 실제 DB 작업을 수행하는 SqlSession 객체 반환 (Connection, PreparedStatement, ResultSet 관리 추상화)
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
