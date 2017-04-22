package com.rueggerllc.daos;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rueggerllc.hibernate.HibernateContext;

public class BaseDAOImpl implements BaseDAO {
	
  private static Logger logger = Logger.getLogger(BaseDAOImpl.class);
  
  public Object save(Object object) throws Exception {
	Transaction tx = null;
    try {
      logger.info("-------SAVE BEGIN------------");
      Session session = HibernateContext.getCurrentSession();
      tx = session.beginTransaction();
      session.save(object);
      tx.commit(); 
    } catch (Exception e) {
      logger.error("Exception:\n" + e);
      if (tx != null && tx.isActive()) {
        tx.rollback();
      }
    }
    return object;	  	  
  }
  

  public <T> T read(Class<T> theClass, Long id) throws HibernateException {
	  Session session = getSession();
	  Transaction tx = session.beginTransaction();
	  try {
		  T theObject = (T)session.get(theClass, id);
		  commit(session, tx);
		  return theObject;
    } catch (Exception e) {
    	rollback(session,tx);
    	throw new HibernateException(e.getMessage());
    }
  }
  
  
  public <T> T read(Class<T> theClass, String id) throws HibernateException {
	  Session session = getSession();
	  Transaction tx = session.beginTransaction();
	  try {
		  T theObject = (T)session.get(theClass, id);
		  commit(session, tx);
		  return theObject;
    } catch (Exception e) {
    	rollback(session,tx);
    	throw new HibernateException(e.getMessage());
    }
  }
  

  
  public Object update(Object object) throws Exception {
	Transaction tx = null;
    try {
      logger.info("-------UPDATE BEGIN------------");
      Session session = HibernateContext.getCurrentSession();
      tx = session.beginTransaction();
      session.update(object);
      tx.commit(); 
    } catch (Exception e) {
      logger.error("Exception:\n" + e);
      if (tx != null && tx.isActive()) {
        tx.rollback();
      }
    }
    return object;	  
  }
	
  
  public Object saveOrUpdate(Object object) throws Exception {
	Transaction tx = null;
    try {
      logger.info("-------SAVE OR UPDATE BEGIN------------");
      Session session = HibernateContext.getCurrentSession();
      tx = session.beginTransaction();
      session.saveOrUpdate(object);
      tx.commit(); 
    } catch (Exception e) {
      logger.error("Exception:\n" + e);
      if (tx != null && tx.isActive()) {
        tx.rollback();
      }
    }
    return object;	  	  
  }
	
  public Object delete(Object object) throws Exception {
	Transaction tx = null;
    try {
      logger.info("-------DELETE BEGIN------------");
      Session session = HibernateContext.getCurrentSession();
      tx = session.beginTransaction();
      session.delete(object);
      tx.commit(); 
    } catch (Exception e) {
      logger.error("Exception:\n" + e);
      if (tx != null && tx.isActive()) {
        tx.rollback();
      }
    }
    return object;	  	  
  }
	
  public List findAll(Class<?> theClass) throws Exception {
	Transaction tx = null;
	List<?> list = new ArrayList();
    try {
      logger.info("-------FIND ALL BEGIN------------");
      Session session = HibernateContext.getCurrentSession();
      tx = session.beginTransaction();
      Query q = session.createQuery("Select o from " + theClass.getSimpleName() + " o ");
      q.setCacheable(true);
      q.setCacheMode(CacheMode.NORMAL);
      q.setCacheRegion(theClass.getSimpleName() + ".findAll");
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
  
  protected Session getSession() {
	  return HibernateContext.getCurrentSession();
  }
  
  protected void commit(Session session, Transaction tx) {
	  tx.commit();
  }
  
  protected void rollback(Session session, Transaction tx) {
	  if (tx != null) {
		  tx.commit();
	  }
  }
  
  
  

}
