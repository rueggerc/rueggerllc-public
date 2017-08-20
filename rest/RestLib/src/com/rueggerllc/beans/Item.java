package com.rueggerllc.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "book", namespace = "http://rest.rueggerllc.com")
public class Item {
	
	@XmlElement
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Item.name: " + name);
		return buffer.toString();
	}
	

}
