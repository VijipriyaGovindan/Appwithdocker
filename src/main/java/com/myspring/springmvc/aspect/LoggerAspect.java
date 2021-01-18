package com.myspring.springmvc.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect 
{
	private Logger mylogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.myspring.springmvc.controller.*.*(..))")
	private void forContrPack() {}
	@Pointcut("execution(* com.myspring.springmvc.dao.*.*(..))")
	private void forDaoPack() {}
	@Pointcut("execution(* com.myspring.springmvc.services.*.*(..))")
	private void forServicesPack() {}
	@Pointcut("forContrPack() || forDaoPack() || forServicesPack()")
	private void forAll() {}
	
	@Before("forAll()")
	public void beforeAdvice(JoinPoint joinpoint)
	{
		String name = joinpoint.getSignature().toShortString();
		mylogger.info("In Before of calling:" +  name);
		
		Object[] args = joinpoint.getArgs();
		for (Object arg : args) {
			mylogger.info("In Before of argument:" +  arg);
		}
	
	}
	
	@AfterReturning(pointcut ="forAll()",returning ="theResult" )
	public void afterAdvice(JoinPoint joinpoint, Object theResult)
	{
		String name = joinpoint.getSignature().toShortString();
		mylogger.info("In After of calling:" +  name);
		mylogger.info("In AFter of calling:" +  theResult);
	
	}
	
}
