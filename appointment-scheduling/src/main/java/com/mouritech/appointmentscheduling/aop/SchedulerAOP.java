package com.mouritech.appointmentscheduling.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SchedulerAOP {
	
private Logger logger=LoggerFactory.getLogger(getClass());
	
	@Before("execution(*com.mouritech.appointmentscheduling.service.*.*(..))")
	public void beforeMethodExcetion(JoinPoint point)
	{
		
		logger.info("before executing method "+point.getSignature().getName());
		
	}
	@After("execution(*com.mouritech.appointmentscheduling.service.*.*(..))")
	public void aftereMethodExcetion(JoinPoint point)
	{
		
		logger.info("after executing method "+point.getSignature().getName());
		
	}
	

}
