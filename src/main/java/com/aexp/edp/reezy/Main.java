package com.aexp.edp.reezy;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;

public class Main {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		WebAppContext context = new WebAppContext();

		context.setInitParameter("resteasy.resources", "com.aexp.edp.reezy.Resource");
		context.setInitParameter("javax.ws.rs.Application", "com.aexp.edp.reezy.Config");
		
		context.setResourceBase("src/main/webapp");
		context.setContextPath("/");

		context.setParentLoaderPriority(true);            
		
		context.addEventListener(new ResteasyBootstrap());

		server.setHandler(context);

		server.start();
		server.join();
	}
}
