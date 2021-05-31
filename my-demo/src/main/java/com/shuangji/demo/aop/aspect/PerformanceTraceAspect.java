package com.shuangji.demo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class PerformanceTraceAspect {

	@Pointcut("execution(public void com.shuangji.demo.aop.bo.NestableInvocationBO.method1())")
	public void method1() {
	}

	@Pointcut("execution(public void com.shuangji.demo.aop.bo.NestableInvocationBO.method2())")
	public void method2() {
	}

	@Pointcut("method1()||method2()")
	public void compositePointcut () {

	}

	@Around("compositePointcut()")
	public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch watch = new StopWatch();
		try {
			watch.start();
			return joinPoint.proceed();
		} finally {
			watch.stop();
			System.out.println(joinPoint.getSignature().getName() + ">>>>" + watch);
		}
	}
}
