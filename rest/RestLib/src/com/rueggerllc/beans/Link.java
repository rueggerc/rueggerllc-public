package com.rueggerllc.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "link", namespace = "http://rest.rueggerllc.com")
public class Link {
	
	@XmlAttribute
	private String relationship;
	
	@XmlAttribute
	private String value;
	
	public String getRelationship() {
		return relationship;
	}
	
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}
