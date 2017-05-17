package com.rueggerllc.test;


import java.util.HashMap;
import java.util.Map;

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

import com.rueggerllc.aop.Server;
import com.rueggerllc.aop.access.AccountAccess;
import com.rueggerllc.aop.biz.BizDao;
import com.rueggerllc.aop.biz.BizDelegate;

@ContextConfiguration("/resource/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {
	
	private static Logger logger = Logger.getLogger(AopTest.class);

	@Autowired
	BizDelegate delegate;

	@Autowired
	BizDao dao;

	@Autowired
	AccountAccess accountAccess;
	
	@Autowired
	Server server;

	
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
	public void testBizDelegate() {
		try {
			delegate.method1("Hello to Method1");
			delegate.method2("Hello to Method2");
		} catch (Exception e) {
			logger.error("ERROR:\n" + e);
		}
	}
	
	@Test
	// @Ignore
	public void testBizDao() {
		try {
			dao.execute("Insert into Accounts...");
			logger.info("-------dao.execute() called---------");
			dao.executeWithReward();
		} catch (Exception e) {
			logger.error("ERROR:\n" + e);
		}
	}
	
	@Test
	// @Ignore
	public void testAccountAccess() {
		try {
			accountAccess.getAccounts();
		} catch (Exception e) {
			logger.info("Exception caught, ignoring");
		}
	}
	
	@Test
	// @Ignore
	public void testServerStartup() {
		try {
			Map input = new HashMap();
			server.start(input);
		} catch (Exception e) {
			logger.error("ERROR:\n" + e);
		}
	}
	

}
