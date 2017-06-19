package com.rueggerllc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Timestamp;
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

import com.rueggerllc.dao.BankAccountDao;
import com.rueggerllc.dao.BankAccountDaoImpl;
import com.rueggerllc.domain.BankAccount;

public class DaoTest {
	
	private static Logger logger = Logger.getLogger(DaoTest.class);
	private static BankAccountDao dao = new BankAccountDaoImpl();

	@BeforeClass
	public static void setupClass() throws Exception {
		logger.info("SETUP CLASS");
	}
     
	@AfterClass
	public static void tearDownClass() throws Exception {
		logger.info("TEARDOWN CLASS");
	}
     
	@Before
	public  void setupTest() throws Exception {
	}
     
	@After
	public void tearDownTest() throws Exception {
	}
	
	@Ignore
	@Test
	public void dummyTest() {
		logger.info("Hello From Dummy Test");
	}
	
	
	 
	 // @Ignore
	 @Test
	 public void selectAllTest() throws Exception {
		 logger.info("Retrieve Bank Accounts BEGIN");
		 List<BankAccount> accounts = dao.selectAll();
		 for (BankAccount account : accounts) {
			 logger.info("Next Account=\n" + account);
		 }
		 logger.info("Size Of Accounts=" + accounts.size());
	 }
	 
	 
	 @Ignore
	 @Test
	 public void selectByIdTest() throws Exception {
		 logger.info("Retrieve Single Bank Account BEGIN");
		 BankAccount account = dao.selectById(42);
		 logger.info("Account=" + account);
	 }
	 
	 
	 @Ignore
	 @Test
	 public void insertTest() throws Exception {
		 logger.info("Inserting Bank Account");
		 BankAccount account = new BankAccount();
		 account.setName("Bank of America");
		 account.setAddress("San Diego Street");
		 account.setState("California");
		 account.setZip("90210");
		 account.setCreateDate(getNow());
		 account.setStatus(414);
		 dao.insert(account);
		 logger.info("Bank Account Insert=" + account.getId());
	 }
	 
	 
	 @Ignore
	 @Test
	 public void updateTest() throws Exception {
		 logger.info("Updating Bank Account");
		 BankAccount account = dao.selectById(103);
		 account.setName("Updated Name");
		 account.setAddress("Update Address");
		 account.setState("Update State");
		 account.setZip("Update Zip");
		 account.setCreateDate(getNow());
		 account.setStatus(388);
		 dao.update(account);
		 logger.info("BankAccount Updated");
	 }
	 
	 
	 @Ignore
	 @Test
	 public void deleteTest() throws Exception {
		 logger.info("Deleting Bank Account");
		 List<BankAccount> accounts = getAllAccounts();
		 int numberOfAccounts = accounts.size();
		 logger.info("Number Of Accounts=" + numberOfAccounts);
		
		 // Add Account
		 BankAccount account = createAccount();
		 insertAccount(account);
		 int newAccountId = account.getId();
		 logger.info("New Account Id=" + newAccountId);
		 
		 // Verify Account Inserted
		 accounts = getAllAccounts();
		 int numberOfAccountsAfterInsert = accounts.size();
		 logger.info("Number Of Accounts AfterInsert=" + numberOfAccountsAfterInsert);
		 assertEquals(numberOfAccounts+1, numberOfAccountsAfterInsert);
		 
		 // Delete Account
		 dao.delete(account.getId());
		
		 account = getAccount(newAccountId);
		 assertNull(account);
		 logger.info("Account Deleted");
	 }
	 
	 
	 
	 
	 private BankAccount getAccount(int id) throws Exception {
		 logger.info("Retrieve Bank Account BEGIN");
		 BankAccount account = dao.selectById(id);
		 return account;
	 }	
	 
	 private List getAllAccounts() throws Exception {
		 logger.info("Retrieve Bank Account BEGIN");
		 List<BankAccount> accounts = dao.selectAll();	
		 return accounts;
	 }	
	 
	 private void insertAccount(BankAccount account) throws Exception {
         dao.insert(account);
	 }	 
	 
	 private BankAccount createAccount() throws Exception {
		 BankAccount account = new BankAccount();
		 account.setName("New Name");
		 account.setAddress("New Address");
		 account.setState("New State");
		 account.setZip("New Zip");
		 account.setCreateDate(getNow());
		 account.setStatus(422);
		 return account;
	 }	 
	 
	 private Timestamp getNow() {
		 Calendar calendar = Calendar.getInstance();
		 Date now = calendar.getTime();
		 Timestamp timestamp = new Timestamp(now.getTime());
		 return timestamp;
	 }
	

}

