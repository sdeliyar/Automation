package com.pages;

import org.openqa.selenium.By;

public class ExtendPage extends BasePage {

	public void findExpireLocker(int lockerNum, String adminpass) throws Exception {
		String info = null;
		
		
		
		String adminP = Integer.toString(lockerNum);
		String adminPs = adminpass;

		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				info = adminP;
				driver.findElement(By.cssSelector("input[class='gppin']")).click();

				driver.findElement(By.cssSelector("div[id='bc']")).click();

			} else if (i == 1) {
				info = adminPs;
				driver.findElement(By.cssSelector("input[class='gppass']")).click();

				driver.findElement(By.cssSelector("div[id='bc']")).click();

			}
			String[] separateInfo = info.split("");
			for (int j = 0; j < separateInfo.length; j++) {
				driver.findElement(By.cssSelector("div[id='b" + separateInfo[j] + "']")).click();

			}

		}
		driver.findElement(By.cssSelector("div[id='keypadenterbtn']")).click();

		ul.customWait(3);

	}
	
	
	public void ExtendHours() {
		
		ul.fluentWait(By.id("extpay")).click();
	}
}
