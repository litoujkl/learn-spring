package com.shuangji.demo.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.shuangji.demo.ioc")
@EnableAspectJAutoProxy()
public class AppConfig {
}
