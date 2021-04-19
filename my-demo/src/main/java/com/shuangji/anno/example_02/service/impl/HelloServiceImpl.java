package com.shuangji.anno.example_02.service.impl;

import com.shuangji.anno.example_02.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello() {
		System.out.println("Hello, everyone!");
	}
}
