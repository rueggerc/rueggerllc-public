package com.rueggerllc.rest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.rueggerllc.beans.Book;
import com.rueggerllc.beans.Books;

@Path("/books")
public class BookResource {
	
	private static Logger logger = Logger.getLogger(BookResource.class);
	private static Books books = null;

	
	@GET
	@Path("books")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Books getBooks(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("--Retrieving Books---");
		Books books = getBooks();
		return books;
	}
	
	@GET
	@Path("book/id/{bookId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Book getBook(@PathParam("bookId") String bookId, @Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("======== Retrieving Book " + bookId + " ==============");
		Book book = new Book();
		book.setTitle("My Book");
		book.setNumberOfPages(732);
		book.setPublicationDate(getNow());
		return book;
	}
	
	
	private static Date getNow() {
		return Calendar.getInstance().getTime();
	}
	
	private static Books getBooks() {
		if (books == null) {
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
			logger.info("TITLES=" + titles);
			for (int i = 0; i < titles.length; i++) {
				Book book = new Book();
				book.setTitle(titles[i]);
				book.setNumberOfPages(311+i);
				book.setPublicationDate(getNow());
				books.add(book);
			}
		}
		return books;
	}
	
	
}
