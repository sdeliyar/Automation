package com.pages;

import org.openqa.selenium.By;

public class PlsEndRentalPage extends BasePage{
	
	public void confirmEndPLS() {
		Boolean isPresent = 	driver.findElements(By.className("gpbcon")).size() > 0;
		
		
		
		if(isPresent.equals(true)) {
			ul.waitForConditionVisibility(By.className("gpbcon")).click();
			
		}
		
		else {
			System.out.println("retrieve");
			//ul.waitForConditionVisibility(By.cssSelector("")).getText().contains("Information has been retrieved")
		}
		
		
		
	}
	
	public void cancelEndPLS() {
		
		ul.waitForConditionVisibility(By.cssSelector("gpbcan")).click();
		
		
		
	}

	
}
