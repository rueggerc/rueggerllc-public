package com.rueggerllc.mappers;

import java.util.List;

public interface Mapper<D> {
	
	public List<D> 	selectAll() throws Exception;
	public D 		selectById(long id) throws Exception;
	public void 	insert(D domainObject) throws Exception;
	public void 	update(D domainObject) throws Exception;
	public void     delete(long id) throws Exception;

	

}
