package ua.com.periodical;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import ua.com.periodical.servlet.HomeServlet;

public class Main {

	public static void main(String[] args) {
		int port = 8080;
		Server server = new Server(port);
		ServletContextHandler context = new ServletContextHandler( ServletContextHandler.SESSIONS );
		context.setContextPath( "/" );
		context.addServlet(new ServletHolder( new HomeServlet() ),"/periodical");
		
		HandlerList handlers = new HandlerList( );
		handlers.setHandlers( new Handler[] { context } );
		server.setHandler( handlers );
		
		try {
			server.start();
			System.out.println("Listening port : " + port );
			server.join();
		} catch (Exception e) {
		    	System.out.println("Error.");
			e.printStackTrace();
		}

	}

}
