package co.simplon.web;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class SessionCounterListener implements ServletContextListener {

  private static final Logger LOG=Logger.getLogger(SessionCounterListener.class.getName());
	

	
  @Override
  public void contextInitialized(ServletContextEvent sce) {
	LOG.log(Level.INFO,"started ");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
	  LOG.log(Level.INFO,"stopped");
  }	
}