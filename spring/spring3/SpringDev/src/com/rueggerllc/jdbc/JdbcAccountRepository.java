package com.rueggerllc.jdbc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rueggerllc.jdbc.domain.Account;

public class JdbcAccountRepository {
	
	private static Logger logger = Logger.getLogger(JdbcAccountRepository.class);
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcAccountRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getNumberOfAccounts() throws DataAccessException {
		String sql = "select count(*) from account";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public int getHighStatusAccounts(int status) throws DataAccessException {
		String sql = "select count(*) from account where status >= ?";
		return jdbcTemplate.queryForInt(sql, status);
	}
	
	public Map getAccount(int accountId) throws DataAccessException {
		String sql = "select * from account where id=?";
		return jdbcTemplate.queryForMap(sql, accountId);
	}
	
	public List getAccounts() throws DataAccessException {
		String sql = "select * from account";
		return jdbcTemplate.queryForList(sql);
	}
	
	public Account getAccountObject(int id) throws DataAccessException {
		return jdbcTemplate.queryForObject("select * from account where id =?", new AccountMapper(), id);
	}
	
	public List<Account> getAccountObjects() throws DataAccessException {
		return jdbcTemplate.query("select * from account", new AccountMapper());
	}
	
	public int insertAccount(Account account) {
		int accountId = this.getMaxAccountId() + 1;
		logger.info("New Account ID=" + accountId);
		return jdbcTemplate.update(
			"insert into account(id,name,address,state,zip,create_date,status) " +
			"values(?,?,?,?,?,?,?)",
			accountId,
			account.getName(),
			account.getAddress(),
			account.getState(),
			account.getZip(),
			account.getCreateDate(),
			account.getStatus());
	}
	
	public int updateAccount(Account account) {
		return jdbcTemplate.update(
			"update account set name=?,address=?,state=?,zip=?,create_date=?,status=? where id=?",
			account.getName(),
			account.getAddress(),
			account.getState(),
			account.getZip(),
			account.getCreateDate(),
			account.getStatus(),
			account.getId());
	}
	
	
	private int getMaxAccountId() {
		String sql = "select max(id) from account";
		return jdbcTemplate.queryForInt(sql);		
	}

}
