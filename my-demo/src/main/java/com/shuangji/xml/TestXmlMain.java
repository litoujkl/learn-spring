package com.shuangji.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestXmlMain {
	public static void main(String[] args) {
//		ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\ysm\\Desktop\\spring-framework\\my-demo\\src\\main\\resources\\spring-context.xml");

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml");
		Room room = (Room) ac.getBean("room");
		System.out.println(room);
		System.out.println(room.getUser());
	}
}
