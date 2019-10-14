package study.spring.mvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context Initialized Listener");
		sce.getServletContext().setAttribute("name", "younsoo");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context Destroyed Listener");
	}
}
