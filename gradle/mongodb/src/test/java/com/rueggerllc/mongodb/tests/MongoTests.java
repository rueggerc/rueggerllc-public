package com.rueggerllc.mongodb.tests;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


import org.hamcrest.collection.IsEmptyCollection;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoTests {
	
	private static final Logger logger = Logger.getLogger(MongoTests.class);
	
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
	public void testListBuiltCorrectly() {
		try {
			List<String> myList = new ArrayList<String>();
			myList.add("foo");
			myList.add("bar");
			myList.add("Fred");
			// assertEquals(myList.size(), 3);
			assertThat(myList, hasSize(3));
			System.out.println("List OK!");
		} catch (Exception e) {
			System.out.println("Error=" + e);
		}
	}
	
	
	
	
	@Test
	@Ignore
	public void writeDocument() {
		try {
			logger.info("Write Document Begin");
			
			// MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
			// MongoClient mongoClient = new MongoClient(connectionString);
			
			MongoClient mongoClient = new MongoClient();
			logger.info("Connected to Mongo");
			
			MongoDatabase database = mongoClient.getDatabase("rueggerllc");
			
			// Get a Collection
			MongoCollection<Document> collection1 = database.getCollection("collection1");
			
			
			// Create A Document
			Document doc = new Document("name", "MongoDB")
	                .append("type", "database")
	                .append("count", 1)
	                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
	                .append("info", new Document("x", 203).append("y", 102));
			
			collection1.insertOne(doc);
			
			logger.info("Insert Done");
			
			
		} catch (Exception e) {
			logger.error("ERROR", e);
		}
	}
	
	@Test
	@Ignore
	public void readCollection() {
		try {
			logger.info("Read Collection Begin");
			
			
			MongoClient mongoClient = new MongoClient();
			logger.info("Connected to Mongo");
			
			MongoDatabase database = mongoClient.getDatabase("rueggerllc");
			
			// Get a Collection
			MongoCollection<Document> collection1 = database.getCollection("collection1");
			
			// Document document = collection1.find().first();
			// logger.info("Document=\n" + document.toJson());
			
			MongoCursor<Document> cursor = collection1.find().iterator();
		    while (cursor.hasNext()) {
		        logger.info("Next Document=\n" + cursor.next().toJson());
		    }
		    cursor.close();
			
			
		} catch (Exception e) {
			logger.error("ERROR", e);
		}
	}

	
}
