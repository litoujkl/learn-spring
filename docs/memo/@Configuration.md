### 为什么@Configuration标记的类会被Spring包装成一个Cglib代理
- 主要用来处理 `@Configuration`配置类中的`@Bean`方法

```java
    @Bean
	public ComponentA componentA() {
		return new ComponentA();
	}

	@Bean
	public ComponentB ComponentB() {
		ComponentA a1 = componentA();
		ComponentA a2 = componentA();
		// a1 == a2
		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);

		return new ComponentB(a1);
	}
```

如果注释掉`ConfigurationClassPostProcess`的`postProcessBeanFactory`中的`enhanceConfigurationClasses`方法，
上面 `a1 == a2` 则为 `false`