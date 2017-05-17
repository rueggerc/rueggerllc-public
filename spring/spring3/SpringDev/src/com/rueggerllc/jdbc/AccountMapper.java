package com.rueggerllc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rueggerllc.jdbc.domain.Account;

public class AccountMapper implements RowMapper<Account> {
	public Account mapRow(ResultSet rs, int i) throws SQLException {
		System.out.println("Mapping Account");
		Account account = new Account();
		account.setId(new Long(rs.getInt("id")));
		account.setName(rs.getString("name"));
		account.setAddress(rs.getString("address"));
		account.setState(rs.getString("state"));
		account.setZip(rs.getString("zip"));
		account.setCreateDate(rs.getDate("create_date"));
		account.setStatus(rs.getInt("status"));
		return account;
	}
}
