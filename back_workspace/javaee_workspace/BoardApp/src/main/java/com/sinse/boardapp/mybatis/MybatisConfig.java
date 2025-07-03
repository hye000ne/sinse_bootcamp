package com.sinse.boardapp.mybatis;

import java.io.InputStream;

import javax.annotation.Resources;

public class MybatisConfig {
	SqlSessionFactory sqlSessionFactory;
	
	public MybatisConfig() {
		String resource = "com/sinse/boardapp/mybatis/mybatis-config.xml";
		InputStream inputStream; 
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public SqlSession getSqlSession() {
		return null;
	}
}
