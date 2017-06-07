package com.rueggerllc.mongodb.beans;

import java.util.Date;

public class BookBean {
	
	private String title;
	private int numberOfPages;
	private Date publishDate;
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Book.title: " + title);
		buffer.append("\nBook.numberOfPages: " + numberOfPages);
		buffer.append("\nBook.publishDate: " + publishDate);
		return buffer.toString();
	}
	
	
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
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	


}
