package com.rueggerllc.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "pet", namespace = "http://rest.rueggerllc.com")
public class PetTransferObject extends DomainTransferObject {
	
	@XmlElement
	private String name;
	
	@XmlElement
	private String species;
	
	@XmlElement
	private double weight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	


}
