package com.rueggerllc.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(value = XmlAccessType.NONE)
// @XmlRootElement(name = "dto", namespace = "http://rest.rueggerllc.com")
public class DomainTransferObject {
	
	@XmlAttribute
	private String id;
	
	@XmlElement(name="link", namespace="http://rest.rueggerllc.com")
	private Links links;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Links getLinks() {
		return links;
	}
	
	public void setLinks(Links links) {
		this.links = links;
	}
	
	
}
