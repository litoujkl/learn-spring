package com.shuangji.anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnoMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac
				= new AnnotationConfigApplicationContext(AppConfig.class);
		System.err.println(ac.getBean(IndexService.class));
	}
}