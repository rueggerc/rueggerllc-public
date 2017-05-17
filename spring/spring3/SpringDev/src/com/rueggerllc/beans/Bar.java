package com.rueggerllc.beans;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;

public class Bar {
	
	private static Logger logger = Logger.getLogger(Bar.class);

	private String name = "Fred";
	private Foo foo;
	private Chris chris;


	public Foo getFoo() {
		return foo;
	}

	@PostConstruct
	void init() {
		logger.info("PostConstruct init() Method Called");
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Chris getChris() {
		return chris;
	}

	public void setChris(Chris chris) {
		this.chris = chris;
	}
  	
}
