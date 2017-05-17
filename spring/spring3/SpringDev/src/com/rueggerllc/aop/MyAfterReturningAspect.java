package com.rueggerllc.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import com.rueggerllc.beans.Reward;

@Aspect
public class MyAfterReturningAspect {
	
	private static Logger logger = Logger.getLogger(MyAfterReturningAspect.class);

	// Define our Pointcut and Advice
	@AfterReturning(pointcut="execution(com.rueggerllc.beans.Reward com.rueggerllc.aop.biz.*.*(..))", returning="reward")
	public void runAfterReturningAdvice(JoinPoint joinPoint, Reward reward) throws Throwable {
    try {
    	logger.info("after Returning");
    	logger.info("class: " + joinPoint.getSignature().getDeclaringTypeName());
    	logger.info("method: " + joinPoint.getSignature().getName());
    	Object target = joinPoint.getTarget();
    	Object[] args = joinPoint.getArgs();
    	logger.info("Reward Value=" + reward.getValue());
    } catch (Exception e) { 
      throw e;
    }
  }

}
