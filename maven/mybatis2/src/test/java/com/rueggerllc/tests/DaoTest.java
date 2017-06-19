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
		logger.info("Retrive Bank Accounts Begin..");
		List<BankAccount> accounts = dao.selectAll();
		logger.info("Retrieved Bank Accounts=" + accounts.size());
		for (BankAccount account : accounts) {
			logger.info("Next Account=" + account);
		}
	}
	
	@Ignore
	@Test
	public void selectByIdTest() throws Exception {
		logger.info("Retrive Bank Account Begin..");
		long id = 42;
		BankAccount account = dao.selectById(id);
		logger.info("Account=" + account);		
	}
	
	@Ignore
	@Test
	public void insertTest() throws Exception {
		logger.info("Inserting Bank Account");
		BankAccount account = new BankAccount();
		account.setName("Navy Federal");
		account.setAddress("212 Vienna Street");
		account.setState("New Jersey");
		account.setZip("07642");
		account.setCreateDate(getNow());
		account.setStatus(414);
		dao.insert(account);
	}
	
	@Ignore
	@Test
	public void updateTest() throws Exception {
		logger.info("Updating Bank Account");
		BankAccount account = dao.selectById(108);
		account.setName("Update Name");
		account.setAddress("Update Address");
		account.setState("Update State");
		account.setZip("UpdateZip");
		account.setCreateDate(getNow());
		account.setStatus(388);
		dao.update(account);
	}
	
	@Ignore
	@Test
	public void deleteTest() throws Exception {
		logger.info("Deleting Bank Account");
		List<BankAccount> accounts = getAllAccounts();
		int numberOfAccounts = accounts.size();
		
		// Add Account
		BankAccount account = createAccount();
		insertAccount(account);
		int newAccountId = account.getId();
		logger.info("New Account Id=" + newAccountId);
		
		// Verifiy Account Inserted
		accounts = getAllAccounts();
		int numberOfAccountsAfterInsert = accounts.size();
		logger.info("Number of Accounts after insert=" + numberOfAccountsAfterInsert);
		assertEquals(numberOfAccounts+1, numberOfAccountsAfterInsert);
		
		// Delete Account
		dao.delete(account.getId());
		
		account = getAccount(newAccountId);
		assertNull(account);
		logger.info("Account Deleted");
	
	}
	
	private BankAccount getAccount(long id) throws Exception {
		logger.info("Retrieve Bank Account Begin");
		BankAccount account = dao.selectById(id);
		return account;
	}
	
	private List getAllAccounts() throws Exception {
		logger.info("Retrieve Accounts Begin");
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


