package com.shuangji.demo.dynamicproxy.cglib.interceptor;

import com.shuangji.demo.dynamicproxy.util.CglibProxyUtils;
import net.sf.cglib.proxy.MethodInterceptor;

public class TestCglibProxyMain {
	public static void main(String[] args) {
		ToCPayment payment = new ToCPayment();
		MethodInterceptor interceptor = new MyMethodInterceptor();
		ToCPayment proxy = CglibProxyUtils.createProxy(payment, interceptor);
		proxy.pay();
	}
}
