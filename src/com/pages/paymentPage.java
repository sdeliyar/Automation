package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class paymentPage extends BasePage {
	
	public Actions action;
	public void agreeTermCondition() throws Exception {
		
		
		
		if(LockersPage.prices.equals("$0")) {
			
			
		}
		else {
			action = new Actions(driver);
		action.click(ul.fluentWait(By.xpath(".//div[@id='tcscreen']/div/div/div[3]/div[2]/div"))).build().perform();
	
		}
		
		
	}
	
	public void redeemCoupon(String cpcode) throws Exception {
		
	
//		ul.waitForConditionVisibility(By.cssSelector("div[id='couponbtn']")).click();
//		ul.fluentWait(By.cssSelector("div[id='couponbtn']")).click();
//		ul.fluentWait(By.cssSelector("div[id='couponbtn']")).click();
//		
		driver.findElement(By.cssSelector("div[id='couponbtn']")).click();
		
		//String couponBox = driver.findElement(By.cssSelector("input[id='couponinput']")).getText();
		
		driver.findElement(By.cssSelector("div[id='bc']")).click();
		
		
		
		String[] eachcpNum = cpcode.split("");
		
		
		for(int i=0;i<6;i++) 
		{
			String cpElem = "img[id='b" + eachcpNum[i] + "'";
			ul.fluentWait(By.cssSelector(cpElem)).click();
		}
		ul.fluentWait(By.cssSelector("div[id='keypadenterbtn']")).click();
		
		ul.customWait(5);
	}
	
}
