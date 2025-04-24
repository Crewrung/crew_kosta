package com.crewrung.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBCP {

	private static SqlSessionFactory sqlSessionFactory;
	
	private DBCP(){
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream inputStream = null;

			try {
				String resource = "config/mybatis-Config.xml";
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}

			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		}
		return sqlSessionFactory;
	
	}
}

