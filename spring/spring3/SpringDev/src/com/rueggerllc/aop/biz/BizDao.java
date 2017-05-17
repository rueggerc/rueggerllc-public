package com.rueggerllc.aop.biz;

import org.apache.log4j.Logger;

import com.rueggerllc.beans.Reward;

public class BizDao {

	private static Logger logger = Logger.getLogger(BizDao.class);
	
	public void execute(String msg) {
		logger.info("Message is: " + msg);
	}
	
	public Reward executeWithReward() {
		return new Reward(42);
	}
	
}
