package com.rueggerllc.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class FooAspect {
	
	private static Logger logger = Logger.getLogger(FooAspect.class);

	// Define our Pointcut and Advice
	@Around("execution(* com.rueggerllc.aop.biz.*.*(..))")
	public Object runFoo(ProceedingJoinPoint joinPoint) throws Throwable {
    try {
    	logger.info("runFoo() BEFORE");
    	logger.info("class: " + joinPoint.getSignature().getDeclaringTypeName());
    	logger.info("method: " + joinPoint.getSignature().getName());
    	Object target = joinPoint.getTarget();
    	Object[] args = joinPoint.getArgs();
    	Object returnValue = joinPoint.proceed();
    	logger.info("runFoo() AFTER");
    	return returnValue;
    } catch (Exception e) { 
      throw e;
    }
  }

}
