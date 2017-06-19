package com.rueggerllc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.rueggerllc.domain.BankAccount;
import com.rueggerllc.mybatis.MybatisContext;

public class BankAccountDaoImpl implements BankAccountDao {
	
	private static final Logger logger = Logger.getLogger(BankAccountDaoImpl.class);
	
	
	public List<BankAccount> selectAll() throws Exception {
		SqlSession session = null;
		try {
			session = MybatisContext.getFactory().openSession();
			List<BankAccount> accounts = session.selectList("BankAccount.selectAll");
			return accounts;
		} catch (Exception e) {
			logger.error("Error", e);
			throw e;
		} finally {
			session.close();
		}
	}
	
	
	public BankAccount selectById(long id) throws Exception {
		SqlSession session = null;
		try {
			session = MybatisContext.getFactory().openSession();
			BankAccount account = session.selectOne("BankAccount.selectById", id);
			return account;
		} catch (Exception e) {
			logger.error("Error", e);
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void  insert(BankAccount bankAccount) throws Exception {
		SqlSession session = null;
		try {
			session = MybatisContext.getFactory().openSession();
			int rc = session.insert("BankAccount.insert", bankAccount);
			session.commit();
            logger.info("Return code from insert=" + rc);
		} catch (Exception e) {
			logger.error("Error", e);
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void  update(BankAccount bankAccount) throws Exception {
		SqlSession session = null;
		try {
			session = MybatisContext.getFactory().openSession();
			int rc = session.insert("BankAccount.update", bankAccount);
			session.commit();
            logger.info("Return code from update=" + rc);
		} catch (Exception e) {
			logger.error("Error", e);
			throw e;
		} finally {
			session.close();
		}
	}
	
	
	public void delete(long id) throws Exception {
		SqlSession session = null;
		try {
			session = MybatisContext.getFactory().openSession();
			int rc = session.insert("BankAccount.deleteById", id);
			session.commit();
            logger.info("Return code from delete=" + rc);
		} catch (Exception e) {
			logger.error("Error", e);
			throw e;
		} finally {
			session.close();
		}
	}
	
}

