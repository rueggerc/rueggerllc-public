package com.rueggerllc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.rueggerllc.beans.Order;
import com.rueggerllc.beans.Orders;
import com.rueggerllc.util.OrderLinkBuilder;

@Path("/orders")
public class OrderResource {
	
	private static Logger logger = Logger.getLogger(OrderResource.class);
	private static Orders orders = getOrders();
	
	
	@GET
	@Path("orders")
	@Produces({ "application/xml", "application/json" })
	public Orders fetchOrders(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("--Retrieving Orders---");
		OrderLinkBuilder linkBuilder = new OrderLinkBuilder();
		linkBuilder.buildLinks(orders, uriInfo);
		return orders;
	}
	
	@GET
	@Path("orders/id/{orderId}")
	@Produces({ "application/xml", "application/json" })
	public Order fetchOrder(@PathParam("orderId") String orderId, @Context UriInfo uriInfo, @Context HttpHeaders headers) { 
		logger.info("Retrieving Order: " + orderId);
		Order order = null;
		for (Order nextOrder : orders) {
			if (nextOrder.getId().equals(orderId)) {
				order = nextOrder;
				break;
			}
		}
		if (order != null) {
			OrderLinkBuilder linkBuilder = new OrderLinkBuilder();
			linkBuilder.buildLinks(order, uriInfo);
		}
		return order;
	}
	
	
	
	private static Orders getOrders() {
		if (orders == null) {
			orders = new Orders();
			for (int i = 0; i < 10; i++) {
				Order order = new Order();
				order.setId(""+i);
				order.setItemNumber(""+i+311);
				order.setConfirmationNumber(""+i+42);
				order.setQuantity(i+10);
				orders.add(order);	
			}
		}
		return orders;
		
	}
	

	
	
	
}
