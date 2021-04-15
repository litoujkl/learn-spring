package com.shuangji.anno.example_01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCircularReferenceMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac
				= new AnnotationConfigApplicationContext(AppConfig.class);
		System.err.println(ac.getBean(Boyfriend.class));
	}
}