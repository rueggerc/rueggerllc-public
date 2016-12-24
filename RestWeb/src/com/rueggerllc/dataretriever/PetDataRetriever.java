package com.rueggerllc.dataretriever;

import javax.servlet.http.HttpServletResponse;

import com.rueggerllc.beans.Pet;
import com.rueggerllc.beans.PetDetails;
import com.rueggerllc.delegates.PetDelegate;

public class PetDataRetriever implements DataRetriever {
	
	public byte[] getData(HttpServletResponse response, String idString) {
		try {
			PetDelegate delegate = new PetDelegate();
			Pet pet = delegate.getPet(idString);
			PetDetails petDetails = pet.getPetDetails();
			response.setContentType(petDetails.getMimeType());
			final byte[] data = petDetails.getData();
			response.setContentLength(data.length);
			return data;
		} catch (Exception e) {
			return new byte[0];
		}
	}

}
