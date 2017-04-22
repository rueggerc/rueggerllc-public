package com.rueggerllc.util;

import java.net.URI;

import javax.ws.rs.core.UriInfo;

import com.rueggerllc.beans.DomainTransferObject;
import com.rueggerllc.beans.DomainTransferObjectCollection;
import com.rueggerllc.beans.Links;
import com.rueggerllc.enums.LinkType;

public class LinkBuilder<Ts extends DomainTransferObjectCollection<T>, T extends DomainTransferObject> {
	
	public void buildLinks(Ts collection, UriInfo uriInfo) {
		for (T item : collection) {
			buildLinks(item,uriInfo);
		}
	}
	
	public void buildLinks(T item, UriInfo uriInfo) {
		Links links = new Links();
		item.setLinks(links);
		links.add(LinkType.SELF, buildSelfURI(uriInfo, item));
		addRelatedLinks(links, uriInfo, item);
	}
	
	protected void addRelatedLinks(Links links, UriInfo uriInfo, T item) {
	}
	
	protected URI buildSelfURI(UriInfo uriInfo, T item) {
		return null;
	}

}
