package com.shuangji.demo.dynamicproxy.cglib.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		before();
		Object o = proxy.invokeSuper(obj, args);
		after();
		return o;
	}

	private void after() {
		System.out.println("after() called");
	}

	private void before() {
		System.out.println("before() called");
	}

}
