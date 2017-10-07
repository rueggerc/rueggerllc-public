package com.rueggerllc.selenium.tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTests {

	private static Logger logger = Logger.getLogger(SeleniumTests.class);
	
	
	
	@BeforeClass
	public static void setupClass() throws Exception {
		System.setProperty("hadoop.home.dir", "C:/hadoop-2.7.4");
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
	@Ignore
	public void dummyTest() {
		logger.info("Inside Dummy Test");
	}
	
	@Test
	@Ignore
	public void testFirefox() {
		logger.info("Firefox Test Begin");
		try {
			// Create a new instance of the Firefox driver
			WebDriver driver = new FirefoxDriver();
			
	        //Launch the Online Store Website
			driver.get("http://www.store.demoqa.com");
	 
	        // Print a Log In message to the screen
			logger.info("===== Opened Page ====");
	 
			//Wait for 5 Sec
			Thread.sleep(5000);
			
	        // Close the driver
	        driver.quit();
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	@Test
	@Ignore
	public void testFirefox2() {
		logger.info("Firefox Test Begin");
		try {
			// Create a new instance of the Firefox driver
			WebDriver driver = new FirefoxDriver();
			
			// Run Tests
			runAccountTests(driver);
			
	        // Close the driver
	        driver.quit();
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	@Test
	// @Ignore
	public void testChrome() {
		logger.info("Chrome Test Begin");
		try {
			
			String exePath = "C:\\selenium\\chromedriver.exe";
			logger.info("Exe Path=" + exePath);
			System.setProperty("webdriver.chrome.driver", exePath);
			WebDriver driver = new ChromeDriver();
			
			runAccountTests(driver);
			
			
	        // Close the driver
	        driver.quit();
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
	
	private void runAccountTests(WebDriver driver) throws Exception {
		
		try {
		
	        //Launch the Online Store Website
			driver.get("http://localhost:8080/jsfWAR");
			
			WebElement element = driver.findElement(By.id("accountsForm:selectAccounts"));
			Select select = new Select(element);
			logger.info("Got Select");
			
			select.selectByValue("Account2");
	 
	        // Print a Log In message to the screen
			logger.info("===== Opened Page ====");
			
	
			//Wait for 5 Sec
			Thread.sleep(5000);
			
			// Push Continue Button
			WebElement submitButton = driver.findElement(By.id("accountsForm:btnContinue"));
			submitButton.click();
			
			//Wait for 5 Sec
			Thread.sleep(10000);
			

		} catch (Exception e) {
			logger.error("Error", e);
			throw e;
		}
		
		
	}
	
	
}
