package com.practice;

import static org.ebayopensource.twin.Criteria.className;
import static org.ebayopensource.twin.Criteria.id;
import static org.ebayopensource.twin.Criteria.type;
import static org.ebayopensource.twin.Criteria.name;


import java.net.URL;

import org.ebayopensource.twin.Application;
import org.ebayopensource.twin.Element;
import org.ebayopensource.twin.TwinException;
import org.ebayopensource.twin.element.Pane;
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
		
		tab.getChild(name("Rental Options")).getChild(id("tabRentalOptions")).getChild(id("radioButtonMultiday")).click();
		tab.getChild(name("Rental Options")).getChild(id("tabRentalOptions")).getChild(name("Currency")).getChild(id("BillAcceptorDropDown")).click();
		tab.getChild(name("Rental Options")).getChild(id("tabRentalOptions")).getChild(name("Currency")).getChild(id("BillAcceptorDropDown")).getChild(id("ListBox")).getChild(name("MEI SCR")).click();
		
		window.getChild(id("TitleBar")).getChild(name("Close")).click();
	}

}
