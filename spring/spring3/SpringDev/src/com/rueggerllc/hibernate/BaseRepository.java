package com.rueggerllc.hibernate;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface BaseRepository {
	
	@Transactional(readOnly=true)
	public <T> List<T> findAll(Class<T> theClass);
	
	@Transactional(readOnly=true)
	public <T> T read(Class<T> theClass, String id);
	
	public void save(Object object);
	public void saveOrUpdate(Object object);
	public void delete(Object object);
	
}
