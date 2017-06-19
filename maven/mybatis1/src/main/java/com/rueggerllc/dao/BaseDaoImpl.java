package com.rueggerllc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.rueggerllc.mappers.Mapper;
import com.rueggerllc.mybatis.MybatisContext;

public class BaseDaoImpl<M extends Mapper<D>,D> {
	
	private static final Logger logger = Logger.getLogger(BaseDaoImpl.class);
	
	private Class<M> mapperClass;
	
	protected BaseDaoImpl(Class<M> theClass) {
		this.mapperClass = theClass;
	}
	
	public List<D> selectAll() throws Exception {
		SqlSession session = null;
		try {
			session = MybatisContext.getFactory().openSession();
			Mapper<D> mapper = session.getMapper(mapperClass);
			List<D> domainObjects = mapper.selectAll();
			return domainObjects;
			
		} catch (Exception e) {
			logger.error("Error", e);
			throw e;
		} finally {
			session.close();
		}
	}
	
	
	public D selectById(long id) throws Exception {
		SqlSession session = null;
		try {
			session = MybatisContext.getFactory().openSession();
			Mapper<D> mapper = session.getMapper(mapperClass);
			D domainObject = mapper.selectById(id);
			return domainObject;
			
		} catch (Exception e) {
			logger.error("Error", e);
			throw e;
		} finally {
			session.close();
		}
	}
	
	
	public void insert(D domainObject) throws Exception {
		SqlSession session = null;
		try {
			session = MybatisContext.getFactory().openSession();
			Mapper<D> mapper = session.getMapper(mapperClass);
			mapper.insert(domainObject);
			session.commit();
			
		} catch (Exception e) {
			logger.error("Error", e);
			throw e;
		} finally {
			session.close();
		}
	}
	
	
	public void update(D domainObject) throws Exception {
		SqlSession session = null;
		try {
			session = MybatisContext.getFactory().openSession();
			Mapper<D> mapper = session.getMapper(mapperClass);
			mapper.update(domainObject);
			session.commit();
			
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
			Mapper<D> mapper = session.getMapper(mapperClass);
			mapper.delete(id);
			session.commit();
			
		} catch (Exception e) {
			logger.error("Error", e);
			throw e;
		} finally {
			session.close();
		}
	}
	
	

	
	


	

}
