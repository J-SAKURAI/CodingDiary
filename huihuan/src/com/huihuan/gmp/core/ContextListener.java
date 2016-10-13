package com.huihuan.gmp.core;

import javax.servlet.*;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.Constants;

public class ContextListener implements ServletContextListener {
	private ServletContext context = null;

	public void contextDestroyed(ServletContextEvent event) {
		// Output a simple message to the server's console
		System.out.println("The Huihuan Web App. Has Been Removed");
		this.context = null;
	}

	// 这个方法在Web应用服务做好接受请求的时候被调用。
	public void contextInitialized(ServletContextEvent event) {
		this.context = event.getServletContext();
		// Output a simple message to the server's console

		System.out.println("The Huihuan Web App. Is Ready");
	}

}
