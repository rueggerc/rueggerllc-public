package com.rueggerllc.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import net.sf.ehcache.CacheManager;

public class StartupListener implements ServletContextListener {
	
	private static Logger logger = Logger.getLogger(StartupListener.class);
	private static final String APP_NAME = "RestWeb";
	
	public StartupListener() {
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		logger.info(String.format("==== %s Context Destruction BEGIN ===", APP_NAME));
		CacheManager.getInstance().shutdown();
		logger.info(String.format("==== %s Context Destruction END ===", APP_NAME));
	}
	
	public void contextInitialized(ServletContextEvent event) {
		logger.info(String.format("==== %s Context Initializaion BEGIN ===", APP_NAME));
		logger.info(String.format("==== %s Context Initializaion END ===", APP_NAME));
	}

}