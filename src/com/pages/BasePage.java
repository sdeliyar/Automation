package com.pages;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import library.UtilityLibrary;

public class BasePage {

	public static WebDriver driver;
	public static UtilityLibrary ul;
	
	
//	@BeforeClass
//	public void beforeAll() {
//		ul.executeBatFile("");
//		
//		
//	}
	@Before
	public void beforeTest() {

		try {
			ul = new UtilityLibrary(driver);
			driver = ul.start_Firefox_IE_Chrome("ie");
			// remote start
			//driver = ul.startRemoteFirefoxBrowser("http://192.168.1.48:4444/wd/hub");
			
			
			System.out.println("Test Start :");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	@After
	public void afterTest() {

		System.out.println("test end");
//		driver.close();
//		driver.quit();
	}

}
