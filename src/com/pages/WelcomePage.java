package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class WelcomePage extends BasePage {
	private Actions action;
	private Screen screen = new Screen();
	
	public void startServer() {
		
		ul.executeBatFile("C:\\Users\\KioskUser\\Desktop\\startKiosk&server.bat");
	}
	public void gotoWelcome() throws Exception {
		//driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		ul.customWait(1);
		
		driver.get("http://localhost:8080/");
		
		//driver.findElement(By.tagName("body")).sendKeys(Keys.F11);
		
//		Robot robot = new Robot();
//		ul.customWait(1);
//		robot.keyPress(KeyEvent.VK_F11);
//		robot.keyRelease(KeyEvent.VK_F11);
		ul.customWait(1);
	}

	public void logInAdmin() throws Exception {

		ul.customWait(2);
		action = new Actions(driver);
		
		//action.moveToElement(driver.findElement(By.cssSelector("img[class='gpLOGO']"))).click().click().click().perform();
		driver.findElement(By.cssSelector("img[class='gpLOGO']")).click();
		driver.findElement(By.cssSelector("img[class='gpLOGO']")).click();
		driver.findElement(By.cssSelector("img[class='gpLOGO']")).click();
		System.out.println(driver.getTitle());

	};
	
	public void logInAdmin_Sikuli() throws Exception {
		//Pattern imageLog = new Pattern("C:/Users/dsaifuding/Desktop/screenshots/cutomer_notification/Sikuli/goPod.PNG");
		Pattern imageLog = new Pattern("C:/Users/dsaifuding/Desktop/screenshots/cutomer_notification/Sikuli/goPod.gif");

		
		
		screen.wait(imageLog);
		screen.click(imageLog);
		screen.doubleClick(imageLog);
		

	};
	public void clickHomePage() {
		//driver.findElement(By.cssSelector("div[class='col-md-12 gpbottom-column']")).click();
		ul.fluentWait(By.xpath(".//div[@id='page']/div[1]/div[3]")).click();
		//ul.fluentWait(By.xpath(".//div[@id='page']/div[1]/div[3]")).click();
		//driver.findElement(By.xpath(".//div[@id='page']/div[1]/div[3]")).click();
	}
	
	
}
