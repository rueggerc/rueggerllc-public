package com.rueggerllc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.rueggerllc.dataretriever.DataRetriever;
import com.rueggerllc.dataretriever.DataRetrieverFactory;

@WebServlet("/downloadServlet")
public class DownloadServlet extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DownloadServlet.class);
	
	public DownloadServlet() {
		super();
	}   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		try {
			String type = request.getParameter("type");
			String idString = request.getParameter("id");
			DataRetriever dataRetriever = DataRetrieverFactory.getDataRetriever(type);
			byte[] data = dataRetriever.getData(response,idString);
			final ServletOutputStream os = response.getOutputStream();
			os.write(data);
			os.flush();
		} catch (Exception e) {
			logger.error("ERROR:\n" + e);
			throw new ServletException(e);
		}
	}  
}
