package com.rueggerllc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NamedPointcuts {
	// Example Usage:
	// @Before("com.rueggerllc.aop.NamedPointcuts.serviceMethods()")
	@Pointcut("execution(* com.rueggerllc.aop.biz.*.*(..))")
	public void serviceMethods() {}
}
