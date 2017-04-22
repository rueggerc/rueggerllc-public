package com.rueggerllc.beans;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "books", namespace = "http://rest.rueggerllc.com")
public class Books extends DomainTransferObjectCollection<Book> {

	private static final long serialVersionUID = -2610160377988191709L;


	public Books()
	{}
	
	
	@XmlElement(namespace = "http://rest.rueggerllc.com")
	public Collection<Book> getBook() {
		return this;
	}
	
}
