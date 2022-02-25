package app.netlify.madduci.rest.server;

import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class Main {

  static {
    Security.addProvider(new BouncyCastleProvider());
  }

  public Main() {}

  public static void main(String[] args) throws Exception {
    try {
      new Main().run();
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }

  public void run() throws Exception {
    final String APPLICATION_PATH = System.getProperty("application.path", "");
    final String CONTEXT_ROOT = System.getProperty("context.root", "/");

    final int port = Integer.parseInt(System.getProperty("server.port", "8080"));
    final Server server = new Server(port);

    // Setup the basic Application "context" at "/".
    final ServletContextHandler contextHandler = new ServletContextHandler(server, CONTEXT_ROOT);

    // Setup RESTEasy's HttpServletDispatcher at "/*".
    final ServletHolder restEasyServlet = new ServletHolder(new HttpServletDispatcher());
    restEasyServlet.setInitParameter("resteasy.servlet.mapping.prefix", APPLICATION_PATH);
    restEasyServlet.setInitParameter(
        "jakarta.ws.rs.Application", ApplicationServer.class.getCanonicalName());
    contextHandler.addServlet(restEasyServlet, APPLICATION_PATH + "/*");

    // Setup the DefaultServlet at "/".
    final ServletHolder defaultServlet = new ServletHolder(new DefaultServlet());
    contextHandler.addServlet(defaultServlet, CONTEXT_ROOT);

    System.out.println("Starting server on port " + port);
    server.start();
    server.join();
  }
}
