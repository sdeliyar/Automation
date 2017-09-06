package com.pages;

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
	Pattern image21 = new Pattern("C:\\Screen\\Capture21.PNG");
	Pattern image21_1 = new Pattern("C:\\Screen\\Capture21_1.PNG");
	public void startServer() {

		ul.executeBatFile("C:\\Users\\KioskUser\\Desktop\\startKiosk&server.bat");
	}

	public void gotoWelcome() throws Exception {
		ul.customWait(2);

		driver.get("http://localhost:8080/");
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		
		
		ul.customWait(1);
		if (screen.exists(image21_1) != null) {
			Robot robot = new Robot();
			ul.customWait(1);
			robot.keyPress(KeyEvent.VK_F11);
			robot.keyRelease(KeyEvent.VK_F11);
		}

		ul.customWait(1);
	}

	public void logInAdmin() throws Exception {

		ul.customWait(2);
		action = new Actions(driver);
		ul.highlightElement(ul.fluentWait(By.cssSelector("img[class='gpLOGO']")));
		

		driver.findElement(By.cssSelector("img[class='gpLOGO']")).click();
		driver.findElement(By.cssSelector("img[class='gpLOGO']")).click();
		driver.findElement(By.cssSelector("img[class='gpLOGO']")).click();
		System.out.println(driver.getTitle());

	};

	public void logInAdmin_Sikuli() throws Exception {
		// Pattern imageLog = new
		// Pattern("C:/Users/dsaifuding/Desktop/screenshots/cutomer_notification/Sikuli/goPod.PNG");
		Pattern imageLog = new Pattern("C:/Users/dsaifuding/Desktop/screenshots/cutomer_notification/Sikuli/goPod.gif");

		screen.wait(imageLog);
		screen.click(imageLog);
		screen.doubleClick(imageLog);

	};

	public void clickHomePage() {
		
		ul.highlightElement(ul.fluentWait(By.xpath(".//div[@id='page']/div[1]/div[3]")));
		ul.fluentWait(By.xpath(".//div[@id='page']/div[1]/div[3]")).click();
	}

}
