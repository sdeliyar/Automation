package com.pages;

import org.openqa.selenium.By;

public class DiscountPage extends BasePage {
	
	
	public void goRegularLocker() {

		ul.fluentWait(By.id("bstdu")).click();

	}
	public void goGeneralDiscount() {

		ul.fluentWait(By.id("bgenu")).click();

	}
	
	public void goSeasonalDiscount() {

		ul.fluentWait(By.id("bssnu")).click();

	}
	
	public void goPrepurchaseDiscount() {

		ul.fluentWait(By.id("bpsu")).click();

	}
}
