package com.rueggerllc.aop;

import java.util.Map;

import org.apache.log4j.Logger;

public class Server {

	private static Logger logger = Logger.getLogger(Server.class);
	
	public void start(Map input) {
		logger.info("Server is Starting up!");
	}
	public void stop() {
	}

}
