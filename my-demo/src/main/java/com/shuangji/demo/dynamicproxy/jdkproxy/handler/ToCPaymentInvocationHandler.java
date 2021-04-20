package com.shuangji.demo.dynamicproxy.jdkproxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ToCPaymentInvocationHandler implements InvocationHandler {

	private Object targetObject;

	public ToCPaymentInvocationHandler(Object targetObject) {
		this.targetObject = targetObject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object obj = method.invoke(targetObject, args);
		after();
		return obj;
	}

	private void after() {
		System.out.println("after() called");
	}

	private void before() {
		System.out.println("before() called");
	}
}
