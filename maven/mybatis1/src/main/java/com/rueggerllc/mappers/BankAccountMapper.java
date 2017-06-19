package com.rueggerllc.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.rueggerllc.domain.BankAccount;

public interface BankAccountMapper extends Mapper<BankAccount> {

	final String SELECT_ALL = "SELECT * FROM BANK_ACCOUNT";
	final String SELECT_BY_ID = "SELECT * FROM BANK_ACCOUNT WHERE ID = #{id}";
	final String UPDATE = "UPDATE BANK_ACCOUNT " +
				 "SET NAME=#{name}, ADDRESS=#{address}, STATE=#{state}, " +
				 "ZIP=#{zip}, CREATE_DATE=#{createDate}, STATUS=#{status} " +
				 "WHERE ID=#{id}";
	
	final String DELETE = "DELETE FROM BANK_ACCOUNT WHERE ID=#{id}";
	final String INSERT = "INSERT INTO BANK_ACCOUNT" +
				 "(ID, NAME, ADDRESS, STATE, ZIP, CREATE_DATE, STATUS) " +
				 "VALUES (#{id}, #{name},#{address},#{state},#{zip},#{createDate},#{status})";
	
	@Select(SELECT_ALL)
	@Results(value={
			@Result(property="id", column="ID"),
			@Result(property="name", column="NAME"),
			@Result(property="address", column="ADDRESS"),
			@Result(property="state", column="STATE"),
			@Result(property="zip", column="ZIP"),
			@Result(property="createDate", column="CREATE_DATE"),
			@Result(property="status", column="STATUS")
	})
	List<BankAccount> selectAll();
	
	@Select(SELECT_BY_ID)
	@Results(value={
			@Result(property="id", column="ID"),
			@Result(property="name", column="NAME"),
			@Result(property="address", column="ADDRESS"),
			@Result(property="state", column="STATE"),
			@Result(property="zip", column="ZIP"),
			@Result(property="createDate", column="CREATE_DATE"),
			@Result(property="status", column="STATUS")
	})
	BankAccount selectById(long id);
	
	@Insert(INSERT)
	@SelectKey(statement="values next value for bank_account_seq", keyProperty="id", before=true, resultType=int.class)
	void insert(BankAccount account);
	
	@Update(UPDATE)
	void update(BankAccount account);
	
	@Delete(DELETE)
	void delete(long id);
	
	
	
	
	
	
}
