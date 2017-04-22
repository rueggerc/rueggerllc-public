package com.rueggerllc.daos;

import java.util.List;


public interface AccountDAO extends BaseDAO {
	public List getAccountByName(String name) throws Exception;
}
