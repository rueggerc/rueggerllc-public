package com.rueggerllc.mongodb.tests;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rueggerllc.mongodb.beans.BookBean;

public class JacksonTests {
	
	private static final Logger logger = Logger.getLogger(JacksonTests.class);
	
	@BeforeClass
	public static void setupClass() throws Exception {
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
	// @Ignore
	public void testObjectToJSON() {
		try {
			logger.info("Object to JSON Begin");
			BookBean book = new BookBean();
			book.setTitle("Foo and the Bars");
			book.setNumberOfPages(311);
			book.setPublishDate(getNow());
			logger.info("Book=\n" + book);
			
			ObjectMapper mapper = new ObjectMapper();
			String bookData = mapper.writeValueAsString(book);
			logger.info("BookData=\n" + bookData);
		
			
			
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	
	@Test
	// @Ignore
	public void testJSONToObject() {
		try {
			logger.info("JSON to Object Begin");
			
			ObjectMapper mapper = new ObjectMapper();
			String data = "{\"title\":\"Foo and the Bars\",\"numberOfPages\":311,\"publishDate\":1496876481364}";
			
			BookBean book = mapper.readValue(data, BookBean.class);
			logger.info("BookBean=\n" + book);
			
			
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	private Date getNow() {
		return Calendar.getInstance().getTime();
	}
	


	
}
