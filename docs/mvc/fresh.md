# refresh 流程

### 1. ``` ServletContextListener```接口

```java
public interface ServletContextListener extends EventListener {

    /**
     * Receives notification that the web application initialization
     * process is starting.
     *
     * <p>All ServletContextListeners are notified of context
     * initialization before any filters or servlets in the web
     * application are initialized.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     * that is being initialized
     */
    public void contextInitialized(ServletContextEvent sce);

    /**
     * Receives notification that the ServletContext is about to be
     * shut down.
     *
     * <p>All servlets and filters will have been destroyed before any
     * ServletContextListeners are notified of context
     * destruction.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     * that is being destroyed
     */
    public void contextDestroyed(ServletContextEvent sce);
}

```



### 2. ```ContextLoaderListener```

```java
/**
	 * Initialize the root web application context.
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		initWebApplicationContext(event.getServletContext());
	}
```



### 3. ```initWebApplicationContext```

```configureAndRefreshWebApplicationContext```配置并刷新容器