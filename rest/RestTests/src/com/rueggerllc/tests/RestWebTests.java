package com.rueggerllc.tests;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.rueggerllc.beans.Order;
import com.rueggerllc.beans.Orders;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RestWebTests {
	
	private static Logger logger = Logger.getLogger(RestWebTests.class);
	
	// private static String serviceURI = "http://localhost:9080/RestWeb/rest/orders";
	// private static String orderServiceURI = "http://rueggerconsultingllc.com/RestWeb/rest/orders";
	private static String orderServiceURI = "http://localhost:8080/RestWeb/rest/orders";
	
	// Books
	private static String bookServiceURI = "http://localhost:8080/RestWeb/rest/books";
	// private static String bookServiceURI = "http://rueggerconsultingllc.com/RestWeb/rest/books";
	
	// Pets
	private static String petServiceURI = "http://localhost:8080/RestWeb/rest/pets";
	// private static String bookServiceURI = "http://rueggerconsultingllc.com/RestWeb/rest/books";
	
	
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
	public void testGetOrders() throws Exception {
		logger.info("Get Orders Begin");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		URI getURI = getOrderTargetURI("orders");
		Orders orders = client.resource(getURI).get(Orders.class);
		for (Order order : orders) {
			logger.info("Next Order\n" + order);
		}
	}
	
	@Test
	@Ignore
	public void testGetOrdersAsJSON() throws Exception {
		logger.info("Get Orders Begin");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		URI getURI = getOrderTargetURI("orders");
		String data = client.resource(getURI).accept("application/json").get(String.class);
		logger.info("DATA=\n" + data);
	}
		
	@Test
	@Ignore
	public void testGetSingleOrder() throws Exception {
		logger.info("Get Orders Begin");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		URI getURI = getOrderTargetURI("orders/id/1");
		String data = client.resource(getURI).accept("application/json").get(String.class);
		logger.info("DATA=\n" + data);
	}
	
	@Test
	@Ignore
	public void testGetBooksAsJSON() throws Exception {
		logger.info("Get Books Begin");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		URI getURI = getBookTargetURI("books");
		String data = client.resource(getURI).accept("application/json").get(String.class);
		logger.info("DATA=\n" + data);
		
		JSONArray books = new JSONArray(data);
		for (int i = 0; i < books.length(); i++) {
			JSONObject book = books.getJSONObject(i);
			String title = book.getString("title");
			logger.info("NEXT BOOK=" + title);
		}
	}
	
	
	@Test
	@Ignore
	public void testGetPetsJSON() throws Exception {
		logger.info("Get Pets Begin");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		URI getURI = getPetTargetURI("pets");
		String responseString = client.resource(getURI).accept("application/json").get(String.class);
		logger.info("ResponseString=\n" + responseString);
		
		JSONArray pets = new JSONArray(responseString);
		for (int i = 0; i < pets.length(); i++) {	
			logger.info("NEXT PET BEGIN");
			JSONObject nextPet = pets.getJSONObject(i);
			String name = nextPet.getString("name");
			String species = nextPet.getString("species");
			double weight = nextPet.getDouble("weight");
			logger.info("name=" + name);
			logger.info("species=" + species);
			logger.info("weight=" + weight);
			JSONArray links = nextPet.getJSONArray("link");
			for (int j = 0; j < links.length(); j++) {
				JSONObject nextLink = links.getJSONObject(j);
				String relationshipType = nextLink.getString("relationship");
				String value = nextLink.getString("value");
				logger.info("Link Type=" + relationshipType);
				logger.info("Value=" + value);
			}
			logger.info("NEXT PET END");
			// logger.info("Name=" + name);
			
		}
		
		
//		JSONObject response = new JSONObject(responseString);
//		JSONArray petArray = response.getJSONArray("pets");
//		for (int i = 0; i < petArray.length(); i++) {
//			logger.info("NEXT PET BEGIN");
//			JSONObject nextPet = petArray.getJSONObject(i);
//			String name = (String)nextPet.get("name");
//		}
		

	}
	

	@Test
	@Ignore
	public void testGetBookJSON() throws Exception {
		logger.info("Get Book Begin");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		URI getURI = getBookTargetURI("book/id/2");
		String data = client.resource(getURI).accept("application/json").get(String.class);
		logger.info("DATA=\n" + data);
	}
	
	private URI getOrderTargetURI(String path) {
		String orderURIValue = String.format("%s/%s", orderServiceURI, path);
		logger.info("Service URI=" + orderURIValue);
		URI orderURI = UriBuilder.fromUri(orderURIValue).build();
		return orderURI;
	}
	
	private URI getBookTargetURI(String path) {
		String bookURIValue = String.format("%s/%s", bookServiceURI, path);
		logger.info("Service URI=" + bookURIValue);
		URI orderURI = UriBuilder.fromUri(bookURIValue).build();
		return orderURI;
	}
	
	private URI getPetTargetURI(String path) {
		String bookURIValue = String.format("%s/%s", petServiceURI, path);
		logger.info("Service URI=" + bookURIValue);
		URI orderURI = UriBuilder.fromUri(bookURIValue).build();
		return orderURI;
	}
	
	

}
