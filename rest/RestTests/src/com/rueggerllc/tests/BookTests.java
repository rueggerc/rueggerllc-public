package com.rueggerllc.tests;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.rueggerllc.beans.Book;
import com.rueggerllc.beans.Books;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class BookTests {
	
	private static Logger logger = Logger.getLogger(BookTests.class);
	
	
	// Books
	private static String bookServiceURI = "http://localhost:8080/RestWeb/rest/books";
	
	
	@BeforeClass
	public static void setupClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setupTest() throws Exception {
	}

	@After
	public void tearDownTest() throws Exception {
	}
	
	@Test
	@Ignore
	public void dummyTest() {
		logger.info("Inside Dummy Test");
	}
	
	
	@Test
	// @Ignore
	public void getPlatform() {
		Properties properties = System.getProperties();
		for (Enumeration e = properties.keys(); e.hasMoreElements();) {
			Object key = e.nextElement();
			Object value = properties.get(key);
			logger.info(key + "=" + value);
		}
		
		String osName = properties.getProperty("os.name");
		logger.info("Operationg System=" + osName);
		
	}
	
	@Test
	@Ignore
	public void testGetBooks() throws Exception {
		logger.info("Get Books BEGIN");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		URI getURI = getBookTargetURI("books");
		Books books = client.resource(getURI).get(Books.class);
		for (Book book : books) {
			logger.info("Next Book\n" + book);
		}
		logger.info("Get Books END");
		
	}
	


	@Test
	@Ignore
	public void testGetBookJSON() throws Exception {
		logger.info("Get Book as JSON Begin");
		String data = this.fetchBookJSON("2");
		logger.info("DATA=\n" + data);
	}
	
	
	@Test
	@Ignore
	public void testGetBook() {
		Book book = fetchBook("2");
		logger.info("Got Book=\n" + book);
	}
	
	@Test
	@Ignore
	public void testUpdateBook() {
		logger.info("Update Book Begin");
		String id = "1";
		Book book = fetchBook(id);
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		book.setNumberOfPages(422);
		URI putURI = getBookTargetURI("book/id/" + id);
		client.resource(putURI).put(book);
		book = fetchBook(id);
		logger.info("Updated Book=\n" + book);
	}
	
	
	@Test
	@Ignore
	public void testCreateBook() {
		logger.info("Create Book Begin");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		URI postURI = getBookTargetURI("book");
		
		Book newBook = new Book();
		newBook.setTitle("Ruegger Book");
		newBook.setNumberOfPages(5635);
		newBook.setPublicationDate(getNow());
		Book createdBook = client.resource(postURI).post(Book.class, newBook);
		logger.info("Created Book=\n" + createdBook);
	}
	
	
	@Test
	@Ignore
	public void testDeleteBook() {
		logger.info("Delete Book Begin");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		String id = "2";
		URI deleteURI = getBookTargetURI("book/id/"+id);
		client.resource(deleteURI).delete();
		logger.info("Book Deleted");
	
	}
	
	
	private Book fetchBook(String id) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		URI getURI = getBookTargetURI("book/id/"+id);
		Book book = client.resource(getURI).get(Book.class);
		return book;
	}
	
	
	private String fetchBookJSON(String id) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		URI getURI = getBookTargetURI("book/id/"+id);
		String data = client.resource(getURI).accept("application/json").get(String.class);
		return data;
	}
	
	
	
	private URI getBookTargetURI(String path) {
		String endpoint = String.format("%s/%s", bookServiceURI, path);
		logger.info("Service URI=" + endpoint);
		URI bookURI = UriBuilder.fromUri(endpoint).build();
		return bookURI;
	}
	
	private static Date getNow() {
		return Calendar.getInstance().getTime();
	}
	
	

}
