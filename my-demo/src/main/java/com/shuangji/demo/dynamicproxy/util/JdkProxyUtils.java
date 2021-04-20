package com.shuangji.demo.dynamicproxy.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxyUtils {

	 public static <T> T createProxy(T object, InvocationHandler handler) {
		 Class<?> clazz = object.getClass();
		 return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
	}
}
