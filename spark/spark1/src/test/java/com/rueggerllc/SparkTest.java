package com.rueggerllc;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class SparkTest {

	private static Logger logger = Logger.getLogger(SparkTest.class);
	
	
	
	@BeforeClass
	public static void setupClass() throws Exception {
		System.setProperty("hadoop.home.dir", "C:/hadoop-2.7.4");
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setupTest() throws Exception {
	}

	@After
	public void tearDownTest() throws Exception {
	}
	
	@Test
	@Ignore
	public void dummyTest() {
		logger.info("Inside Dummy Test");
	}
	
	@Test
	public void testWordCounter() {
		try {
			logger.info("WordCounter BEGIN");
			WordCounter wordCounter = new WordCounter();
			wordCounter.execute();
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
}
