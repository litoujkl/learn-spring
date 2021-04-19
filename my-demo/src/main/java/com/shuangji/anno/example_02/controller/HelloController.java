package com.shuangji.anno.example_02.controller;

import com.shuangji.anno.example_02.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;

	public void handleRequest() {
		helloService.sayHello();
	}
}
