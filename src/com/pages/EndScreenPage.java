package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

public class EndScreenPage extends BasePage {
	
	
	public void finish() throws Exception {
				
		// store issued coupon to desktop with dynamic name

				Robot robot = new Robot();
				String ReceiptName = "C:/workspace/Receipts/receipt" + ul.getCurrentTime() + ".xps";
				StringSelection ss = new StringSelection(ReceiptName);

				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

				ul.customWait(1);

				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
		// finish
				
				
				
				Boolean isPresent = 	driver.findElements(By.id("finishbtn")).size() > 0;

				if(isPresent.equals(true)) {
					ul.waitForConditionVisibility(By.id("finishbtn")).click();					
				}
				else {
					System.out.println("Finish Timeout!");
				}
		
		
		
	}

}
