package com.rueggerllc.util;

import java.net.URI;
import java.net.URL;

import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.rueggerllc.beans.Links;
import com.rueggerllc.beans.PetTransferObject;
import com.rueggerllc.beans.PetsTransferObject;
import com.rueggerllc.enums.LinkType;

public class PetLinkBuilder extends LinkBuilder<PetsTransferObject,PetTransferObject> {
	
	private static final Logger logger = Logger.getLogger(PetLinkBuilder.class);
	
	@Override
	protected void addRelatedLinks(Links links, UriInfo uriInfo, PetTransferObject pet) {
		try {
		
			String base  = uriInfo.getBaseUri().toString();
			String restSegment = "/rest";
			String basePath = base.substring(0, base.indexOf(restSegment));
			String downloadServletPath = String.format("%s/downloadServlet?type=pet&id=%s", basePath, pet.getId());
			
			URL url = new URL(downloadServletPath);
			URI imageURI = url.toURI();
	
			links.add(LinkType.RELATED, imageURI);
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	@Override
	protected URI buildSelfURI(UriInfo uriInfo, PetTransferObject pet) {
		return uriInfo.getBaseUriBuilder().path("pets").path("pet").path("id").path(String.valueOf(pet.getId())).build();
	}

}
