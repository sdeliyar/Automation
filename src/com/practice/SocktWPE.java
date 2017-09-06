package com.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.pages.BasePage;

public class SocktWPE extends BasePage {

	Pattern image1 = new Pattern("C:\\Screen\\Capture1.PNG");
	Pattern image2 = new Pattern("C:\\Screen\\Capture2.PNG");
	Pattern image3 = new Pattern("C:\\Screen\\Capture3.PNG");
	Pattern image4 = new Pattern("C:\\Screen\\Capture4.PNG");

	// server images
	Pattern image5 = new Pattern("C:\\Screen\\Capture5.PNG");
	Pattern image5_1 = new Pattern("C:\\Screen\\Capture5_1.PNG");
	Pattern image5_2 = new Pattern("C:\\Screen\\Capture5_2.PNG");
	Pattern image5_3 = new Pattern("C:\\Screen\\Capture5_3.PNG");
	Pattern image5_4 = new Pattern("C:\\Screen\\Capture5_4.PNG");
	Pattern image5_5 = new Pattern("C:\\Screen\\Capture5_5.PNG");
	Pattern image5_6 = new Pattern("C:\\Screen\\Capture5_6.PNG");
	Pattern image6 = new Pattern("C:\\Screen\\Capture6.PNG");
	Pattern image8 = new Pattern("C:\\Screen\\Capture8.PNG");
	Pattern image7 = new Pattern("C:\\Screen\\Capture7.PNG");
	Pattern image9 = new Pattern("C:\\Screen\\Capture9.PNG");

	// packet images
	Pattern image10 = new Pattern("C:\\Screen\\Capture10.PNG");
	Pattern image10_1 = new Pattern("C:\\Screen\\Capture10_1.PNG");
	Pattern image10_2 = new Pattern("C:\\Screen\\Capture10_2.PNG");
	Pattern image10_3 = new Pattern("C:\\Screen\\Capture10_3.PNG");
	Pattern image10_4 = new Pattern("C:\\Screen\\Capture10_4.PNG");
	Pattern image10_5 = new Pattern("C:\\Screen\\Capture10_5.PNG");
	Pattern image10_6 = new Pattern("C:\\Screen\\Capture10_6.PNG");
	Pattern image11 = new Pattern("C:\\Screen\\Capture11.PNG");
	Pattern image11_1 = new Pattern("C:\\Screen\\Capture11_1.PNG");
	Pattern image11_2 = new Pattern("C:\\Screen\\Capture11_2.PNG");
	Pattern image11_d = new Pattern("C:\\Screen\\Capture11_d.PNG");
	Pattern image11_d1 = new Pattern("C:\\Screen\\Capture11_d1.PNG");
	Pattern image11_d2 = new Pattern("C:\\Screen\\Capture11_d2.PNG");
	Pattern image11_v = new Pattern("C:\\Screen\\Capture11_v.PNG");
	Pattern image11_v1 = new Pattern("C:\\Screen\\Capture11_v1.PNG");
	Pattern image11_v2 = new Pattern("C:\\Screen\\Capture11_v2.PNG");
	Pattern image11_m = new Pattern("C:\\Screen\\Capture11_m.PNG");
	Pattern image11_m1 = new Pattern("C:\\Screen\\Capture11_m1.PNG");
	Pattern image11_m2 = new Pattern("C:\\Screen\\Capture11_m2.PNG");

	Pattern image12 = new Pattern("C:\\Screen\\Capture12.PNG");
	Pattern image13 = new Pattern("C:\\Screen\\Capture13.PNG");
	Pattern image13_1 = new Pattern("C:\\Screen\\Capture13_1.PNG");
	Pattern image14 = new Pattern("C:\\Screen\\Capture14.PNG");
	Pattern image15 = new Pattern("C:\\Screen\\Capture15.PNG");
	Pattern image16 = new Pattern("C:\\Screen\\Capture16.PNG");
	Pattern image17 = new Pattern("C:\\Screen\\Capture17.PNG");
	Pattern image19_1 = new Pattern("C:\\Screen\\Capture19_1.PNG");
	Pattern image19_2 = new Pattern("C:\\Screen\\Capture19_2.PNG");
	Pattern image19_2_1 = new Pattern("C:\\Screen\\Capture19_2_1.PNG");
	Pattern image19_3 = new Pattern("C:\\Screen\\Capture19_3.PNG");
	Pattern image19_4 = new Pattern("C:\\Screen\\Capture19_4.PNG");
	Pattern image19_5 = new Pattern("C:\\Screen\\Capture19_5.PNG");
	Pattern image19_51 = new Pattern("C:\\Screen\\Capture19_51.PNG");
	Pattern image19_6 = new Pattern("C:\\Screen\\Capture19_6.PNG");
	Pattern image19_7 = new Pattern("C:\\Screen\\Capture19_7.PNG");
	Pattern image20 = new Pattern("C:\\Screen\\Capture20.PNG");

	public static Screen screen = new Screen();
	// public static UtilityLibrary ul;
	public static WebDriver driver;
	ReadXMLfiles readXml = new ReadXMLfiles();

