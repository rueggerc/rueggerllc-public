package com.rueggerllc.mock;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.rueggerllc.beans.Book;
import com.rueggerllc.beans.Books;

public class BookDelegate {
	
	private static final Logger logger = Logger.getLogger(BookDelegate.class);
	
	public Books getBooks() {
		return createBooks();
	}
	
	
	private  Books createBooks() {
		String titles[] = 
			{"War and Peace",
			 "Wise Investor",
			 "John Adams",
			 "HuckleBerry Finn",
			 "Mythical Man Month",
			 "Catcher in the Rye",
			 "1984",
			 "To Kill a Mockingbird",
			 "Great Gatsby",
			 "Gone with the Wind",
			 "1776",
			 "The Tudors",
			 "Java Programming",
			 "Teddy Roosevelt",
			 "Think And Grow Rich",
			 "How to win friends and influence people",
			 "The truth about money",
			 "Foo and the Bars"
			};
		Books books = new Books();
		logger.info("TITLES=" + titles);
		for (int i = 0; i < titles.length; i++) {
			Book book = new Book();
			book.setId(""+i);
			book.setTitle(titles[i]);
			book.setNumberOfPages(311+i);
			book.setPublicationDate(getNow());
			books.add(book);
		}
		return books;
	}
	
	private static Date getNow() {
		return Calendar.getInstance().getTime();
	}

}
