package com.practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.pages.BasePage;

public class SocktWPE extends BasePage {

	public static Screen screen = new Screen();
	// public static UtilityLibrary ul;
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

	}

	public void listenSocketID(String server) throws Exception {

		Pattern image1 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture1.PNG");
		Pattern image2 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture2.PNG");
		Pattern image3 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture3.PNG");
		Pattern image4 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture4.PNG");

		// server images
		Pattern image5 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture5.PNG");
		Pattern image5_1 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture5_1.PNG");
		Pattern image5_2 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture5_2.PNG");
		Pattern image5_3 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture5_3.PNG");

		Pattern image6 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture6.PNG");
		Pattern image8 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture8.PNG");
		Pattern image7 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture7.PNG");
		Pattern image9 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture9.PNG");

		// packet images
		Pattern image10 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture10.PNG");
		Pattern image10_1 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture10_1.PNG");
		Pattern image10_2 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture10_2.PNG");
		Pattern image10_3 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture10_3.PNG");

		Pattern image11 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture11.PNG");
		Pattern image12 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture12.PNG");

		Pattern image16 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture16.PNG");
		Pattern image20 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture20.PNG");
		// screen.wait(image1);
		// screen.doubleClick(image1);
		// screen.doubleClick(image2);
		if (server.equalsIgnoreCase("scan")) {

			ul.executeBatFile("C:/Users/KioskUser/Desktop/wpe_Scan/WPE_PRO_Scan.exe");
		}

		else if (server.equalsIgnoreCase("rfid")) {

			ul.executeBatFile("C:/Users/KioskUser/Desktop/wpe_Scan/WPE_PRO_RFID.exe");

		}

		else if (server.equalsIgnoreCase("chinese")) {

			ul.executeBatFile("C:/Users/KioskUser/Desktop/wpe_Scan/WPE_PRO_Payment.exe");

		}

		else if (server.equalsIgnoreCase("paypros")) {

			ul.executeBatFile("C:/Users/KioskUser/Desktop/wpe_Scan/WPE_PRO_Cardsv.exe");

		}

		screen.wait(image3);
		screen.click(image3);
		screen.click(image4);

		if (server.equalsIgnoreCase("scan")) {
			screen.doubleClick(image5_1);

		}

		else if (server.equalsIgnoreCase("rfid")) {
			screen.doubleClick(image5_3);
		}

		else if (server.equalsIgnoreCase("chinese")) {
			screen.doubleClick(image5_2);
		}

		else if (server.equalsIgnoreCase("paypros")) {

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

		if (server.equalsIgnoreCase("scan")) {
			screen.click(image10_2);

			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);

			screen.doubleClick(image10_1);
		}

		else if (server.equalsIgnoreCase("rfid")) {
			screen.doubleClick(image10_2);
		}

		else if (server.equalsIgnoreCase("chinese")) {
			
			screen.click(image10_2);

			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
		
			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);
			
			
			screen.doubleClick(image10_3);
		}

		else if (server.equalsIgnoreCase("paypros")) {

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

	}

	public void setSocketID(String server) throws Exception {

		Robot robot = new Robot();
		// payment page
		Pattern image13 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture13.PNG");
		Pattern image14 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture14.PNG");
		Pattern image15 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture15.PNG");
		Pattern image19 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture19.PNG");
		
		Pattern image19_1 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture19_1.PNG");
		Pattern image19_2 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture19_2.PNG");
		Pattern image19_3 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture19_3.PNG");
		Pattern image19_4 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture19_4.PNG");
		
		
		
		// while (screen.exists(image13) == null) {
		//
		// robot.keyPress(KeyEvent.VK_ALT);
		//
		// robot.keyPress(KeyEvent.VK_TAB);
		//
		// robot.keyRelease(KeyEvent.VK_TAB);
		// robot.keyRelease(KeyEvent.VK_ALT);
		//
		// }

		// open Task manager
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		if (server.equalsIgnoreCase("scan")) {
			screen.doubleClick(image19_2);

		}

		else if (server.equalsIgnoreCase("rfid")) {
			screen.doubleClick(image19_1);
		}

		else if (server.equalsIgnoreCase("chinese")) {
			screen.doubleClick(image19_3);
		}

		else if (server.equalsIgnoreCase("paypros")) {

			screen.doubleClick(image19_4);
		}
		
		
		

		ul.customWait(1);

		screen.click(image13);
		screen.rightClick(image14);
		ul.customWait(1);
		screen.exists(image15);
		screen.click(image15);
	}

	public void playPacket_Paypros(String server) throws Exception {

		Robot robot = new Robot();
		Pattern image3 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture3.PNG");
		Pattern image11 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture11.PNG");

		Pattern image16 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture16.PNG");
		Pattern image17 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture17.PNG");

		Pattern image19 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture19.PNG");
		Pattern image20 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture20.PNG");
		
		
		Pattern image19_1 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture19_1.PNG");
		Pattern image19_2 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture19_2.PNG");
		Pattern image19_3 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture19_3.PNG");
		Pattern image19_4 = new Pattern("C:\\Users\\KioskUser\\Pictures\\Screen\\Capture19_4.PNG");
		
		// switch to WPE
		while (screen.exists(image3) == null) {

			

			// open Task manager
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			if (server.equalsIgnoreCase("scan")) {
				screen.doubleClick(image19_2);

			}

			else if (server.equalsIgnoreCase("rfid")) {
				screen.doubleClick(image19_1);
			}

			else if (server.equalsIgnoreCase("chinese")) {
				screen.doubleClick(image19_3);
			}

			else if (server.equalsIgnoreCase("paypros")) {

				screen.doubleClick(image19_4);
			}
			

		}

		screen.click(image16);

		screen.click(image17);
		// switch to IE
		screen.wait(image20);
		screen.click(image20);

		ul.customWait(1);

	}

}
