package com.rueggerllc.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rueggerllc.jdbc.JdbcAccountRepository;
import com.rueggerllc.jdbc.domain.Account;

@ContextConfiguration("/resource/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JDBCTest {
	
	private static Logger logger = Logger.getLogger(JDBCTest.class);
	
	@Autowired
	JdbcAccountRepository jdbcAccountRepository;
	
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
	@Ignore
	public void testGetNumberOfAccounts() {
		try {
			int numberOfAccounts = this.jdbcAccountRepository.getNumberOfAccounts();
			logger.info("Number of Accounts=" + numberOfAccounts);
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}
	
	@Test
	@Ignore
	public void testNumberOfHighStatusAccounts() {
		try {
			int numberOfAccounts = this.jdbcAccountRepository.getHighStatusAccounts(102);
			logger.info("Number of High Status Accounts=" + numberOfAccounts);
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}

	
	@Test
	@Ignore
	public void testGetSingleAccount() {
		try {
			Map<String,Object> accountData = this.jdbcAccountRepository.getAccount(6);
			assertNotNull(accountData);
			this.displayAccountData(accountData);
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}
	
	@Test
	@Ignore
	public void testGetAccounts() {
		try {
			List<Map> accounts = this.jdbcAccountRepository.getAccounts();
			assertTrue(accounts.size() >= 1);
			for (Map accountData : accounts) {
				this.displayAccountData(accountData);
			}
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}
	
	@Test
	@Ignore
	public void testGetAccountObject() {
		try {
			Account account = this.jdbcAccountRepository.getAccountObject(6);
			logger.info("Got Account:\n" + account);
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}
	
	@Test
	@Ignore
	public void testGetAccountObjects() {
		try {
		    List<Account> accounts = this.jdbcAccountRepository.getAccountObjects();
			logger.info("Got Account: " + accounts.size());
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}
	
	@Test
	@Transactional
	// A transaction manager bean must be configured for this to work
	// Transaction will be rolled back automatically when test completes
	// @Ignore
	public void testInsertAccount() throws DataAccessException {
		int numberOfAccountsBegin = this.jdbcAccountRepository.getNumberOfAccounts();
		logger.info("Number of Accounts Before=" + numberOfAccountsBegin);
		Account account = new Account();
		account.setName("New Account");
		account.setAddress("80 Ralph Ave");
		account.setState("New Jersey");
		account.setZip("07642");
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		account.setCreateDate(now);
		account.setStatus(200);
		int numberOfRows = this.jdbcAccountRepository.insertAccount(account);
		logger.info("NumberOfRows=" + numberOfRows);
			
		// Verify that new account has been created
		int numberOfAccountsEnd = this.jdbcAccountRepository.getNumberOfAccounts();
		logger.info("Number of Accounts After=" + numberOfAccountsEnd);
		assertEquals(numberOfAccountsEnd,numberOfAccountsBegin+1);
			
	}
	
	@Test
	@Transactional
	// @Ignore
	public void testUpdateAccount() {
		try {
			Account account = this.jdbcAccountRepository.getAccountObject(6);
			account.setName("Updated Account Name");
			account.setStatus(400);
			int numberAffected = this.jdbcAccountRepository.updateAccount(account);
			
			account = this.jdbcAccountRepository.getAccountObject(6);
			assertEquals(account.getName(),"Updated Account Name");
			
			
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}
	
	private void displayAccountData(Map<String,Object> data) {
		for (String key : data.keySet()) {
			Object value = data.get(key);
			logger.info(key + " = " + value);
		}		
	}



}
