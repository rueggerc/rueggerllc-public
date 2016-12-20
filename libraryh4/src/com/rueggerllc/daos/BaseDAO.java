package com.rueggerllc.daos;

import java.util.List;

public interface BaseDAO {	
	
	public Object save(Object object) throws Exception;
	
	public <T> T read(Class<T> theClass, Long id) throws Exception;
	
	public <T> T read(Class<T> theClass, String id) throws Exception;
	
	public Object update(Object object) throws Exception;
	
	public Object saveOrUpdate(Object object) throws Exception;
	
	public Object delete(Object theObject) throws Exception;
	
	public List findAll(Class<?> theClass) throws Exception;
}
