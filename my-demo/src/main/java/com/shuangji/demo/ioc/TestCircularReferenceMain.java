package com.shuangji.demo.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCircularReferenceMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac
				= new AnnotationConfigApplicationContext(AppConfig.class);
		Boyfriend boyfriend = ac.getBean(Boyfriend.class);
		boyfriend.say();
	}
}