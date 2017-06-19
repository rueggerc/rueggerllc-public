package com.rueggerllc.dao;

import org.apache.log4j.Logger;

import com.rueggerllc.domain.BankAccount;
import com.rueggerllc.mappers.BankAccountMapper;


public class BankAccountDaoImpl extends BaseDaoImpl<BankAccountMapper,BankAccount> implements BankAccountDao {
	
	private static Logger logger = Logger.getLogger(BankAccountDaoImpl.class);
	public BankAccountDaoImpl() {
		super(BankAccountMapper.class);
	}
	

}
