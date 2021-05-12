## 基于注解的容器初始化

```java
public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
	this(); // Step 1
	register(componentClasses); // Step 2
	refresh(); // Step 3
}
```

### Step 1
```java
this.reader = new AnnotatedBeanDefinitionReader(this); 
this.scanner = new ClassPathBeanDefinitionScanner(this);
```
```this.reader = new AnnotatedBeanDefinitionReader(this); ```调用
`AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry);`
将所有与注解相关的post processor的`BeanDefinition`注册到容器（registry）中, 主要有：
- `ConfigurationClassPostProcessor`
- `AutowiredAnnotationBeanPostProcessor`
- `EventListenerMethodProcessor`
- `DefaultEventListenerFactory`

### Step 2
调用`this.reader.register(componentClasses);`
将`@Configuration`注解的类的`BeanDefinition`注册到容器中

### Step 3
`refresh`流程见 `refresh.png`