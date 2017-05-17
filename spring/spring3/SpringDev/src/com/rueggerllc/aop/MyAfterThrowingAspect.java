package com.rueggerllc.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import com.rueggerllc.exceptions.MyDataException;

@Aspect
public class MyAfterThrowingAspect {
	
	private static Logger logger = Logger.getLogger(MyAfterThrowingAspect.class);

	// Define our Pointcut and Advice
	@AfterThrowing(value="execution(* com.rueggerllc.aop.access.*.*(..))", throwing="e")
	public void runAfterThrowingAdvice(JoinPoint joinPoint, MyDataException e) throws Throwable {
    try {
    	logger.info("After Throwing");
    	logger.info("class: " + joinPoint.getSignature().getDeclaringTypeName());
    	logger.info("method: " + joinPoint.getSignature().getName());
    	Object target = joinPoint.getTarget();
    	Object[] args = joinPoint.getArgs();
    	logger.info("Exception message=" + e.getMessage());
    } catch (Exception e1) { 
      throw e1;
    }
  }

}
