package com.rueggerllc.test;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rueggerllc.beans.Bar;
import com.rueggerllc.beans.Foo;

// Test Various Spring functions
public class SpringTest1 {
	
	private static Logger logger = Logger.getLogger(SpringTest1.class);
	private static ApplicationContext context;

	@BeforeClass
	public static void setupClass()
	  throws Exception {
	  context = new ClassPathXmlApplicationContext("resource/applicationContext.xml");
	  logger.info("SETUP CLASS");
	}
	
	@AfterClass
	public static void tearDownClass()
	  throws Exception {
		logger.info("TEARDOWN CLASS");
	}
	
	@Before
	public  void setupTest()
	  throws Exception {
	}
	
	@After
	public void tearDownTest()
	  throws Exception {
	}
	
	



	@Test
	// @Ignore
	public void applicationContextTest() {
		try {
			Bar bar = (Bar)context.getBean("bar");
			Foo foo = bar.getFoo();
			logger.info("Foo name: " + foo.getName());
			logger.info("Foo age: " + foo.getAge());
			for (String admin : foo.getAdministrators()) {
				logger.info("Next Admin; " + admin);
			}
		} catch (Exception e) {
			System.out.println("ERROR:\n" + e);
		}
	  }
	
	
	@Test
	// @Ignore
	public void testDataSource() {
		
		try {
			DataSource dataSource = context.getBean("dataSource", DataSource.class);
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			String sql = "select * from account";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String accountName = rs.getString("name");
				logger.info("Got Account: " + accountName);
			}
			rs.close();
			statement.close();
			connection.close();
			
			
		} catch (Exception e) {
			System.out.println("ERROR:\n" + e);
		}
		finally {
			
		}
	  }

}
