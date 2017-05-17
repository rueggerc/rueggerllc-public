package com.rueggerllc.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SecurityAspect {
	
	private static Logger logger = Logger.getLogger(SecurityAspect.class);

	// Define our Pointcut and Advice
	@Around("execution(* com.rueggerllc.aop.biz.*.*(..))")
	public Object authorizeUser(ProceedingJoinPoint joinPoint) throws Throwable {

    try {
    	logger.info("authorizeUser BEFORE");
    	logger.info("class: " + joinPoint.getSignature().getDeclaringTypeName());
    	logger.info("method: " + joinPoint.getSignature().getName());
    	Object target = joinPoint.getTarget();
    	Object[] args = joinPoint.getArgs();
    	Object returnValue = joinPoint.proceed();
    	logger.info("authorizeUser AFTER");
       return returnValue;
    } catch (Exception e){ 
      throw e;
    }
  }

}
