package com.rueggerllc.beans;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pets", namespace = "http://rest.rueggerllc.com")
public class PetsTransferObject extends DomainTransferObjectCollection<PetTransferObject> {

	private static final long serialVersionUID = -2610160377988191709L;


	public PetsTransferObject(){
	}
	
	@XmlElement(namespace = "http://rest.rueggerllc.com")
	public Collection<PetTransferObject> getPet() {
		return this;
	}
	
	@XmlAttribute
	public int getSize() {
		return super.size();
	}
	
}
