package com.rueggerllc.beans;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


// @XmlAccessorType(value = XmlAccessType.NONE)
// @XmlRootElement(namespace = "http://rest.rueggerllc.com")
public class DomainTransferObjectCollection<T> extends ArrayList<T>  {

	private static final long serialVersionUID = 5248552208982465554L;
	
//	@XmlAttribute
//	public int getSize() {
//		return super.size();
//	}
	
}
