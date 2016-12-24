package com.rueggerllc.util;

import java.net.URI;

import javax.ws.rs.core.UriInfo;

import com.rueggerllc.beans.Links;
import com.rueggerllc.beans.Order;
import com.rueggerllc.beans.Orders;
import com.rueggerllc.enums.LinkType;

public class OrderLinkBuilder extends LinkBuilder<Orders,Order> {
	
	@Override
	protected void addRelatedLinks(Links links, UriInfo uriInfo, Order order) {
		URI itemURI = uriInfo.getBaseUriBuilder().path("items").path("item").path("id").path(String.valueOf(order.getItemNumber())).build();
	    links.add(LinkType.RELATED, itemURI);
	}
	
	@Override
	protected URI buildSelfURI(UriInfo uriInfo, Order order) {
		return uriInfo.getBaseUriBuilder().path("orders").path("order").path("id").path(String.valueOf(order.getId())).build();
	}

}
