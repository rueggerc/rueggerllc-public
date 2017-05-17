package com.rueggerllc.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAfterAspect {
	
	private static Logger logger = Logger.getLogger(MyAfterAspect.class);

	// Define our Pointcut and Advice
	@After("execution(* com.rueggerllc.aop.biz.BizDao.execute(..))")
	public void runAfterAdvice(JoinPoint joinPoint) throws Throwable {
    try {
    	logger.info("class: " + joinPoint.getSignature().getDeclaringTypeName());
    	logger.info("method: " + joinPoint.getSignature().getName());
    	Object target = joinPoint.getTarget();
    	Object[] args = joinPoint.getArgs();
    } catch (Exception e) { 
      throw e;
    }
  }

}
