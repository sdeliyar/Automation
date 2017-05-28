package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class PasscodePage extends BasePage {

	public Actions action;

	public void passCode(String passcode) throws Exception {

		action = new Actions(driver);
		String[] eachPass = passcode.split("");

		for (int j = 0; j < 2; j++) {

			for (int i = 0; i < 4; i++) {

				String passElem = "div[id='b" + eachPass[i] + "']";
				action.click(ul.fluentWait(By.cssSelector(passElem))).build().perform();

			}
			action.click(ul.fluentWait(By.cssSelector("div[class='gpenterbtnblink']"))).build().perform();
			ul.customWait(2);
		}

	}
}
