package com.shuangji.demo.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

@Component
public class Girlfriend {

	@Autowired
	private Boyfriend boyfriend;

	public void say() {
		System.out.println("hi, boyfriend");
	}
}
