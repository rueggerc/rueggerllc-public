package com.rueggerllc.bootstrap.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.log4j.Logger;

public class ByteArrayHttpServletResponseWrapper extends HttpServletResponseWrapper {
	
	private static final Logger logger = Logger.getLogger(ByteArrayHttpServletResponseWrapper.class);
	private final ByteArrayServletOutputStream outputStream = new ByteArrayServletOutputStream();
	private final PrintWriter writer = new PrintWriter(outputStream, true);

	public ByteArrayHttpServletResponseWrapper(HttpServletResponse response) {
		super(response);
	}
	
	
	@Override
	public ServletOutputStream getOutputStream() {
		return outputStream;
	}
	
	@Override
	public PrintWriter getWriter() {
		return writer;
	}
	
	// @Override
	public String toString() {
		return outputStream.toString();
	}
	
	public void insertContent(String headContent, String bodyContent) throws IOException {
		outputStream.flush();
		writer.flush();
		String response = outputStream.toString();
		
		if (response == null || response.trim().length() == 0) {
			return;
		}
		
		if (headContent != null) {
			response = insertIntoHead(response, headContent);
		}
		
		if (bodyContent != null) {
			response = insertIntoBody(response, bodyContent);
		}
		
		super.getWriter().write(response);
		super.getWriter().close();
	
	}
	
	private String insertIntoHead(String response, String contentToInsert) {
		
		if (response.matches("(?s)(?i).*</(\\s)*head(\\s)*>.*") == true) {
			return response.replaceFirst("(?s)(?i)</(\\s)*head(\\s)*>", "\n" +
					                     contentToInsert + "\n</head>");
		}
		return response;
	}
	
	private String insertIntoBody(String response, String contentToInsert) {
		if (response.matches("(?s)(?i).*</(\\s)*body(\\s)*>.*") == true) {
			return response.replaceFirst("(?s)(?i)</(\\s)*body(\\s)*>", "\n" +
					                     contentToInsert + "\n</body>");
		}
		return response;
	}
	
	

}
