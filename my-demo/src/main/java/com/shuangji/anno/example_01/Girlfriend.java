package com.shuangji.anno.example_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Girlfriend {

	@Autowired
	private Boyfriend boyfriend;
}
