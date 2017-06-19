package com.rueggerllc.mybatis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MybatisContext {
	
	private static SqlSessionFactory factory;
	private static Logger logger = Logger.getLogger(MybatisContext.class);
	
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			logger.error("Error:", e);
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
