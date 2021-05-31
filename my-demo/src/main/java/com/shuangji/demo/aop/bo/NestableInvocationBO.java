package com.shuangji.demo.aop.bo;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Component
public class NestableInvocationBO {

	public void method1() {
//		method2();
		NestableInvocationBO proxy = (NestableInvocationBO) AopContext.currentProxy();
		proxy.method2();
		System.out.println("method1 executed");
	}

	public void method2() {
		System.out.println("method2 executed");
	}
}
