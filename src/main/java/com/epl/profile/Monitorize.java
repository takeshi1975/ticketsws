package com.epl.profile;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Monitorize {
	
	private Logger log = Logger.getLogger(Monitorize.class);
	
	@Around("execution(* com.epl.ticketws.repo.*.*(..))")
	private Object computeTime(ProceedingJoinPoint joinPoint)
	throws Throwable{
		long t1 = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long t2 = System.currentTimeMillis();
		if (t2-t1>500){
			log.info("Time:"+(t2-t1));
		}		
		return result;
	}
	
}
