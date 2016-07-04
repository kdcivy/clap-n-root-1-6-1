package com.ktds.framework.common.boot;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * SpringContextListener
 * @author SW기술연구소
 * @since 2015.05.01
 * @version 1.0
 * 
 * Event handling in the ApplicationContext is provided through the ApplicationEvent class and ApplicationListener interface.
 * ContextRefreshedEvent : Published when the ApplicationContext is initialized or refreshed, 
 * for example, using the refresh() method on the ConfigurableApplicationContext interface.
 * "Initialized" here means that all beans are loaded, post-processor beans are detected and activated,
 * singletons are pre-instantiated, and the ApplicationContext object is ready for use.
 * As long as the context has not been closed, a refresh can be triggered multiple times, 
 * provided that the chosen ApplicationContext actually supports such "hot" refreshes.
 * For example, XmlWebApplicationContext supports hot refreshes, but GenericApplicationContext does not.
 * <pre>
 * << 개정 이력 >>
 *	수정일		수정자		수정내용
 *	----------	----------	--------
 *	2015.05.01	SW기술연구소	최초생성
 *</pre>
 */
public class SpringContextListener implements ApplicationListener<ContextRefreshedEvent>{
	private static Logger logger = LoggerFactory.getLogger(SpringContextListener.class);
	
	public SpringContextListener(){
	    super();
	    logger.debug("SpringContextListener Application context listener is created!");
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		logger.info("----------------------- Start SpringContextListener -----------------------");
		ApplicationContext appCtx = arg0.getApplicationContext();
		logger.info("Id=" + appCtx.getId() + ", displayName=" + appCtx.getDisplayName());
		
		// print profile info
		for(String prifile : appCtx.getEnvironment().getActiveProfiles()){
			logger.info("Active Profile=" + prifile);	
		}
		
		// print all loaded beans
		String[] beans = appCtx.getBeanDefinitionNames();
		for(String beanName : beans){
			logger.info("bean name=" + beanName);
		}

		logger.info("spring.profiles.active=" + appCtx.getEnvironment().getProperty("spring.profiles.active"));
		logger.info("log4j.configurationFile=" + appCtx.getEnvironment().getProperty("log4j.configurationFile"));
		logger.info("logback.configurationFile=" + appCtx.getEnvironment().getProperty("logback.configurationFile"));
		logger.info("logs.dir=" + appCtx.getEnvironment().getProperty("logs.dir"));
		logger.info("app.name=" + appCtx.getEnvironment().getProperty("app.name"));
		logger.info("apServer.type=" + appCtx.getEnvironment().getProperty("apServer.type"));
		
		logger.info("----------------------- End SpringContextListener -----------------------");
	}

}
