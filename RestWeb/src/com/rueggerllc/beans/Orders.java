package com.rueggerllc.beans;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// @XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "orders", namespace = "http://rest.rueggerllc.com")
public class Orders extends DomainTransferObjectCollection<Order> {

	private static final long serialVersionUID = 6616443126942744611L;
	
	public Orders()
	{}
	
	
	@XmlElement(namespace = "http://rest.rueggerllc.com")
	public Collection<Order> getOrder() {
		return this;
	}
	
}
