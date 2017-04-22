package com.rueggerllc.util;

import java.net.URI;

import javax.ws.rs.core.UriInfo;

import com.rueggerllc.beans.Links;
import com.rueggerllc.beans.Book;
import com.rueggerllc.beans.Books;
import com.rueggerllc.enums.LinkType;

public class BookLinkBuilder extends LinkBuilder<Books,Book> {
	
	@Override
	protected void addRelatedLinks(Links links, UriInfo uriInfo, Book book) {
		// URI itemURI = uriInfo.getBaseUriBuilder().path("items").path("item").path("id").path(String.valueOf(book.getItemNumber())).build();
	    // links.add(LinkType.RELATED, itemURI);
	}
	
	@Override
	protected URI buildSelfURI(UriInfo uriInfo, Book book) {
		return uriInfo.getBaseUriBuilder().path("books").path("book").path("id").path(String.valueOf(book.getId())).build();
	}

}
