package com.rueggerllc.hibernate;

import org.hibernate.dialect.DerbyDialect;

public class MyDerbyDialect extends DerbyDialect {
	
	@Override
	public String getSequenceNextValString(String sequenceName) {
		return "values next value for " + sequenceName;
	}

}
