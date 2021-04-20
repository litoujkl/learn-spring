package com.shuangji.demo.dynamicproxy.jdkproxy.impl;

import com.shuangji.demo.dynamicproxy.jdkproxy.ToCPayment;

public class ToCPaymentImpl implements ToCPayment {

	@Override
	public void pay() {
		System.out.println("使用支付宝支付");
	}
}
