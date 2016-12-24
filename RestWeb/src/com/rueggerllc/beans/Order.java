package com.rueggerllc.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "order", namespace = "http://rest.rueggerllc.com")
public class Order extends DomainTransferObject {
	
	@XmlAttribute
	private String itemNumber;
	
	@XmlElement
	private int quantity;
	
	@XmlElement 
	private String confirmationNumber;

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}
	

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Order.id: " + this.getId());
		buffer.append("\nOrder.itemNumber: " + this.getItemNumber());
		buffer.append("\nOrder.quantity: " + this.getQuantity());
		buffer.append("\nOrder.confirmationNumber: " + this.getConfirmationNumber());
		return buffer.toString();
		
	}
	
	


}
