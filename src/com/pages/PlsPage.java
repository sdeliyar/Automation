package com.pages;

import org.openqa.selenium.By;

public class PlsPage extends BasePage {
	
	
	
	public void goSingleLocker() {

		ul.fluentWait(By.cssSelector("div[id='standard'][class='gpbslw']")).click();

	}
	
	public void goPLSLocker() {

		ul.fluentWait(By.cssSelector("div[id='new'][class='gpbslw']")).click();

	}
	
	
	
	public void selectADA() {
		
		ul.fluentWait(By.id("gpraiseup")).click();
	}

	public void goMovePLS() {

		ul.fluentWait(By.cssSelector("div[id='move'][class='gpbslw']")).click();

	}

	public void plscustomer() {

		ul.fluentWait(By.cssSelector("div[id='new'][class='gpbslw']")).click();

	}
	
	public void goOpenExpireLocker() {

		ul.fluentWait(By.cssSelector("div[id='bextnd'][class='gpbslw']")).click();

	}

	public void enterCustomerID(String cusID, String passCd) {

		// customer id type
		String[] separateInfo1 = cusID.split("");
		for (int i = 0; i < separateInfo1.length; i++) {
			driver.findElement(By.cssSelector("img[id='b" + separateInfo1[i] + "']")).click();
			//ul.fluentWait(By.cssSelector("img[id='b" + separateInfo1[i] + "']")).click();
		}

		ul.waitForConditionVisibility(By.cssSelector("div[class='gpenterbtnblink']")).click();

		for (int k = 0; k < 2; k++) {
			// passcode
			String[] separateInfo2 = passCd.split("");
			for (int j = 0; j < separateInfo2.length; j++) {
				driver.findElement(By.cssSelector("div[id='b" + separateInfo2[j] + "']")).click();
				
				//ul.fluentWait(By.cssSelector("div[id='b" + separateInfo2[j] + "']")).click();
			}
			// enter
			ul.fluentWait(By.cssSelector("div[class='gpenterbtnblink gpleftshiftC']")).click();

		}

	}

}
