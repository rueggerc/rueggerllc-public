package com.rueggerllc.mock;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import org.apache.log4j.Logger;

import com.rueggerllc.beans.Book;
import com.rueggerllc.beans.Books;
import com.rueggerllc.util.BookComparator;

public class BookDelegate {
	
	private static final Logger logger = Logger.getLogger(BookDelegate.class);
	private Books books;
	
	public BookDelegate() {
		createBooks();
	}
	
	public Books getBooks() {
		Collections.sort(books, new BookComparator());
		return books;
	}
	
	public Book createBook(Book bookInput) {
		Book newBook = new Book();
		newBook.setId(""+ books.size());
		newBook.setTitle(bookInput.getTitle());
		newBook.setNumberOfPages(bookInput.getNumberOfPages());
		newBook.setPublicationDate(bookInput.getPublicationDate());
		books.add(newBook);
		return newBook;
	}
	
	public Book fetchBook(String bookId) {
		for (Book book : books) {
			if (book.getId().equals(bookId)) {
				return book;
			}
		}
		return null;
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
		books = new Books();
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
