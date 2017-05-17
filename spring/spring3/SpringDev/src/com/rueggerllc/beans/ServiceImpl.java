package com.rueggerllc.beans;

public class ServiceImpl {
	
	private RequiredImpl required;
	private OptionalImpl optional;

	public ServiceImpl(RequiredImpl requiredImpl) {
		this.required = requiredImpl;
	}

	public OptionalImpl getOptional() {
		return optional;
	}

	public void setOptional(OptionalImpl optional) {
		this.optional = optional;
	}

  	
}
