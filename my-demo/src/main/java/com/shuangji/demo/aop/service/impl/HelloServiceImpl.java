package com.shuangji.demo.aop.service.impl;

import com.shuangji.demo.aop.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello(String msg) {
		System.out.println("hello, " + msg);
	}

	@Override
	public void sayHello() {
		System.out.println("hello.");
	}
}
