package com.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LockersPage extends BasePage {
	public static String prices = null;

	public void increaseRentHour() throws Exception {
		ul.highlightElement(By.cssSelector("img[id='timedplus']"));
		ul.fluentWait(By.cssSelector("img[id='timedplus']")).click();
	}

	public String selectLockerSize(String LockSize) throws Exception {

		

		String lockerPrice = null;
		if (LockSize.equals("Standard")) {
			lockerPrice = ul.fluentWait(By.cssSelector("div[id='prod-0']")).getText();
			prices = lockerPrice;

			ul.highlightElement(By.xpath("//div[text()='Standard']"));
			ul.fluentWait(By.xpath("//div[text()='Standard']")).click();

		} else if (LockSize.equals("Large")) {

			lockerPrice = ul.fluentWait(By.cssSelector("div[id='prod-1']")).getText();
			prices = lockerPrice;

			ul.highlightElement(By.xpath("//div[text()='Large']"));
			ul.fluentWait(By.xpath("//div[text()='Large']")).click();

		} else if (LockSize.equals("Jumbo")) {

			lockerPrice = ul.fluentWait(By.cssSelector("div[id='prod-2']")).getText();
			prices = lockerPrice;

			ul.highlightElement(By.xpath("//div[text()='Jumbo']"));
			ul.fluentWait(By.xpath("//div[text()='Jumbo']")).click();

		}
		return prices;

	}

	public void verifySoldOut() {
		String smallSoldOut = ul.fluentWait(By.xpath(".//div[@class='container-fluid']/div[1]/div[4]/div")).getText();

		String largeSoldOut = ul.fluentWait(By.xpath(".//div[@class='container-fluid']/div[2]/div[4]/div")).getText();

		String jumboSoldOut = ul.fluentWait(By.xpath(".//div[@class='container-fluid']/div[3]/div[4]/div")).getText();

		Assert.assertEquals(smallSoldOut, "Sold Out");
		Assert.assertEquals(largeSoldOut, "Sold Out");
		Assert.assertEquals(jumboSoldOut, "Sold Out");

	}
	public void cancel() {
		ul.highlightElement(By.cssSelector("div[class='gpdivfooterleft']"));
		ul.fluentWait(By.cssSelector("div[class='gpdivfooterleft']")).click();
	}

	public void specialNeed() {

		ul.highlightElement(By.xpath(".//div[@class='gpdivfooterright']/img"));
		ul.fluentWait(By.xpath(".//div[@class='gpdivfooterright']/img")).click();

	}

	public void agreePriceTC() throws Exception {
		ul.customWait(1);

		ul.highlightElement(By.cssSelector("div[class='gpagreebtn']"));
		ul.fluentWait(By.cssSelector("div[class='gpagreebtn']")).click();

	}

}
