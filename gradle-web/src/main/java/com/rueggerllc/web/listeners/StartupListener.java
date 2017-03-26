package com.rueggerllc.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class StartupListener implements ServletContextListener {
	
	private static Logger logger = Logger.getLogger(StartupListener.class);
	private static final String APP_NAME = "gradle-web";
	
	public StartupListener() {
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		logger.info(String.format("==== %s Context Destruction BEGIN ===", APP_NAME));
		logger.info(String.format("==== %s Context Destruction END ===", APP_NAME));
	}
	
	public void contextInitialized(ServletContextEvent event) {
		logger.info(String.format("==== %s Context Initializaion BEGIN ===", APP_NAME));
		logger.info(String.format("==== %s Context Initializaion END ===", APP_NAME));
	}

}
