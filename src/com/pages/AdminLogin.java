package com.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.xml.sax.SAXException;

import com.practice.ReadXMLfiles;

public class AdminLogin extends BasePage {
	private Screen screen = new Screen();
	public String currentLock = null;

	AdminMenu adminMenu = new AdminMenu();
	ReadXMLfiles readXml = new ReadXMLfiles();

	public void adminLogin(String type) throws Exception {
		String info = null;

		// attendants user&pass
		String adminP = readXml.fromAttendantsXML(type, "user");

		String adminPs = readXml.fromAttendantsXML(type, "pass");

		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				info = adminP;

				ul.highlightElement(driver.findElement(By.cssSelector("input[class='gppin']")));

				ul.fluentWait(By.cssSelector("input[class='gppin']")).click();

				ul.fluentWait(By.cssSelector("div[id='bc']")).click();

			} else if (i == 1) {
				info = adminPs;
				ul.highlightElement(driver.findElement(By.cssSelector("input[class='gppass']")));

				ul.fluentWait(By.cssSelector("input[class='gppass']")).click();

				ul.fluentWait(By.cssSelector("div[id='bc']")).click();

			}
			String[] separateInfo = info.split("");
			for (int j = 0; j < separateInfo.length; j++) {

				ul.highlightElement(driver.findElement(By.cssSelector("div[id='b" + separateInfo[j] + "']")));

				driver.findElement(By.cssSelector("div[id='b" + separateInfo[j] + "']")).click();

			}

		}

		ul.highlightElement(driver.findElement(By.cssSelector("div[id='gpshiftleftsi']")));

		driver.findElement(By.cssSelector("div[id='gpshiftleftsi']")).click();

		ul.customWait(3);

	}

	public void issueCoupon(int couponindex) throws Exception {

		ul.highlightElement(ul.fluentWait(By.cssSelector(".//select[@id='val']/option[" + couponindex + "]")));

		ul.fluentWait(By.xpath(".//select[@id='val']/option[" + couponindex + "]")).click();

		ul.customWait(1);

		ul.highlightElement(ul.fluentWait(By.className("gpbcon")));

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

	public void isMaxProEqMaxCoup() throws Exception {
		WebElement latestOne = null;
		int MaxCouponInlist = 0;

		int MaxCouponInXML = 0;

		int maxOvertimeCharge = Integer.parseInt(readXml.fromPricingXML("MaxOvertimeCharge"));

		int minXml = Integer.parseInt(readXml.fromSetUpXML("", "min"));

		int interXml = Integer.parseInt(readXml.fromSetUpXML("", "interval"));

		int maxproductPrice = readXml.fromPricingMaxPrice();
		if (readXml.fromSetUpXML("", "rentaloption").equalsIgnoreCase("daily")) {
			MaxCouponInXML = maxproductPrice;
		} else {
			if (maxOvertimeCharge > maxproductPrice) {
				MaxCouponInXML = maxOvertimeCharge;
			} else if (maxOvertimeCharge < maxproductPrice) {
				MaxCouponInXML = maxproductPrice;
			} else {
				MaxCouponInXML = maxOvertimeCharge;
			}
		}

		int i = 1;
		int expectedMaxC = 0;
		while (minXml + interXml * i <= MaxCouponInXML) {
			if (minXml + interXml * i == MaxCouponInXML) {
				expectedMaxC = MaxCouponInXML;
			} else {
				expectedMaxC = minXml + interXml * i;
			}

			++i;
		}
		ul.highlightElement(By.xpath(".//select[@id='val']"));
		ul.fluentWait(By.xpath(".//select[@id='val']")).click();
		List<WebElement> couponList = driver.findElements(By.xpath(".//select[@id='val']/option"));

		for (WebElement tempList : couponList) {

			MaxCouponInlist = Integer.parseInt(tempList.getText().replace("$", ""));
			latestOne = tempList;
		}
		latestOne.click();
		Assert.assertEquals(MaxCouponInlist, expectedMaxC);

	}

	public void verifyCouponInterval()
			throws NumberFormatException, ParserConfigurationException, SAXException, IOException, Exception {
		ul.highlightElement(By.xpath(".//select[@id='val']"));
		ul.fluentWait(By.xpath(".//select[@id='val']")).click();

		int interXml = Integer.parseInt(readXml.fromSetUpXML("", "interval"));
		ul.highlightElement(By.xpath(".//select[@id='val']/option[1]"));
		int couponListfirst = Integer
				.parseInt(ul.fluentWait(By.xpath(".//select[@id='val']/option[1]")).getText().replace("$", ""));
		ul.highlightElement(By.xpath(".//select[@id='val']/option[2]"));
		int couponListsecond = Integer
				.parseInt(ul.fluentWait(By.xpath(".//select[@id='val']/option[2]")).getText().replace("$", ""));

		Assert.assertEquals((couponListsecond - couponListfirst), interXml);

	}

	public void verifyAdminUSer() {

		ul.highlightElement(ul.fluentWait(By.cssSelector("div[class='gpdivheader']")));

		Assert.assertEquals(ul.fluentWait(By.cssSelector("div[class='gpdivheader']")).getText(),
				"Hello An Attendant (Attendant)");

	}

	public void verifyAdminMenuText() throws Exception {
		List<String> menuItems = Arrays.asList("Manage Lockers", "Locker Service", "Manage Rentals", "Coupons",
				"Sensors", "Administration");

		for (int i = 0; i < menuItems.size(); i++) {

			if (i == 5) {
				++i;
			}
			ul.highlightElement(
					ul.fluentWait(By.xpath(".//div[@class='col-md-3'][1]/div[" + (i + 1) + "]/div/div/div")));
			ul.fluentWait(By.xpath(".//div[@class='col-md-3'][1]/div[" + (i + 1) + "]/div/div/div")).click();

			String menuText = ul.fluentWait(By.xpath(".//div[@class='col-md-3'][1]/div[" + (i + 1) + "]/div/div/div"))
					.getText();
			if (i == 6) {
				--i;
			}
			Assert.assertEquals(menuText, menuItems.get(i));

			ul.customWait(1);
			ul.highlightElement(ul.fluentWait(By.xpath(".//*[@id='page']/div/div/div[3]/div/div/h2/label")));

			String headerText = ul.fluentWait(By.xpath(".//*[@id='page']/div/div/div[3]/div/div/h2/label")).getText();
			Assert.assertEquals(headerText.replaceAll(" Menu", ""), menuItems.get(i));

		}

		// .//div[@class='col-md-3'][1]/div[1]/div/div/div

		// .//*[@id='page']/div/div/div[3]/div/div/h2/label

	}

	public void confirm() throws Exception {

		ul.fluentWait(By.cssSelector("div[id='con']")).click();
		ul.customWait(4);
	}

	public void typeLockers(String lockerID) throws Exception {

		// ul.fluentWait(By.id("bmrt")).click();
		//
		// ul.fluentWait(By.id("bert")).click();

		// type Locker id

		if (lockerID != null) {
			String[] separateInfo1 = lockerID.split("");
			for (int i = 0; i < separateInfo1.length; i++) {
				ul.fluentWait(By.cssSelector("img[id='b" + separateInfo1[i] + "']")).click();
			}

			ul.waitForConditionVisibility(By.cssSelector("div[id='enterbtn']")).click();
			ul.customWait(4);
		} else {
			if (currentLock.equalsIgnoreCase("")) {

			}

			else if (currentLock.contains(", ")) {
				String[] doubleLockers = currentLock.split(", ");
				for (int k = 0; k < doubleLockers.length; k++) {
					if (k > 0) {
						ul.fluentWait(By.cssSelector("div[id='bopl']")).click();
					}

					String[] separateInfo1 = doubleLockers[k].split("");
					for (int j = 0; j < separateInfo1.length; j++) {
						ul.fluentWait(By.cssSelector("img[id='b" + separateInfo1[j] + "']")).click();
					}

					ul.waitForConditionVisibility(By.cssSelector("div[id='enterbtn']")).click();
					ul.customWait(4);

				}

			} else {
				String[] separateInfo1 = currentLock.split("");
				for (int j = 0; j < separateInfo1.length; j++) {
					ul.fluentWait(By.cssSelector("img[id='b" + separateInfo1[j] + "']")).click();
				}

				ul.waitForConditionVisibility(By.cssSelector("div[id='enterbtn']")).click();
				ul.customWait(4);
			}

		}

	}

	public String getLockerStatus() {

		ul.waitForConditionVisibility(
				By.xpath(".//*[@id='page']/div/div/div[4]/div[1]/div[2]/div[7]/div[4]/div[1]/u/a")).click();

		currentLock = ul
				.waitForConditionVisibility(By.cssSelector("textarea[data-bind='textInput: lockerlistitems()']"))
				.getText();

		return currentLock;
	}

	public void createAdminUser(int userNum) {

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
			} else if (50 < n && n <= 100) {

				userFN = "ca" + n;
				userLN = "ca" + n;
				userID = Integer.toString(5000 + n);
				userPS = Integer.toString(5000 + n);

			} else if (100 < n && n <= 150) {
				userFN = "su" + n;
				userLN = "su" + n;
				userID = Integer.toString(5000 + n);
				userPS = Integer.toString(5000 + n);

			} else {
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

			} else if (50 < n && n <= 100) {
				ul.fluentWait(By.cssSelector("option[value='Cashier']")).click();

			} else if (100 < n && n <= 150) {
				ul.fluentWait(By.cssSelector("option[value='Supervisor']")).click();

			} else {
				ul.fluentWait(By.cssSelector("option[value='Manager']")).click();

			}

			ul.fluentWait(By.xpath(".//div[@class='col-md-6 text-center'][2]/button")).click();
		}

	}

	public void logOutAdmin() {
		ul.highlightElement(ul.fluentWait(By.id("blot")));

		ul.fluentWait(By.id("blot")).click();
	}

}
