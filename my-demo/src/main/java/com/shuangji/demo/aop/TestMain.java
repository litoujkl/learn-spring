package com.shuangji.demo.aop;

import com.shuangji.demo.aop.controller.HelloController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.shuangji.demo.aop")
public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestMain.class);
		HelloController helloController = (HelloController) ac.getBean("helloController");
		helloController.handleRequest();
	}
}
