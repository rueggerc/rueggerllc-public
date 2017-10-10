package com.rueggerllc.rest.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rueggerllc.rest.beans.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping(value="/foobar",
//    		        method=RequestMethod.GET,
//    		        produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//    public Greeting foobar(@RequestParam(value="name", defaultValue="World") String name) {
//        System.out.println("GreetingController.foobar()");
//    	return new Greeting(counter.incrementAndGet(),String.format(template, name));
//    }

	@RequestMapping(value = "/foobar", 
			        method = RequestMethod.GET)
	public Greeting foobar(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("GreetingController.foobar()");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
    

    
    
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.println("GreetingController.greeting()");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
}