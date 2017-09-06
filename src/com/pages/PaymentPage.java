package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.practice.ReadXMLfiles;
import com.practice.WebServiceAPI;

import library.SQL_JDBC;

public class PaymentPage extends BasePage {
	ReadXMLfiles readXml = new ReadXMLfiles();

	WebServiceAPI webServiceAPI = new WebServiceAPI();
	SQL_JDBC sql_jdbc = new SQL_JDBC();
	public Actions action;

	public void agreeTermCondition() throws Exception {

		if (LockersPage.prices.equals("$0")) {

		} else {
			action = new Actions(driver);
			ul.highlightElement(By.xpath(".//div[@id='tcscreen']/div/div/div[3]/div[2]/div"));
			action.click(ul.fluentWait(By.xpath(".//div[@id='tcscreen']/div/div/div[3]/div[2]/div"))).build().perform();

		}

		ul.highlightElement(By.xpath(".//div[@class='container']/div[@class='row'][5]"));

	}

	public void payByCoupon() {

		driver.findElement(By.cssSelector("div[id='couponbtn']")).click();
	}

	public void redeemCoupon(String value) throws Exception {

		String cpcode = null;
		driver.findElement(By.cssSelector("div[id='bc']")).click();

		if (value.equalsIgnoreCase("")) {
			cpcode = sql_jdbc.coupon(readXml.fromSetUpXML("", "kioskid"));
		} else if (value.equalsIgnoreCase("wrong")) {
			cpcode = "012345";
		} else {
			cpcode = webServiceAPI.createCouponPost(value);
		}

		String[] eachcpNum = cpcode.split("");

		for (int i = 0; i < 6; i++) {
			String cpElem = "img[id='b" + eachcpNum[i] + "'";

			ul.highlightElement(By.cssSelector(cpElem));
			ul.fluentWait(By.cssSelector(cpElem)).click();
		}
		ul.highlightElement(By.cssSelector("div[id='keypadenterbtn']"));
		ul.fluentWait(By.cssSelector("div[id='keypadenterbtn']")).click();

		ul.customWait(1);
		ul.highlightElement(By.xpath(".//div[@class='container']/div[@class='row'][5]"));

	}

	public void verifyCoupon() {

		String textCoupon = ul.fluentWait(By.cssSelector("label[class='text-danger gpfooter']")).getText();
		ul.highlightElement(By.cssSelector("label[class='text-danger gpfooter']"));
		Assert.assertEquals(textCoupon, "Waiting for payment");
	}

	public void payWithMasterC() {

		ul.highlightElement(By.cssSelector("div[id='paywithccard1btn']"));

		driver.findElement(By.cssSelector("div[id='paywithccard1btn']")).click();

	}

	public void payWithUnionpayC() {
		ul.highlightElement(By.cssSelector("div[id='paywithccard2btn']"));

		driver.findElement(By.cssSelector("div[id='paywithccard2btn']")).click();

	}

}
