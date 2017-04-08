package com.rueggerllc.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.rueggerllc.util.Constants;

@WebServlet("/uploadServlet")
@MultipartConfig
public class UploadServlet extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UploadServlet.class);
	
	public UploadServlet() {
		super();
	}   
	
	protected void doBoth(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		try {
			
			logger.info("Upload File BEGIN");
		    String description = request.getParameter("description"); 
		    Part filePart = request.getPart("file"); 
		    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		    long fileSize = filePart.getSize();
		    String contentType = filePart.getContentType();
		
		    logger.info("File Name=" + fileName);
		    logger.info("contentType=" + contentType);
		    logger.info("File size =" + fileSize);
		    
		    InputStream inputStream = filePart.getInputStream();
		    final Path destination = Paths.get(Constants.IMAGES_DIR + fileName);
		    Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
		    inputStream.close();
		    
		    logger.info("File Written");
		    
			
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		doBoth(request, response);
	}  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		doBoth(request, response);
	}  
	
	
}
