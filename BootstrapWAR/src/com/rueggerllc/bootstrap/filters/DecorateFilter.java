package com.rueggerllc.bootstrap.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class DecorateFilter implements Filter {
	
	private static final Logger logger = Logger.getLogger(DecorateFilter.class);
	private static final String ALREADY_EXECUTED = "alreadyExecuted";
	
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			
		} catch (Exception e) {
			
		}
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		logger.debug("--- Decorate Filter BEGIN");
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		// HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		String path = httpServletRequest.getServletPath();
		logger.debug("Path=" + path);
		
		try {
			if ((Boolean.TRUE.equals(request.getAttribute(ALREADY_EXECUTED)) == true) &&
				(path.equals(request.getAttribute(DecorateFilter.class.getName()))) == true) {
				logger.info("Already Executed");
				chain.doFilter(request, response);
				return;
			}
			
			ByteArrayHttpServletResponseWrapper responseWrapper = null;
			if (response instanceof ByteArrayHttpServletResponseWrapper) {
				responseWrapper = (ByteArrayHttpServletResponseWrapper)response;
			} else {
				responseWrapper = new ByteArrayHttpServletResponseWrapper((HttpServletResponse)response);
			}
			
			request.setAttribute(ALREADY_EXECUTED, Boolean.TRUE);
			request.setAttribute(DecorateFilter.class.getName(), path);
			
			// Process Request
			chain.doFilter(request, responseWrapper);
			
			// Modify the Response
			String headContent = "<span>Head Content</span>";
			String bodyContent = "<span>Body Content</span>";
			
			responseWrapper.insertContent(headContent, bodyContent);
			
		} catch (Exception e) {
			logger.error("Error", e);
		}
		
	}

	@Override
	public void destroy() {
	}

}
