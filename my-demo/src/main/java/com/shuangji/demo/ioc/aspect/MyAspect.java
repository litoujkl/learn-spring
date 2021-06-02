package com.shuangji.demo.ioc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Pointcut("execution(* com.shuangji.demo.ioc.Boyfriend.say(..))")
	public void boyfriendSay() {
	}

	@Pointcut("execution(* com.shuangji.demo.ioc.Girlfriend.say(..))")
	public void girlfriendSay() {
	}

	// passing parameters to advice
	@Around("boyfriendSay()")
	public void aroundBoyfriend(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("****MyAspect.around(): " + joinPoint.getSignature().getName() + ": Before Method Execution");
		try {
			joinPoint.proceed();
		} finally {
			//Do Something useful, If you have
		}
		System.out.println("****MyAspect.around(): " + joinPoint.getSignature().getName() + ": After Method Execution");
	}

}
