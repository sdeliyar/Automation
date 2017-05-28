package com.pages;

import org.openqa.selenium.By;

public class LockersPage extends BasePage {
	public static String prices = null;

	public String selectLockerSize(String LockSize) throws Exception {

		ul.customWait(2);

		String lockerPrice = null;
		if (LockSize.equals("Standard")) {
			lockerPrice = ul.fluentWait(By.cssSelector("div[id='prod-0']")).getText();
			prices = lockerPrice;
			ul.fluentWait(By.xpath("//div[text()='Standard']")).click();

		} else if (LockSize.equals("Large")) {

			lockerPrice = ul.fluentWait(By.cssSelector("div[id='prod-1']")).getText();
			prices = lockerPrice;
			ul.fluentWait(By.xpath("//div[text()='Large']")).click();

		} else if (LockSize.equals("Jumbo")) {

			lockerPrice = ul.fluentWait(By.cssSelector("div[id='prod-2']")).getText();
			prices = lockerPrice;

			ul.fluentWait(By.xpath("//div[text()='Jumbo']")).click();

		}
		return prices;

	}

	public void agreePriceTC() throws Exception {
		ul.customWait(1);

		ul.fluentWait(By.cssSelector("div[class='gpagreebtn']")).click();
		// ul.fluentWait(By.cssSelector("div[class='gpagreebtn']")).click();

	}

}
