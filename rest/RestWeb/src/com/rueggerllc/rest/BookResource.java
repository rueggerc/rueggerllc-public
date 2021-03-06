package com.rueggerllc.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.rueggerllc.beans.Book;
import com.rueggerllc.beans.Books;
import com.rueggerllc.mock.BookDelegate;
import com.rueggerllc.util.BookLinkBuilder;
import com.sun.jersey.spi.resource.Singleton;

@Path("/books")
@Singleton
public class BookResource {
	
	private static Logger logger = Logger.getLogger(BookResource.class);
	private BookDelegate bookDelegate = new BookDelegate();
	private Books books = null;
	
	public BookResource() {
		logger.info("===== Creating BookResource ======");
	}

	
	@GET
	@Path("books")
	@Produces({MediaType.APPLICATION_XML,  MediaType.APPLICATION_JSON})
	public Books getBooks(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("--Retrieving Books---");
		return bookDelegate.getBooks();
	}
	
	@GET
	@Path("booklist")
	@Produces({MediaType.APPLICATION_XML,  MediaType.APPLICATION_JSON})
	public List<Book> getBookList(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("--Retrieving Book List---");
		Book book = new Book();
		book.setTitle("Churchhill!");
		book.setNumberOfPages(333);
		book.setPublicationDate(Calendar.getInstance().getTime());
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(book);
		return bookList;
		// return bookDelegate.getBooks();
	}
	
	@GET
	@Path("book/id/{bookId}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Book getBook(@PathParam("bookId") String bookId, @Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("======== Retrieving Book " + bookId + " ==============");
		Book book = fetchBook(bookId);
		if (book != null) {
			BookLinkBuilder linkBuilder = new BookLinkBuilder();
			linkBuilder.buildLinks(book, uriInfo);
		}
		return book;
	}
	
	
	@POST
	@Path("/book")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Book createBook(Book bookInput, @Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("Create Book BEGIN");
		logger.info("Input Book=\n" +bookInput);
		return bookDelegate.createBook(bookInput);
	}
	
	
	@PUT
	@Path("/book/id/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Book updateBook(Book bookInput, @Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("Update Book From=\n" +bookInput);
		Book bookToUpdate = fetchBook(bookInput.getId());
		bookToUpdate.setTitle(bookInput.getTitle());
		bookToUpdate.setNumberOfPages(bookInput.getNumberOfPages());
		bookToUpdate.setPublicationDate(bookInput.getPublicationDate());
		return bookToUpdate;
	}
	
	@DELETE
	@Path("/book/id/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response deleteBook(@PathParam("id") String id, @Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("Delete Book BEGIN: " + id);
		deleteBook(id);
		return Response.noContent().build();
	}
	

	
	private void deleteBook(String bookId) {
		Book book = fetchBook(bookId);
		books.remove(book);
	}
	
	private Book fetchBook(String bookId) {
		return bookDelegate.fetchBook(bookId);
	}

	
	
}
