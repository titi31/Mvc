package co.simplon.web;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
@WebListener
public class MySessionListener implements HttpSessionListener {
	private static final Logger LOG=Logger.getLogger(SessionCounterListener.class.getName());
	private int sessionCounter=0;

	
	  @Override
	  public void sessionCreated(HttpSessionEvent se) {
		 synchronized(this) {
			 sessionCounter++;
		 }
		LOG.log(Level.INFO,"session create-{0} ",sessionCounter);
	  }

	  @Override
	  public void sessionDestroyed(HttpSessionEvent se) {
		  synchronized(this) {
			  sessionCounter--;
		  }
		  LOG.log(Level.INFO,"session destroyed-{0}",sessionCounter);
	  }	

}
