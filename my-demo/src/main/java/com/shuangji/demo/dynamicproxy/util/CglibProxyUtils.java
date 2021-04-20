package com.shuangji.demo.dynamicproxy.util;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Proxy;

public class CglibProxyUtils {

	public static <T> T createProxy(T object, MethodInterceptor interceptor) {
		return (T) Enhancer.create(object.getClass(), interceptor);
	}
}