	@Test
	public void packet() throws Exception {
		listenSocketID("CC");
		changePacket("CC", "DIS");
		changePacket("CC", "VISA");
		changePacket("CC", "MC");
		

	}

	public void listenSocketID(String type) throws Exception {

		String SocketType = null;
		// screen.wait(image1);
		// screen.doubleClick(image1);
		// screen.doubleClick(image2);
		if (type.equals("CC")) {
			SocketType = readXml.fromSetUpXML("", "processor");
		} else if (type.equals("Bill")) {
			SocketType = readXml.fromSetUpXML("", "billacceptor");
		} else if (type.equals("Dis")) {
			SocketType = "scan";
		}

		if (SocketType.equals("scan")) {

			ul.executeBatFile("C:\\wpe_scan\\WPE_PRO_scan.exe");
		}

		else if (SocketType.equals("Hong Kong") || SocketType.equals("PayPros")) {

			ul.executeBatFile("C:\\wpe\\WPE_PRO.exe");

		}

		else if (SocketType.equals("SCRxxAdv") || SocketType.equals("AE2000") || SocketType.equals("VNR2700")) {

			ul.executeBatFile("C:\\wpe_bill\\WPE_PRO_cash.exe");

		}

		ul.customWait(1);
		screen.wait(image3);
		screen.click(image3);
		screen.click(image4);

		if (SocketType.equals("AE2000")) {
			screen.doubleClick(image5_6);

		}

		else if (SocketType.equals("scan")) {
			screen.doubleClick(image5_1);
		}

		else if (SocketType.equals("SCRxxAdv")) {
			screen.doubleClick(image5_5);
		} else if (SocketType.equals("Hong Kong")) {
			screen.doubleClick(image5_4);
		} else if (SocketType.equals("PayPros")) {

			screen.doubleClick(image5);
		}

		Robot robot = new Robot();

		// robot.keyPress(KeyEvent.VK_C);
		// robot.keyRelease(KeyEvent.VK_C);
		// robot.keyPress(KeyEvent.VK_A);
		// robot.keyRelease(KeyEvent.VK_A);

		// screen.click(image8);
		// screen.click(image6);

		screen.click(image7);
		screen.click(image9);
		ul.customWait(1);

		if (SocketType.equals("scan")) {
			screen.click(image10_2);

			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			screen.wait(image10_1);
			screen.doubleClick(image10_1);
		}

		else if (SocketType.equals("AE2000")) {
			screen.doubleClick(image10_6);
		}

		else if (SocketType.equals("SCRxxAdv")) {

			screen.click(image10_2);

			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);

			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);

