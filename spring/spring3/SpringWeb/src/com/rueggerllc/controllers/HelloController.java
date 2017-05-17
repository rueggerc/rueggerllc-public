package com.rueggerllc.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rueggerllc.servicebeans.ServiceBean;

@Controller
public class HelloController {
	
	private static Logger logger = Logger.getLogger(HelloController.class);
	private ServiceBean serviceBean;
	
	@RequestMapping("/welcome")
	public String printWelcome(ModelMap model) {
		logger.info("Printing Hello Message...");
		logger.info("Service Bean Name=" + serviceBean.getName());
		model.addAttribute("message", "Spring 3 From the Hello Controller!");
		return "hello";
	}

	public ServiceBean getServiceBean() {
		return serviceBean;
	}

	// Wire up the controller to beans in the business layer.
	// Note: the controller is NOT configured in a Spring config file.
	@Autowired
	public void setServiceBean(ServiceBean serviceBean) {
		this.serviceBean = serviceBean;
	}
	
	

	

}
