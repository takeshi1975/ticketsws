package com.epl.ticketws.profile;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

@Aspect
@Component
public class Monitorize {

	private Logger log = Logger.getLogger(Monitorize.class);

	@Around("execution(* com.epl.ticketws.controller.*.*(..))")
	private Object computeTime(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		Monitor monitor = MonitorFactory.start("ticketws.controller");
		try {
			result = joinPoint.proceed();
		} finally {
			monitor.stop();
		}
		log.info(monitor.toString());
		return result;
	}
}
