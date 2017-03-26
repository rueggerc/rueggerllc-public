package com.rueggerllc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HelloServlet.class);
	
	public HelloServlet() {
		super();
	}   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		try {
			logger.info("---- HelloServlet Begin ----");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Hello Servlet</h1>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			logger.error("ERROR:\n" + e);
			throw new ServletException(e);
		}
	}  
}
