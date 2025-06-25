package com.gn.common.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestLoggerListener
 *
 */
@WebListener
public class RequestLoggerListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestLoggerListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("새로운 요청이 들어왔습니다 !");
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("요청이 처리되었습니다.");
    }
	
}
