package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ExtrasPage extends BasePage {
	
	public Actions action;
	public void finishExtras() {
		
//		action = new Actions(driver);
		ul.highlightElement(By.cssSelector("div[id='finishbtn']"));
		ul.fluentWait(By.cssSelector("div[id='finishbtn']")).click();
		
	}
	
	public void addExtras(int extraNum) {
		
		
		ul.highlightElement(By.xpath(".//div[@class='container-fluid'][@data-bind='foreach: { data: extraspurchasedetails}']/div[" + extraNum + "]/div[6]"));
		ul.fluentWait(By.xpath(".//div[@class='container-fluid'][@data-bind='foreach: { data: extraspurchasedetails}']/div[" + extraNum + "]/div[6]")).click();
	}
	
}
