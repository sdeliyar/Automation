package library;

import static org.testng.AssertJUnit.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class UtilityLibrary {
	private WebDriver driver;
	private boolean isDemoMode = false;

	public void setDemoMode(boolean isDemoMode) {
		this.isDemoMode = isDemoMode;
	}

	public UtilityLibrary(WebDriver _driver) {
		this.driver = _driver;

	}

	public WebDriver start_Firefox_IE_Chrome(String browserName) {
		try {

			if (browserName.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equals("ie")) {
				System.setProperty("webdriver.ie.driver", "C:/workspace/resource/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

			} else if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C://Trianing2016//chromedriver.exe");
				driver = new ChromeDriver();
			}

			driver.manage().window().maximize(); // maximize the browser window
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // wait
																				// for
																				// driver
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		}

		return driver;
	}

	public WebDriver startExictingProfil_firefox() {

		ProfilesIni profile = new ProfilesIni();

		FirefoxProfile myprofile = profile.getProfile("QAautomation");

		driver = new FirefoxDriver(myprofile);
		return driver;
	}

	public WebDriver startRemoteIEBrowser(String hubRUL, String browserName) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browserName);
		driver = new RemoteWebDriver(new URL(hubRUL), capabilities);
		return driver;
	}
	
	public WebDriver startRemoteFirefoxBrowser(String hubRUL) throws Exception {
		
		// Fire fox
		//DesiredCapabilities capability = DesiredCapabilities.firefox();
		
		// IE
		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		capability.setPlatform(Platform.WINDOWS);
		capability.setCapability("ignoreZoomSetting", true);
		URL url = new URL(hubRUL);
		driver = new RemoteWebDriver(url, capability);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
	public void enterTextField(By by, By by1, String textValue) {
		try {

			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(textValue);
			fluentWait(by1);
			driver.findElement(by1).click();

		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterTextFiledAndKeyDownSelect(By by, String textValue) {
		try {

			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(textValue);
			customWait(2);
			driver.findElement(by).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(by).sendKeys(Keys.ENTER);

		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void click(By by) { // click single button method

		try {
			driver.findElement(by).click();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void selectListValue(By by, By by1, By by2, By by3, int Number) { // click
																				// list
																				// button
																				// and
																				// choice
																				// value
																				// method
		try {
			driver.findElement(by).findElement(by1).click();
			driver.findElement(by2).findElements(by3).get(Number).click();
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void PrintResult(By by, String TextSys, String TextSys1) // Result
																	// Print
																	// Method
	{
		String totalInterstPaidResult = driver.findElement(by).getText();
		System.out.println(TextSys + totalInterstPaidResult);
		assertEquals(TextSys1, totalInterstPaidResult);
	}

	public void selectDropDown(By by, String targetValue) {
		try {
			WebElement dropDownElement = driver.findElement(by);
			Select selectList = new Select(dropDownElement);
			selectList.selectByVisibleText(targetValue);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		}
	}

	public WebElement fluentWait(By by) {
		WebElement targetElem;
		targetElem = null;
		try {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);

				}
			});
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return targetElem;
	}

	public String takeScreenShot(String screenShotName, String saveLocationPath) {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(saveLocationPath + screenShotName + getCurrentTime() + ".png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveLocationPath + screenShotName + getCurrentTime() + ".png";
	}

	public String getCurrentTime() {
		String timeStamp = null;
		try {
			timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
			e.printStackTrace();
		}
		return timeStamp;

	}

	public void customWait(int inSeconds) throws Exception {
		Thread.sleep(inSeconds * 1000);
	}

	public void print(String stringValue) {
		System.out.println(stringValue);
	}

	public void clickOnHiddenElement(By by) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguements[0].click();", driver.findElement(by));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void datePickerMethod(String expDate) {

		List<WebElement> days = driver.findElements(By.xpath(
				".//div[@id='ui-datepicker-div']/div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td/a"));
		for (WebElement d : days) {

			if (d.getText().equals(expDate)) {
				d.click();
				return;
			}
		}

	}

	public void selectTravelarTypeNumber(String travelPersonType, int travelPersonNumber) throws Exception {
		WebElement travelSelectorElem = driver.findElement(By.id("travelers-selector"));
		// clicking dropdown element to make options visible
		travelSelectorElem.click();

		customWait(1);
		WebElement travelselect = driver.findElement(By.id("travelers-select"));
		List<WebElement> stepperElems = travelselect.findElements(By.className("stepper-wrap"));
		// System.out.println("Size of travel selection: " +
		// stepperElems.size());
		for (WebElement option : stepperElems) {
			String optionTxt = option.getText();
			if (optionTxt.contains(travelPersonType)) {
				/*
				 * if (travelPersonType.contains("Adults")) { travelPersonNumber
				 * = travelPersonNumber-1; }
				 */
				List<WebElement> icons = option.findElements(By.tagName("a"));
				for (int i = 0; i < travelPersonNumber; i++) {
					icons.get(1).click();
					customWait(1);
				}

				moveMouseToBooktravel();
				break;
			}
		}
		System.out.println("type of travel person: [" + travelPersonType + "]");

		System.out.println("number of travel person for above type: [" + travelPersonNumber + "]");
	}

	public void clearPreselectedTravelersDropdown() throws Exception {
		WebElement travelSelectorElem = driver.findElement(By.id("travelers-selector"));
		// clicking drop-down element to make options visible
		travelSelectorElem.click();
		customWait(1);
		WebElement travelselect = driver.findElement(By.id("travelers-select"));
		List<WebElement> stepperElems = travelselect.findElements(By.className("stepper-wrap"));
		// System.out.println("Size of travel selection: " +
		// stepperElems.size());
		for (WebElement option : stepperElems) {
			List<WebElement> icons = option.findElements(By.tagName("a"));
			WebElement minusIcon = icons.get(0);
			String iconClassName = minusIcon.getAttribute("class");

			while (!iconClassName.contains("disabled")) {
				minusIcon.click();
				iconClassName = minusIcon.getAttribute("class");
				/*
				 * if(iconClassName.contains("disabled")) { break; }
				 */
				System.out.println("infinit loop...");
			}
		}
	}

	public void moveMouseToBooktravel() {
		// WebElement textLabelElem =
		// driver.findElement(By.id("tile-book-travel"));
		// List<WebElement> h2 = textLabelElem.findElements(By.tagName("h2"));
		driver.findElement(By.cssSelector("h2[id='ui-id-2'][class='maintitle']")).click();

	}

	@Test
	public void testing_advance_dorpdown_method() throws Exception {
		// Step6.1 remove preselected travelers
		// Step7.1 Locate Total travelers number and print
		clearPreselectedTravelersDropdown();
		moveMouseToBooktravel();

		// Step7: Locate and select travelers
		// selectTravelarTypeNumber("Children (12-17)", 2);
		selectTravelarTypeNumber("Adults (18-64)", 3);
		// selectTravelarTypeNumber("Seniors (65+)", 2);
		// selectTravelarTypeNumber("Children (5-11)", 2);
		// selectTravelarTypeNumber("Infants on lap", 2);
		selectTravelarTypeNumber("Children (2-4)", 2);
	}

	public void switchWindows_ClosePopup(String CurrentBrowser) {
		CurrentBrowser = driver.getWindowHandle();
		for (String temp : driver.getWindowHandles()) {
			if (!temp.equals(CurrentBrowser)) {
				driver.switchTo().window(temp);
				print("browserTitle :" + driver.getTitle());
				driver.close();
			}

		}
		driver.switchTo().window(CurrentBrowser);

	}

	public void moveMouseToElement(WebElement toElement) {
		Actions action = new Actions(driver);
		action.moveToElement(toElement).build().perform();
	}

	/*
	 * This method uploads given file. Note*: for windows test execution
	 * environment , please use "\\" for the file path for other environment
	 * (Mac OS, Linux) , please use "/" for the file path
	 * 
	 * 
	 */
	public void uploadFile(By by, String absulatePathForFile) {
		WebElement fileUploadElem = driver.findElement(by);
		fileUploadElem.sendKeys(absulatePathForFile);

	}

	public String tableTesting(By tableID, int Row_Num, int Col_Num) {
		String result = null;
		WebElement table = driver.findElement(tableID);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int i_row = 1;

		for (WebElement temp : rows) {
			if (i_row == Row_Num) {
				List<WebElement> cols = temp.findElements(By.tagName("td"));
				int i_col = 1;
				for (WebElement temp2 : cols) {

					if (i_col == Col_Num) {
						return result = temp2.getText();
						// System.out.println("Row: " + i_row + ", Col: " +
						// i_col + " , Data: " + temp2.getText());

					}
					i_col++;
				}
			}
			i_row++;
		}

		return result;

	}

	/***
	 * This method dynamically waits for the Presence condition of given element
	 * 
	 * @param by
	 * @return
	 */
	public WebElement waitForConditionPresense(By by) {
		WebElement temp = null;
		try {

			WebDriverWait pageWait = new WebDriverWait(driver, 30);
			temp = pageWait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			print("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return temp;
	}

	/***
	 * This method dynamically waits for the Visibility condition of given
	 * element
	 * 
	 * @param by
	 * @return
	 */
	public WebElement waitForConditionVisibility(By by) {
		WebElement temp = null;

		try {
			WebDriverWait pageWait = new WebDriverWait(driver, 30);
			temp = pageWait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		} catch (Exception e) {
			print("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return temp;
	}

	public void highlightElement(WebElement element) {
		if (isDemoMode == true) {
			try {
				for (int i = 0; i < 5; i++) {
					WrapsDriver wrappedElement = (WrapsDriver) element;
					JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
					driver.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,
							"color: green; border: 2px solid yellow;");
					driver.executeScript("arguements[0].setAttribute('style',arguments[1]);", element, "");

				}
			} catch (Exception e) {

				print("Error: " + e.getMessage());
				e.printStackTrace();
			}

		}
	}

	public void keyboardType(String typeInfo) {

		String[] infoParts = typeInfo.split("");

		for (int i = 0; i < infoParts.length; i++) {
			String keyBoards = "button[data-value='" + infoParts[i] + "']";
			driver.findElement(By.cssSelector("div[class='ui-keyboard-keyset ui-keyboard-keyset-normal']"))
					.findElement(By.cssSelector(keyBoards)).click();

		}
		// click accept
		driver.findElement(By.cssSelector("div[class='ui-keyboard-keyset ui-keyboard-keyset-normal']"))
				.findElement(By.cssSelector("button[data-value='accept']")).click();
	}
	public void executeBatFile(String batUrl) {
		Process process;
		try {
			process = Runtime.getRuntime().exec(batUrl);
//			process.waitFor();
			process.waitFor(2, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public boolean isPresent(WebElement ele) {
	    boolean flag = true;
	    try {
	    	ele.isDisplayed();
	        flag = true;
	    }
	    catch (Exception e) {
	        flag = false;
	    }
	    return flag;
	}
	
	
	
}
