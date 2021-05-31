package com.shuangji.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Pointcut("execution(* com.shuangji.demo.aop.service..*(..))")
	public void embed() {
	}

	@Before("embed()")
	public void before(JoinPoint joinPoint) {
		System.out.println("MyAspect before() called: " + joinPoint.getSignature().getName());
	}

	@After("embed()")
	public void after(JoinPoint joinPoint) {
		System.out.println("MyAspect after() called: " + joinPoint.getSignature().getName());
	}

	// passing parameters to advice
	@Around("embed() && args(msg)")
	public void around(ProceedingJoinPoint joinPoint, String msg) throws Throwable {
		System.out.println("****MyAspect.around(): " + joinPoint.getSignature().getName() + ": Before Method Execution");
		try {
			joinPoint.proceed();
		} finally {
			//Do Something useful, If you have
		}
		System.out.println("****MyAspect.around(): " + joinPoint.getSignature().getName() + ": After Method Execution");
	}

	@AfterReturning("embed()")
	public void afterReturning(JoinPoint joinPoint) throws Throwable {
		System.out.println("MyAspect afterReturning() called: " + joinPoint.getSignature().getName());
	}
}
