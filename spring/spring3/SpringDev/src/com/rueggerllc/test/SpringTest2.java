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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rueggerllc.beans.Bar;
import com.rueggerllc.beans.Foo;

@ContextConfiguration("/resource/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest2 {
	
	private static Logger logger = Logger.getLogger(SpringTest2.class);

	@Autowired
	Bar bar;
	
	@Autowired
	DataSource dataSource;

	@BeforeClass
	public static void setupClass()
	  throws Exception {
	}
	
	@AfterClass
	public static void tearDownClass()
	  throws Exception {
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
	  }	

}
