package gr.pr.udemy.crm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspectCRM {
	Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* gr.pr.udemy.crm.controllers.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* gr.pr.udemy.crm.services.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* gr.pr.udemy.crm.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	private void before(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("====> in @Before: calling method: " + method);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			logger.info("\n====> arg: " + arg);
		}
	}
	
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	private void afterReturning(JoinPoint joinPoint, Object result) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("====> in @AfterReturning: from method: " + method);
		
		logger.info("\n====> result: " + result);
	}
	
}
