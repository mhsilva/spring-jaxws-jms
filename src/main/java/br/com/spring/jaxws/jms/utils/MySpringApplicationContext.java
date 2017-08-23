package br.com.spring.jaxws.jms.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;

public class MySpringApplicationContext implements ApplicationContextAware {
	private static ApplicationContext instance;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		instance = applicationContext;
		if (instance instanceof AbstractApplicationContext) {
			((AbstractApplicationContext) instance).registerShutdownHook();
		}
	}

	public static <T> T getBean(Class<T> beanClass) {
		if (instance == null) {
			throw new IllegalStateException("Application context do spring está nulo !");
		}

		T bean = instance.getBean(beanClass);

		return bean;
	}
}
