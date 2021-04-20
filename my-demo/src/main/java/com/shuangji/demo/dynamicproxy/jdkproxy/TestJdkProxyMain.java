package com.shuangji.demo.dynamicproxy.jdkproxy;

import com.shuangji.demo.dynamicproxy.jdkproxy.handler.ToCPaymentInvocationHandler;
import com.shuangji.demo.dynamicproxy.jdkproxy.impl.ToCPaymentImpl;
import com.shuangji.demo.dynamicproxy.util.JdkProxyUtils;

import java.lang.reflect.InvocationHandler;

public class TestJdkProxyMain {
	public static void main(String[] args) {
		ToCPayment toCPayment = new ToCPaymentImpl();
		InvocationHandler handler = new ToCPaymentInvocationHandler(toCPayment);
		ToCPayment proxy = JdkProxyUtils.createProxy(toCPayment, handler);
		proxy.pay();
	}
}
