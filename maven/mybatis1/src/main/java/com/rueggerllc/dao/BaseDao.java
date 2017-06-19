package com.rueggerllc.dao;

import java.util.List;

import com.rueggerllc.mappers.Mapper;

public interface BaseDao<M extends Mapper<D>, D> {
	
	public List<D> 	selectAll() throws Exception;
	public D 		selectById(long id) throws Exception;
	public void 	insert(D domainObject) throws Exception;
	public void 	update(D domainObject) throws Exception;
	public void     delete(long id) throws Exception;

	

}
