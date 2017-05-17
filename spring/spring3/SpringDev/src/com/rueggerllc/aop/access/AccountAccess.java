package com.rueggerllc.aop.access;

import com.rueggerllc.exceptions.MyDataException;


public class AccountAccess {
	
  public void getAccounts() throws Exception {
	  if (true) {
		  throw new MyDataException("Account Table Not found!");
	  }
  }

}
