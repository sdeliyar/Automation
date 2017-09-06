package com.pages;

import java.awt.List;

import org.openqa.selenium.By;

public class ExtendPage extends BasePage {
	
	List lockerNumbers = new List();
	public void findExpireLocker(int lockerNum, String adminpass) throws Exception {
		String info = null;
		
		
		
		String adminP = getLockerNumber(lockerNum);
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
	public void setLockerNumber(String Lockers) {
		String [] eachlocker = Lockers.split(",");
		for (int i = 0; i < eachlocker.length; i++) {
			this.lockerNumbers.add(eachlocker[i]);
		}
		
	}
	public String getLockerNumber(int index) {
		
		
		return lockerNumbers.getItem(index);
		
	}
	
	public void ExtendHours() {
		
		ul.fluentWait(By.id("extpay")).click();
	}
}
