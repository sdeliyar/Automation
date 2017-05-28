package com.practice;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.basics.Debug;

import library.UtilityLibrary;

public class practice_1 {
	public static WebDriver driver;
	public static UtilityLibrary ul;

	public static void main(String[] args) throws Exception {

		Debug.setDebugLevel(-2);

		driver = startRemoteFirefoxBrowser("http://192.168.1.45:4444/wd/hub");

		driver.get("file:///C:/SelfVend/Kiosk/MainMenu.html");

		driver.findElement(By.xpath(".//*[@id='pickUpID']")).click();

	}

	public static WebDriver chromeDr() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("user-data-dir=C:\\Users\\dsaifuding\\AppData\\Local\\Google\\Chrome\\User Data");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dsaifuding\\workspace\\resource\\chromedriver.exe");

		driver = new ChromeDriver(option);

		driver.manage().window().maximize(); // maximize the browser window
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // wait
																			// for
																			// driver
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		return driver;
	}

	public static WebDriver startRemoteFirefoxBrowser(String hubRUL) throws Exception {
		// ProfilesIni profile = new ProfilesIni();

		// FirefoxProfile myprofile = profile.getProfile("new");
		// DesiredCapabilities capability = DesiredCapabilities.firefox();

		ChromeOptions options = new ChromeOptions();
		// options.addArguments("user-data-dir=C:\\Users\\dsaifuding\\AppData\\Local\\Google\\Chrome\\User
		// Data");
		options.addArguments("user-data-dir=C:\\Users\\KioskUser\\AppData\\Local\\Google\\Chrome\\User Data");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(ChromeOptions.CAPABILITY, options);

		capability.setPlatform(Platform.ANY);
		URL url = new URL(hubRUL);
		driver = new RemoteWebDriver(url, capability);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}

}
