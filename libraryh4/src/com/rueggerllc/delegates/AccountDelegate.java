package com.rueggerllc.delegates;

import java.util.List;

import com.rueggerllc.beans.Account;
import com.rueggerllc.daos.AccountDAO;
import com.rueggerllc.daos.AccountDAOImpl;

public class AccountDelegate {
	
	private AccountDAO dao = new AccountDAOImpl();
	
	public List<Account> getAllAccounts() throws Exception {
		List<Account> accounts = dao.findAll(Account.class);
		return accounts;
	}
	
	public Account getAccount(Long id) throws Exception {
		Account account = dao.read(Account.class, id);
		return account;
	}

}
