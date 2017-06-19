package com.rueggerllc.dao;

import java.util.List;

import com.rueggerllc.domain.BankAccount;


public interface BankAccountDao {
	public List<BankAccount> selectAll() throws Exception;
	public BankAccount selectById(long id) throws Exception;
	public void insert(BankAccount bankAccount) throws Exception;
	public void update(BankAccount bankAccount) throws Exception;
	public void delete(long id) throws Exception;
}
