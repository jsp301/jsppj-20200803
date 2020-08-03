package jdbc;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DBCPInitListener
 *
 */
@WebListener
public class DBCPInitListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBCPInitListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	// 어떤 코드보다 먼저 실행된다.
    	 String poolConfig =
        		 sce.getServletContext().getInitParameter("poolConfig");
         Properties prop = new Properties();
         
         
         try {
        	 prop.load(new StringReader(poolConfig));
         } catch (IOException e) {
        	e.printStackTrace();
			throw new RuntimeException("config load fail", e);
		}
         
         
         loadJDBCDriver(prop);
         initConnectionPool(prop);



    }

	private void loadJDBCDriver(Properties prop) {
		
		
	}

	private void initConnectionPool(Properties prop) {
		
		
	}
	
}
