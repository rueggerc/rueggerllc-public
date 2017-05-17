package com.rueggerllc.aop;

import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ServerStartupAspect {
	
	private static Logger logger = Logger.getLogger(ServerStartupAspect.class);

	@Before("execution(void com.rueggerllc.aop.Server+.start(java.util.Map)) && target(server) && args(input)")
	public void logServerStartup(Server server, Map input) {
		logger.info("Logging that Server is Starting up");
	}

}
