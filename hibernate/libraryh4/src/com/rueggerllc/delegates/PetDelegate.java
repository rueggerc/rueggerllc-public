package com.rueggerllc.delegates;

import java.util.List;

import com.rueggerllc.beans.Pet;
import com.rueggerllc.daos.PetDao;
import com.rueggerllc.daos.PetDaoImpl;

public class PetDelegate {
	
	private PetDao dao = new PetDaoImpl();
	
	public List<Pet> getAllPets() throws Exception {
		List<Pet> pets = dao.findAll(Pet.class);
		return pets;
	}
	
	public Pet getPet(String id) throws Exception {
		Pet pet = dao.read(Pet.class, id);
		return pet;
	}
	
	public void save(Pet pet) throws Exception {
		dao.save(pet);
	}

}
