package com.rueggerllc.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

// @Repository
public class BaseRepositoryImpl implements BaseRepository {
	
	private static Logger logger = Logger.getLogger(BaseRepositoryImpl.class);
	private SessionFactory sessionFactory;
	
	public <T> List<T> findAll(Class<T> theClass) {
		Query q = getSessionFactory().getCurrentSession().createQuery("select o from " + theClass.getSimpleName() + " o ");
		q.setCacheable(true);
		q.setCacheMode(CacheMode.NORMAL);
		q.setCacheRegion(theClass.getSimpleName() + ".findAll");
		logger.info("CACHE REGION=" + theClass.getSimpleName() + ".findAll");
		List<T> list = (List<T>)q.list();
		return list;
	}
	
	public <T> T read(Class<T> theClass, String id) {
	  T theObject = (T)getSessionFactory().getCurrentSession().get(theClass, id);
	  return theObject;
	}

	public void save(Object object) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(object);
	}
	
	public void saveOrUpdate(Object object) {
		Session session = getSessionFactory().getCurrentSession();
		session.saveOrUpdate(object);
	}
	
	public void delete(Object object) {
		Session session = getSessionFactory().getCurrentSession();
		session.delete(object);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
