package com.balajisiddi.servlets;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.beans.DesignMode;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.Chromaticity;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import java.util.logging.Logger;
import org.apache.log4j.Logger;

public class BookInsertionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;    
//	private static final Logger LOGGER = Logger.getLogger(BookInsertionServlet.class.getName());
	private static final Logger log= Logger.getLogger(BookInsertionServlet.class);
	
	public static String getBaseUrl(HttpServletRequest request) {    
		log.info("getting base url");
	    String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
	    return scheme + serverName + serverPort + contextPath;
	  }
	  
	@Override
	public void init() throws ServletException {
		log.info("loadonstartup working");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query="SELECT * FROM STUDENT WHERE ID=26";
		Statement stmt;
		try {        
			SystemTray tray= SystemTray.getSystemTray();
			Image image= Toolkit.getDefaultToolkit().createImage("D:\\WorkFromHome\\20200502\\image_rest.png");
			TrayIcon trayIcon= new TrayIcon(image, "Java demo icon");
			trayIcon.setImageAutoSize(true);
			trayIcon.setToolTip("System  tray icon demo");
			tray.add(trayIcon);
			trayIcon.displayMessage("Hello World", "Java Notification Demo", MessageType.INFO);
			//Create a map to store  preferences 
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			Connection con= (Connection) getServletContext().getAttribute("DBConnection");
			if(con!=null) {
				log.trace("Trace Message!");  
			    log.debug("Debug Message!");  
			    log.info("Info Message!");  
			    log.warn("Warn Message!");  
			    log.error("Error Message!");  
			    log.fatal("Fatal Message!");  
			}      
			stmt = con.createStatement();  
			ResultSet rs= stmt.executeQuery(query);   
			if(rs.next()){  
				log.info(rs.getString(7));
			}   
		} catch (Exception e) {  
			e.printStackTrace();
		}
	}
}
