package com.rueggerllc.daos;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rueggerllc.hibernate.HibernateContext;


public class AccountDAOImpl  extends BaseDAOImpl implements AccountDAO {
	
	private static Logger logger = Logger.getLogger(BaseDAOImpl.class);
	
	public List getAccountByName(String name) throws Exception {
		Transaction tx = null;
		List<?> list = new ArrayList();
		try	{
			logger.info("-------FIND ALL BEGIN------------");
			Session session = HibernateContext.getCurrentSession();
			tx = session.beginTransaction();
			Query q = session.getNamedQuery("account.findByName");
			q.setString("name", name);
			list = (List<?>)q.list();
			tx.commit(); 
		} catch (Exception e) {
			logger.error("Exception:\n" + e);
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		return list;  	  
	}
}
