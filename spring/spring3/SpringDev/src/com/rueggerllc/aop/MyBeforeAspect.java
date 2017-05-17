package com.rueggerllc.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class MyBeforeAspect {
	
	private static Logger logger = Logger.getLogger(MyBeforeAspect.class);

	// Define our Pointcut and Advice
	@Before("execution(* com.rueggerllc.aop.biz.BizDao.execute(..))")
	public void runBefore(JoinPoint joinPoint) throws Throwable {
    try {
    	logger.info("runBefore() BEFORE");
    	logger.info("class: " + joinPoint.getSignature().getDeclaringTypeName());
    	logger.info("method: " + joinPoint.getSignature().getName());
    	Object target = joinPoint.getTarget();
    	Object[] args = joinPoint.getArgs();
    } catch (Exception e) { 
      throw e;
    }
  }

}
