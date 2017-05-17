package com.rueggerllc.aop.biz;

import org.apache.log4j.Logger;

public class BizDelegate {

	private static Logger logger = Logger.getLogger(BizDelegate.class);
	
	public void method1(String msg) {
		logger.info("Inside Method 1");
		logger.info("Message is: " + msg);
	}
	
	public void method2(String msg) {
		logger.info("INSIDE METHOD2");
	}
}
