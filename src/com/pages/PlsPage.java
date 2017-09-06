package com.pages;

import org.openqa.selenium.By;

import library.JavaPropertiesManager;

public class PlsPage extends BasePage {
	private String passcode;
	private String customerID;
	private String newCustomerID;

	public void goSingleLocker() {

		ul.highlightElement(By.cssSelector("div[id='standard'][class='gpbslw']"));

		ul.fluentWait(By.cssSelector("div[id='standard'][class='gpbslw']")).click();

	}

	public void goPLSLocker() {
		ul.highlightElement(By.cssSelector("div[id='new'][class='gpbslw']"));

		ul.fluentWait(By.cssSelector("div[id='new'][class='gpbslw']")).click();

	}

	public void selectADA() {

		ul.fluentWait(By.id("gpraiseup")).click();
	}

	public void goMovePLS() {
		ul.highlightElement(By.cssSelector("div[id='move'][class='gpbslw']"));

		ul.fluentWait(By.cssSelector("div[id='move'][class='gpbslw']")).click();

	}

	public void plscustomer() {
		ul.highlightElement(By.cssSelector("div[id='move'][class='gpbslw']"));

		ul.fluentWait(By.cssSelector("div[id='new'][class='gpbslw']")).click();

	}

	public void goOpenExpireLocker() {
		ul.highlightElement(By.cssSelector("div[id='bextnd'][class='gpbslw']"));

		ul.fluentWait(By.cssSelector("div[id='bextnd'][class='gpbslw']")).click();

	}

	public void enterCustomerID() throws Exception {

		property = new JavaPropertiesManager("resources/testData.properties");
		passcode = property.readProperty("PassCode");
		customerID = property.readProperty("CutomerID");

		// customer id type
		String[] separateInfo1 = customerID.split("");
		for (int i = 0; i < separateInfo1.length; i++) {
			ul.highlightElement(By.cssSelector("img[id='b" + separateInfo1[i] + "']"));
			ul.fluentWait(By.cssSelector("img[id='b" + separateInfo1[i] + "']")).click();
		}
		ul.highlightElement(By.cssSelector("div[class='gpenterbtnblink']"));

		ul.waitForConditionVisibility(By.cssSelector("div[class='gpenterbtnblink']")).click();
		property.setProperty("CutomerID", Integer.toString((Integer.parseInt(customerID) + 1)));

		for (int k = 0; k < 2; k++) {
			// passcode
			String[] separateInfo2 = passcode.split("");
			for (int j = 0; j < separateInfo2.length; j++) {

				ul.highlightElement(By.cssSelector("div[id='b" + separateInfo2[j] + "']"));

				driver.findElement(By.cssSelector("div[id='b" + separateInfo2[j] + "']")).click();

			}
			// enter
			ul.highlightElement(By.cssSelector("div[class='gpenterbtnblink gpleftshiftC']"));

			ul.fluentWait(By.cssSelector("div[class='gpenterbtnblink gpleftshiftC']")).click();

		}

	}

}
