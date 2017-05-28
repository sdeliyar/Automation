package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ExtrasPage extends BasePage {
	
	public Actions action;
	public void finishExtras() {
		
//		action = new Actions(driver);
		
		ul.fluentWait(By.cssSelector("div[id='finishbtn']")).click();
		
	}
	
}
