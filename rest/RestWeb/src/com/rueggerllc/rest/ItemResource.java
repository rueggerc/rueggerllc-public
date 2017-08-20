package com.rueggerllc.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.rueggerllc.beans.Item;

@Path("/items")
public class ItemResource {
	
	private static Logger logger = Logger.getLogger(ItemResource.class);
	
	
	@GET
	@Path("items")
	@Produces({"application/json"})
	public List<Item> fetchItems(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("--Retrieving Items---");
		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setName("Tampa Bay Item");
		items.add(item);
		return items;
	}
	
	
	
	
}
