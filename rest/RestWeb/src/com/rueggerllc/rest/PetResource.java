


package com.rueggerllc.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.rueggerllc.beans.Pet;
import com.rueggerllc.beans.PetDetails;
import com.rueggerllc.beans.PetTransferObject;
import com.rueggerllc.beans.PetsTransferObject;
import com.rueggerllc.delegates.PetDelegate;
import com.rueggerllc.util.PetLinkBuilder;

@Path("/pets")
public class PetResource {
	
	private static Logger logger = Logger.getLogger(PetResource.class);
	private PetDelegate delegate = new PetDelegate();
	
	@GET
	@Path("pets")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PetsTransferObject getPets(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		logger.info("--Retrieving Pets ---");
		PetsTransferObject pets = new PetsTransferObject();
		try {
			List<Pet> petList = delegate.getAllPets();
			for (Pet pet : petList) {
				PetDetails petDetails = pet.getPetDetails();
				PetTransferObject petTransferObject = new PetTransferObject();
				petTransferObject.setId(pet.getId());
				petTransferObject.setName(pet.getName());
				petTransferObject.setSpecies(petDetails.getSpecies());
				petTransferObject.setWeight(petDetails.getWeight());
				pets.add(petTransferObject);
			}
			
			PetLinkBuilder linkBuilder = new PetLinkBuilder();
			linkBuilder.buildLinks(pets, uriInfo);
			
			
		} catch (Exception e) {
			logger.error("Error Retriving Pets", e);
			return pets;
		}
	
		// Done
		return pets;
	}
	
	
	
}
