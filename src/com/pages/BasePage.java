package com.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.windowsAuto.GCU;

import library.JavaPropertiesManager;
import library.UtilityLibrary;

public class BasePage {
	final static Logger logger = Logger.getLogger(BasePage.class);
	public static WebDriver driver;
	public static UtilityLibrary ul;
	public JavaPropertiesManager property;
	
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest test;

	public GCU gcu = new GCU();
	public Screen screen = new Screen();
	Pattern image21 = new Pattern("C:\\Screen\\Capture21.PNG");
	Pattern image20 = new Pattern("C:\\Screen\\Capture20.PNG");

	@BeforeTest
	public void beforeTest() {

		try {
			Robot robot = new Robot();
			logger.info("Starting test ...");
			// extent report
			htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/GopodAutomationReport.html");

			extent = new ExtentReports();

			extent.attachReporter(htmlReport);

			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "KioskUser");
			htmlReport.config().setDocumentTitle("GP2 Automation Test Demo");
			htmlReport.config().setReportName("QA Report");
			htmlReport.config().setTestViewChartLocation(ChartLocation.TOP);

			htmlReport.config().setTheme(Theme.STANDARD);

			gcu.restartGopod();
			
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			
			ul = new UtilityLibrary(driver);
			driver = ul.start_Firefox_IE_Chrome("ie");

			robot.keyPress(KeyEvent.VK_WINDOWS);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_WINDOWS);
			screen.wait(image20);
			screen.click(image20);

			if (screen.exists(image21) != null) {

				ul.customWait(1);
				robot.keyPress(KeyEvent.VK_F11);
				robot.keyRelease(KeyEvent.VK_F11);
			}

			// isDemo
			ul.setDemoMode(true);

			// remote start
			// driver =
			// ul.startRemoteFirefoxBrowser("http://192.168.1.48:4444/wd/hub");

			System.out.println("Test Start :");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			String screenshot = ul.captureScreenshot(result.getName(), "C:/workspace/BestLockers/target/images/");

			test.fail(MarkupHelper.createLabel(result.getName() + "Test case FAILED", ExtentColor.RED));
			test.fail(result.getThrowable());
			test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenshot));
		}
		

	}

	@AfterTest
	public void afterTest() throws IOException {
		extent.flush();
		System.out.println("test end");
		System.out.println();
		driver.close();
		driver.quit();
		for (int i = 0; i < 10; i++) {
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		}
		
		logger.info("Closing browser");
		logger.info("Ending test ...");

	}

}
