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
	public void testInsertPet1() throws Exception {
		try {
			File file = new File("D://Pics/Pets//resized//captain_448x600.jpg");
			FileInputStream is = new FileInputStream(file);
			Pet pet = new Pet();
			pet.setName("Captain");
			 
			PetDetails petDetails = new PetDetails();
			pet.setPetDetails(petDetails);
		
			petDetails.setDescription("Captain The Dog");
			byte[] dataArray = new byte[(int)file.length()];
			int numberBytes = is.read(dataArray);
			petDetails.setData(dataArray);
			petDetails.setLength(dataArray.length);
			petDetails.setMimeType("image/jpeg");
			petDetails.setFileName("captain.jpg");
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
	public void testInsertPet2() throws Exception {
		try {
			File file = new File("D://Pics/Pets//resized//darwin_450x600.jpg");
			FileInputStream is = new FileInputStream(file);
			Pet pet = new Pet();
			pet.setName("Darwin");
			 
			PetDetails petDetails = new PetDetails();
			pet.setPetDetails(petDetails);
		
			petDetails.setDescription("Darwin the Bird");
			byte[] dataArray = new byte[(int)file.length()];
			int numberBytes = is.read(dataArray);
			petDetails.setData(dataArray);
			petDetails.setFileName("darwin.jpg");
			petDetails.setLength(dataArray.length);
			petDetails.setMimeType("image/jpeg");
			Date now = new Date(System.currentTimeMillis());
			petDetails.setBirthDate(now);
			petDetails.setSpecies("Bird");
			petDetails.setAge(5);
			petDetails.setWeight(0.5);
			petDetails.setColor("Multi");
			
			PetDao dao = new PetDaoImpl();
			dao.save(pet);
			logger.info("Added Pet:"  + pet.getId());
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	@Test
	@Ignore
	public void testInsertPet3() throws Exception {
		try {
			File file = new File("D://Pics/Pets//resized//oscar_450x600.jpg");
			FileInputStream is = new FileInputStream(file);
			Pet pet = new Pet();
			pet.setName("Oscar");
			 
			PetDetails petDetails = new PetDetails();
			pet.setPetDetails(petDetails);
		
			petDetails.setDescription("Oscar The Cat");
			byte[] dataArray = new byte[(int)file.length()];
			int numberBytes = is.read(dataArray);
			petDetails.setData(dataArray);
			petDetails.setLength(dataArray.length);
			petDetails.setMimeType("image/jpeg");
			Date now = new Date(System.currentTimeMillis());
			petDetails.setBirthDate(now);
			petDetails.setSpecies("Feline");
			petDetails.setAge(6);
			petDetails.setWeight(8);
			petDetails.setColor("Grey");
			
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
