package com.practice;

import static org.ebayopensource.twin.Criteria.id;
import static org.ebayopensource.twin.Criteria.name;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;

import org.ebayopensource.twin.Application;
import org.ebayopensource.twin.TwinException;
import org.ebayopensource.twin.element.Button;
import org.ebayopensource.twin.element.Spinner;
import org.ebayopensource.twin.element.Tab;
import org.ebayopensource.twin.element.Window;

public class practice {

	public static void main(String[] args) throws TwinException, Exception {
		Application app = new Application(new URL("http://127.0.0.1:4444/"));
		app.open("goPod", null);
		Window window = app.getWindow();

		// Pane pane = window.getChild(type(Pane.class));

		window.getChild(id("6")).click();

		window = app.getWindow();

		Tab tab = window.getChild(id("tabcontrol"));
		// click basic tab
		tab.getChild(name("Basics")).focus();

		// MinCop
		Spinner MinCop = tab.getChild(name("Basics")).getChild(name("Basics")).getChild(id("numericUpDownCouponMin"))
				.getChild(id("numericUpDownCouponMin"));
		MinCop.focus();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);

		MinCop.sendKeys("0");

		// MaxCop
		Spinner MaxCop = tab.getChild(name("Basics")).getChild(name("Basics")).getChild(id("numericUpDownCouponMax"))
				.getChild(id("numericUpDownCouponMax"));
		MaxCop.focus();
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		MaxCop.sendKeys("80");
		// IntervalCop
		Spinner IntervalCop = tab.getChild(name("Basics")).getChild(name("Basics"))
				.getChild(id("numericUpDownCouponInterval")).getChild(name("Coupon Max"));
		IntervalCop.focus();
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		IntervalCop.sendKeys("3");
		
		Button SaveAll = tab.getChild(name("Basics")).getChild(name("Basics"))
				.getChild(id("buttonSaveAll"));
		SaveAll.click();
		
		// tab.getChild(name("Basics")).getChild(name("Basics")).getChild(id("numericUpDownCouponMin"))
		// .getChild(name("Spinner")).getChild(id("SmallDecrement")).click();
		// tab.getChild(name("Basics")).getChild(name("Basics")).getChild(id("numericUpDownCouponMin"))
		// .getChild(name("Spinner")).getChild(id("SmallDecrement")).click();
		// tab.getChild(name("Basics")).getChild(name("Basics")).getChild(id("numericUpDownCouponMin"))
		// .getChild(name("Spinner")).getChild(id("SmallDecrement")).click();
		//
		// tab.getChild(name("Basics")).getChild(name("Basics")).getChild(id("buttonUploadConfig")).click();
		//
		// tab.getChild(name("Basics")).getChild(name("Basics")).getChild(id("buttonUploadConfig")).click();

		// Options")).getChild(id("tabRentalOptions")).getChild(id("radioButtonMultiday")).click();
		// tab.getChild(name("Rental
		// Options")).getChild(id("tabRentalOptions")).getChild(name("Currency")).getChild(id("BillAcceptorDropDown")).click();
		// tab.getChild(name("Rental
		// Options")).getChild(id("tabRentalOptions")).getChild(name("Currency")).getChild(id("BillAcceptorDropDown")).getChild(id("ListBox")).getChild(name("MEI
		// SCR")).click();
		//
		 window.getChild(id("TitleBar")).getChild(name("Close")).click();
	}

}
