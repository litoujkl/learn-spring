# refresh流程

```
// Prepare this context for refreshing.
prepareRefresh();

// Tell the subclass to refresh the internal bean factory.
ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

// Prepare the bean factory for use in this context.
prepareBeanFactory(beanFactory);

try {
	// Allows post-processing of the bean factory in context subclasses.
	postProcessBeanFactory(beanFactory);

	StartupStep beanPostProcess = this.applicationStartup.start("spring.context.beans.post-process");
	// Invoke factory processors registered as beans in the context.
	invokeBeanFactoryPostProcessors(beanFactory);

	// Register bean processors that intercept bean creation.
	registerBeanPostProcessors(beanFactory);
	beanPostProcess.end();

	// Initialize message source for this context.
	initMessageSource();

	// Initialize event multicaster for this context.
	initApplicationEventMulticaster();

	// Initialize other special beans in specific context subclasses.
	onRefresh();

	// Check for listener beans and register them.
	registerListeners();

	// Instantiate all remaining (non-lazy-init) singletons.
	finishBeanFactoryInitialization(beanFactory);

	// Last step: publish corresponding event.
	finishRefresh();
}
```