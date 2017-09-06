package com.pages;

import org.openqa.selenium.By;

import library.JavaPropertiesManager;

public class PasscodePage extends BasePage {

	private String passcode;

	public void passCode() throws Exception {
		// test Data
		property = new JavaPropertiesManager("resources/testData.properties");
		passcode = property.readProperty("PassCode");

		String[] eachPass = passcode.split("");

		for (int j = 0; j < 2; j++) {

			for (int i = 0; i < 4; i++) {

				String passElem = "div[id='b" + eachPass[i] + "']";
				ul.highlightElement(By.cssSelector(passElem));
				ul.fluentWait(By.cssSelector(passElem)).click();

			}
			ul.highlightElement(By.cssSelector("div[class='gpenterbtnblink']"));
			ul.fluentWait(By.cssSelector("div[class='gpenterbtnblink']")).click();
			ul.customWait(1);
		}

	}
}
