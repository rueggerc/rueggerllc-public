package com.rueggerllc.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.rueggerllc.beans.Account;
import com.rueggerllc.daos.AccountDAO;
import com.rueggerllc.daos.AccountDAOImpl;

public class AccountDaoTest {
	
	private static Logger logger = Logger.getLogger(AccountDaoTest.class);
	
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
	// @Ignore
	public void dummyTest() {
		logger.info("Inside Dummy Test");
	}
	

	@Test
	// @Ignore
	public void testInsertAccounts() {
		try {
			AccountDAO accountDAO = new AccountDAOImpl();
			for (int i = 0; i < 100; i++) {
				Account account = new Account();
				account.setName(String.format("Account%d", i));
				account.setState("VA");
				account.setZip("20171");
				account.setCreateDate(getCurrentDate());
				account.setAddress(String.format("%d Main Street", i));
				logger.info("SAVING ACCOUNT");
				accountDAO.save(account);
			}
		} catch (Exception e) {
			logger.info("ERROR", e);
		}
	}
	
	
	@Test
	@Ignore
	public void testGetAllAccounts() throws Exception {
	    logger.info("TEST GET ALL ACCOUNTS DAO BEGIN");
	    try {
		    AccountDAO accountDAO = new AccountDAOImpl();
		    List<Account> accounts = accountDAO.findAll(Account.class);
		    logger.info("GOT ACCOUNTS:" + accounts.size());
		    for (Account account : accounts) {
		    	logger.info("Next Account=" + account.getId());
		    }
	    } catch (Exception e) {
	    	logger.error("ERROR", e);
	    } 
	}
	
	private Date getCurrentDate() {
		return Calendar.getInstance().getTime();
	}
	
	

}
