package com.rueggerllc.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.rueggerllc.util.Constants;

@WebServlet("/downloadServlet")
public class DownloadServlet extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DownloadServlet.class);
	
	public DownloadServlet() {
		super();
	}   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			logger.info("Download File=" + name);
			
			final Path source = Paths.get(Constants.IMAGES_DIR + name);
			long size = Files.size(source);
			
			response.setContentType("image/jpeg");
			response.setContentLength((int)size);
			// response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
			byte[] data = Files.readAllBytes(source);
			
			// Write file to output
			final ServletOutputStream os = response.getOutputStream();
			os.write(data);
			os.flush();
		} catch (Exception e) {
			logger.error("ERROR:\n" + e);
			throw new ServletException(e);
		}
	}  

}
