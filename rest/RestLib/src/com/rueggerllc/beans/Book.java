package com.rueggerllc.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Book Class
@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "book", namespace = "http://rest.rueggerllc.com")
public class Book extends DomainTransferObject {
	
	@XmlElement
	private String title;
	
	@XmlElement
	private int numberOfPages;
	
	@XmlElement
	private Date publicationDate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Book.id: " + getId());
		buffer.append("\nBook.title: " + title);
		buffer.append("\nBook.numberOfPages: " + numberOfPages);
		buffer.append("\nBook.publicationDate: " + publicationDate);
		return buffer.toString();
	}
	

}
