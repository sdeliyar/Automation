package com.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.sikuli.script.Screen;

public class AdminLogin extends BasePage {
	private Screen screen = new Screen();
	public String currentLock = null;

	public void adminLogin(String adminpin, String adminpass) throws Exception {
		String info = null;

		String adminP = adminpin;
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
		driver.findElement(By.cssSelector("div[id='gpshiftleftsi']")).click();

		ul.customWait(3);

	}

	public void issueCoupon(String couponAmount) throws Exception {
		ul.waitForConditionPresense(By.cssSelector("div[id='bcpn']")).click();

		ul.customWait(1);

		ul.fluentWait(By.cssSelector("div[id='bicp']")).click();

		ul.customWait(1);

		ul.fluentWait(By.cssSelector("select[id='val']>option[value='$" + couponAmount + "']")).click();

		ul.customWait(1);

		ul.fluentWait(By.className("gpbcon")).click();

		ul.customWait(1);

		Robot robot = new Robot();
		String couponName = "coupon" + ul.getCurrentTime() + ".xps";
		StringSelection ss = new StringSelection(couponName);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		ul.customWait(1);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void endRental(String lockerID) throws Exception {

		ul.fluentWait(By.id("bmrt")).click();

		ul.fluentWait(By.id("bert")).click();

		// type Locker id

		if (lockerID != null) {
			String[] separateInfo1 = lockerID.split("");
			for (int i = 0; i < separateInfo1.length; i++) {
				ul.fluentWait(By.cssSelector("img[id='b" + separateInfo1[i] + "']")).click();
			}

			ul.waitForConditionVisibility(By.cssSelector("div[id='enterbtn']")).click();

		} else {
			if (currentLock.equalsIgnoreCase("")) {

			}

			else if (currentLock.contains(", ")) {
				String[] doubleLockers = currentLock.split(", ");
				for (int k = 0; k < doubleLockers.length; k++) {

					String[] separateInfo1 = doubleLockers[k].split("");
					for (int j = 0; j < separateInfo1.length; j++) {
						ul.fluentWait(By.cssSelector("img[id='b" + separateInfo1[j] + "']")).click();
					}

					ul.waitForConditionVisibility(By.cssSelector("div[id='enterbtn']")).click();
					ul.customWait(4);
					ul.fluentWait(By.id("bert")).click();
				}

			} else {
				String[] separateInfo1 = currentLock.split("");
				for (int j = 0; j < separateInfo1.length; j++) {
					ul.fluentWait(By.cssSelector("img[id='b" + separateInfo1[j] + "']")).click();
				}

				ul.waitForConditionVisibility(By.cssSelector("div[id='enterbtn']")).click();
			}

		}

	}

	public String getLockerStatus() {

		ul.fluentWait(By.id("bmlk")).click();

		ul.fluentWait(By.id("bsts")).click();

		ul.waitForConditionVisibility(
				By.xpath(".//*[@id='page']/div/div/div[4]/div[1]/div[2]/div[7]/div[4]/div[1]/u/a")).click();

		currentLock = ul
				.waitForConditionVisibility(By.cssSelector("textarea[data-bind='textInput: lockerlistitems()']"))
				.getText();

		return currentLock;
	}

	public void createAdminUser( int userNum) {

		String userFN = null;
		String userLN = null;
		String userID = null;
		String userPS = null;
		
		ul.fluentWait(By.id("badm")).click();

		ul.fluentWait(By.id("buac")).click();

		// fill user info, maximum userNum times
		for (int n = 1; n < userNum; n++) {
			
			if (n <= 50) {
				userFN = "at" + n;
				userLN = "at" + n;
				userID = Integer.toString(5000 + n);
				userPS = Integer.toString(5000 + n);
			}
			else if (50 < n && n <= 100) {
				
				userFN = "ca" + n;
				userLN = "ca" + n;
				userID = Integer.toString(5000 + n);
				userPS = Integer.toString(5000 + n);
					
			}
			else if (100 < n && n <= 150) {
				userFN = "su" + n;
				userLN = "su" + n;
				userID = Integer.toString(5000 + n);
				userPS = Integer.toString(5000 + n);
				
			}
			else  {
				userFN = "ma" + n;
				userLN = "ma" + n;
				userID = Integer.toString(5000 + n);
				userPS = Integer.toString(5000 + n);
				
			}
			
			ul.fluentWait(By.id("badd")).click();
			
			String[] eachString;
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					ul.fluentWait(By.xpath(".//div[@class='container-fluid']/div[2]/div[2]/input[@class='gplarger']"))
							.click();
					eachString = userFN.split("");
					for (int j = 0; j < eachString.length; j++) {
						ul.fluentWait(By.cssSelector("li[id='gp" + eachString[j] + "']")).click();
					}
					ul.fluentWait(By.cssSelector("div[id='bclose']")).click();
				} else if (i == 1) {
					ul.fluentWait(By.xpath(".//div[@class='container-fluid']/div[4]/div[2]/input[@class='gplarger']"))
							.click();

					eachString = userLN.split("");
					for (int j = 0; j < eachString.length; j++) {
						ul.fluentWait(By.cssSelector("li[id='gp" + eachString[j] + "']")).click();
					}
					ul.fluentWait(By.cssSelector("div[id='bclose']")).click();
				} else if (i == 2) {
					ul.fluentWait(By.xpath(".//div[@class='container-fluid']/div[6]/div[2]/input[@class='gplarger']"))
							.click();

					eachString = userID.split("");
					for (int j = 0; j < eachString.length; j++) {
						ul.fluentWait(By.cssSelector("li[id='gp" + eachString[j] + "']")).click();
					}
					ul.fluentWait(By.cssSelector("div[id='bclose']")).click();

				} else {
					ul.fluentWait(By.xpath(".//div[@class='container-fluid']/div[8]/div[2]/input[@class='gplarger']"))
							.click();

					eachString = userPS.split("");
					for (int j = 0; j < eachString.length; j++) {
						ul.fluentWait(By.cssSelector("li[id='gp" + eachString[j] + "']")).click();
					}
					ul.fluentWait(By.cssSelector("div[id='bclose']")).click();

				}

			}
			ul.fluentWait(By.id("userlevelselect")).click();
			
			
			if (n <= 50) {
				ul.fluentWait(By.cssSelector("option[value='Attendant']")).click();
				
			}
			else if (50 < n && n <= 100) {
				ul.fluentWait(By.cssSelector("option[value='Cashier']")).click();
				
			}
			else if (100 < n && n <= 150) {
				ul.fluentWait(By.cssSelector("option[value='Supervisor']")).click();
				
			}
			else  {
				ul.fluentWait(By.cssSelector("option[value='Manager']")).click();
				
			}
			
			
			

			ul.fluentWait(By.xpath(".//div[@class='col-md-6 text-center'][2]/button")).click();
		}

	}

	public void logOutAdmin() {

		ul.fluentWait(By.id("blot")).click();
	}

}
