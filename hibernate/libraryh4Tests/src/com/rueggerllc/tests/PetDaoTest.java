package com.rueggerllc.tests;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.rueggerllc.beans.Pet;
import com.rueggerllc.beans.PetDetails;
import com.rueggerllc.daos.PetDao;
import com.rueggerllc.daos.PetDaoImpl;

public class PetDaoTest {
	
	private static Logger logger = Logger.getLogger(PetDaoTest.class);
	
	private static String[] species = {"Canine", "Feline", "Bird"};
	private static String[] colors = {"White", "Black", "Golden", "Orange"};
	
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
	// @Ignore
	public void dummyTest() {
		logger.info("Inside Dummy Test");
	}
	
	
	@Test
	// @Ignore
	public void testInsertPets() throws Exception {
		try {
	
			for (int i = 0; i < 100; i++) {
				Pet pet = new Pet();
				pet.setName("Pet" + i);
				PetDetails petDetails = new PetDetails();
				pet.setPetDetails(petDetails);
				petDetails.setDescription("Pet Description" + i);
				Date now = new Date(System.currentTimeMillis());
				petDetails.setBirthDate(now);
				petDetails.setSpecies(species[i%species.length]);
				petDetails.setAge(i%10 + 1);
				petDetails.setWeight(i%75+1);
				petDetails.setColor(colors[i%colors.length]);
				
				PetDao dao = new PetDaoImpl();
				dao.save(pet);
				logger.info("Added Pet:"  + pet.getId());
			}
			
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	@Test
	@Ignore
	public void testInsertPet1() throws Exception {
		try {
			Pet pet = new Pet();
			pet.setName("Captain");
			 
			PetDetails petDetails = new PetDetails();
			pet.setPetDetails(petDetails);
		
			petDetails.setDescription("Captain The Dog");
			Date now = new Date(System.currentTimeMillis());
			petDetails.setBirthDate(now);
			petDetails.setSpecies("Canine");
			petDetails.setAge(8);
			petDetails.setWeight(75.0);
			petDetails.setColor("Golden");
			
			PetDao dao = new PetDaoImpl();
			dao.save(pet);
			logger.info("Added Pet:"  + pet.getId());
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	
	
	@Test
	// @Ignore
	public void testRetrievePets() throws Exception {
		logger.info("Retrieve Pets Test");
		PetDao dao = new PetDaoImpl();
		List<Pet> pets = dao.findAll(Pet.class);
		logger.info("Retrieved Pets:" + pets.size());
		for (Pet pet : pets) {
			logger.info("Got Pet: "  + pet.getName());
		}
	}
	
	

}