			screen.doubleClick(image10_5);
		} else if (SocketType.equals("Hong Kong")) {

			screen.click(image10_2);

			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);

			screen.doubleClick(image10_4);
		}

		else if (SocketType.equals("PayPros")) {

			screen.click(image10_2);

			robot.keyPress(KeyEvent.VK_P);
			robot.keyRelease(KeyEvent.VK_P);

			screen.doubleClick(image10);
		}

		// check packet
		screen.click(image11);

		screen.click(image12);
		// press WIN and click IE icon to swtich
		// robot.keyPress(KeyEvent.VK_WINDOWS);
		// robot.keyRelease(KeyEvent.VK_WINDOWS);

		screen.wait(image20);
		screen.click(image20);
		ul.customWait(1);
	}

	public void capturePacket(String type) throws Exception {
		Robot robot = new Robot();
		// payment page

		String SocketType = null;

		if (type.equals("CC")) {
			SocketType = readXml.fromSetUpXML("", "processor");
		} else if (type.equals("Bill")) {
			SocketType = readXml.fromSetUpXML("", "billacceptor");
		} else if (type.equals("Dis")) {
			SocketType = "scan";
		}

		// open Task manager
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_ESCAPE);

		robot.keyRelease(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		if (SocketType.equals("scan")) {
			screen.doubleClick(image19_2);

		}

		else if (SocketType.equals("AE2000")) {
			screen.doubleClick(image19_7);
		}

		else if (SocketType.equals("SCRxxAdv")) {
			screen.doubleClick(image19_6);
		} else if (SocketType.equals("Hong Kong")) {
			screen.doubleClick(image19_5);
		}

		else if (SocketType.equals("PayPros")) {

			screen.doubleClick(image19_4);
		}

		screen.click(image12);
		screen.wait(image20);
		screen.click(image20);
		ul.customWait(1);
	}

	public void setSocketID(String type) throws Exception {
		ul.customWait(1);
		Robot robot = new Robot();
		// payment page

		String SocketType = null;

		if (type.equals("CC")) {
			SocketType = readXml.fromSetUpXML("", "processor");
		} else if (type.equals("Bill")) {
			SocketType = readXml.fromSetUpXML("", "billacceptor");
		} else if (type.equals("Dis")) {
			SocketType = "scan";
		}

		// open Task manager
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_ESCAPE);

		robot.keyRelease(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		while (screen.exists(image13) == null) {
			// open Task manager
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_ESCAPE);

			robot.keyRelease(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			if (SocketType.equals("scan")) {
				if (screen.exists(image19_2) == null) {
					screen.doubleClick(image19_2);
				}
				screen.doubleClick(image19_2_1);

			}

			else if (SocketType.equals("AE2000")) {
				screen.doubleClick(image19_7);
			}

			else if (SocketType.equals("SCRxxAdv")) {
				screen.doubleClick(image19_6);
			} else if (SocketType.equals("Hong Kong")) {
				screen.doubleClick(image19_5);
			}

			else if (SocketType.equals("PayPros")) {
				screen.wait(image19_4);
				screen.doubleClick(image19_4);
			}
		}
		// while (screen.exists(image13_1) != null) {
		// screen.wait();
		//
		// }
		screen.wait(image13);
		screen.click(image13);

		screen.rightClick(image14);
		ul.customWait(1);
		screen.exists(image15);
		screen.click(image15);
		ul.customWait(1);
	}

	public void changePacket(String type, String cardType)
			throws ParserConfigurationException, SAXException, IOException, Exception {

		Robot robot = new Robot();
		String SocketType = null;

		if (type.equals("CC")) {
			SocketType = readXml.fromSetUpXML("", "processor");
		} else if (type.equals("Bill")) {
			SocketType = readXml.fromSetUpXML("", "billacceptor");
		} else if (type.equals("Dis")) {
			SocketType = "scan";
		}

		do {
			// open Task manager
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_ESCAPE);

			robot.keyRelease(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			if (SocketType.equals("scan")) {
				if (screen.exists(image19_2) == null) {
					screen.doubleClick(image19_2);
				}
				screen.doubleClick(image19_2_1);

			}

			else if (SocketType.equals("AE2000")) {
				screen.doubleClick(image19_7);
			}

			else if (SocketType.equals("SCRxxAdv")) {
				screen.doubleClick(image19_6);
			} else if (SocketType.equals("Hong Kong")) {
				screen.doubleClick(image19_5);
			}

			else if (SocketType.equals("PayPros")) {

				screen.doubleClick(image19_4);
			}

		} while (screen.exists(image16) == null);

		if (SocketType.equals("AE2000")) {
			screen.doubleClick(image19_7);

		}

		else if (SocketType.equals("scan")) {
			screen.doubleClick(image19_2);
		}

		else if (SocketType.equals("SCRxxAdv")) {
			screen.doubleClick();
		} else if (SocketType.equals("Hong Kong")) {
			screen.click(image11_1);
			screen.click(image11_2);
		}

		else if (SocketType.equals("PayPros")) {

			if (cardType.contains("MC")) {
				ul.customWait(1);
				if (screen.exists(image11_v2) != null) {
					screen.click(image11_v1);
				} else if (screen.exists(image11_m2) != null) {
					screen.click(image11_m1);
				} else if (screen.exists(image11_d2) != null) {
					screen.click(image11_d1);
				}
				screen.click(image11_m);
			} else if (cardType.contains("VISA")) {
				ul.customWait(1);
				if (screen.exists(image11_d2) != null) {
					screen.click(image11_d1);
				} else if (screen.exists(image11_v2) != null) {
					screen.click(image11_v1);
				} else if (screen.exists(image11_m2) != null) {
					screen.click(image11_m1);
				}

				screen.click(image11_v);
			} else if (cardType.contains("DIS")) {
				ul.customWait(1);
				if (screen.exists(image11_m2) != null) {
					screen.click(image11_m1);
				} else if (screen.exists(image11_v2) != null) {
					screen.click(image11_v1);
				} else if (screen.exists(image11_d2) != null) {
					screen.click(image11_d1);
				}
				screen.click(image11_d);
			}

		}

	}

	public void playPacket_Service(String type) throws Exception {

		Robot robot = new Robot();

		String SocketType = null;

		if (type.equals("CC")) {
			SocketType = readXml.fromSetUpXML("", "processor");
		} else if (type.equals("Bill")) {
			SocketType = readXml.fromSetUpXML("", "billacceptor");
		} else if (type.equals("Dis")) {
			SocketType = "scan";
		}
		ul.customWait(2);
		// switch to WPE
		while (screen.exists(image3) == null) {

			// open Task manager
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_ESCAPE);

			robot.keyRelease(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			if (SocketType.equals("scan")) {
				screen.doubleClick(image19_2);

			}

			else if (SocketType.equals("AE2000")) {
				screen.doubleClick(image19_7);
			}

			else if (SocketType.equals("SCRxxAdv")) {
				screen.doubleClick(image19_6);
			} else if (SocketType.equals("Hong Kong")) {
				screen.doubleClick(image19_5);
			} else if (SocketType.equals("PayPros")) {
				screen.wait(image19_4);
				screen.doubleClick(image19_4);
			}

		}

		screen.click(image16);

		screen.click(image17);

		if (type.equals("Bill")) {
			Thread.sleep(2 * 1000);
		}

		// switch to IE
		screen.wait(image20);
		screen.click(image20);
		ul.highlightElement(By.xpath(".//div[@class='container']/div[@class='row'][5]"));

		ul.customWait(1);

	}

}
