package com.rueggerllc.beans;

import java.net.URI;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.rueggerllc.enums.LinkType;

// @XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "link", namespace = "http://rest.rueggerllc.com")
public class Links extends DomainTransferObjectCollection<Link> {

	private static final long serialVersionUID = 6616443126942744611L;
	
	public Links()
	{}
	
	
	@XmlElement(namespace = "http://rest.rueggerllc.com")
	public Collection<Link> getLink() {
		return this;
	}
	
	public void add(LinkType relationship, URI linkURI) {
		if (linkURI == null) {
			return;
		}
		Link link = new Link();
		link.setRelationship(relationship.toString());
		link.setValue(linkURI.toString());
		this.add(link);
	}
	
}
