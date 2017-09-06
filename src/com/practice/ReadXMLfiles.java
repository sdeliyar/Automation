package com.practice;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ReadXMLfiles {

	@Test
	public void xmls() throws ParserConfigurationException, SAXException, IOException, Exception {

		// System.out.println(readXMLgetPrice());

		// System.out.println(fromSetUpXML("", "rentaloption"));
		// System.out.println(fromPricingXML("MaxOvertimeCharge"));
		// System.out.println(fromAttendantsXML("At", "user"));
		// System.out.println(xmlElement("at", "SiteAdmin", 0, "PLSToken"));
		// System.out.println(elemntExistXml("se", "discounts"));

		// System.out.println(fromPricingMaxPrice());

		// System.out.println(configXml("PLSHost"));

		// System.out.println(readXMLgetPrice("Small"));

		// System.out.println(couponXml("text"));
	}

	public String fromSetUpXML(String secNodeNae, String tagName)

			throws ParserConfigurationException, SAXException, IOException, Exception {

		// file path
		File xmlFile = new File("C:\\Lockers\\setup.xml");

		// create instance document builder

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(xmlFile);

		// get node list for xml
		NodeList nlXml = doc.getElementsByTagName("setup");

		// get xml first node
		Node nXml = nlXml.item(0);

		// Assign node element
		Element element = (Element) nXml;

		// print by tag name

		String text = element.getElementsByTagName(tagName).item(0).getTextContent();

		if (secNodeNae != "") {
			// get node list for xml
			NodeList secNodeList = element.getElementsByTagName(secNodeNae);
			// get xml first node
			Node secnXml = secNodeList.item(0);

			// Assign node element
			Element secElement = (Element) secnXml;

			text = secElement.getElementsByTagName(tagName).item(0).getTextContent();

		}

		return text;
	}

	public String fromConfigXML(String tagName)
			throws ParserConfigurationException, SAXException, IOException, Exception {

		// file path
		File xmlFile = new File("C:\\Lockers\\config.xml");

		// create instance document builder

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(xmlFile);

		// get node list for xml

		NodeList nlXml = doc.getElementsByTagName("Facility");

		// get xml first node
		Node nXml = nlXml.item(0);

		// Assign node element
		Element element = (Element) nXml;

		// print by tag name

		NodeList secList = element.getElementsByTagName(tagName);

		Boolean exist = secList.getLength() == 0 ? false : true;

		String text = null;
		if (exist == false) {

		}

		else {
			text = element.getElementsByTagName(tagName).item(0).getTextContent();
		}

		return text;

	}

	public String fromPricingXML(String tagName)
			throws ParserConfigurationException, SAXException, IOException, Exception {

		// file path
		File xmlFile = new File("C:\\Lockers\\pricing.xml");

		// create instance document builder

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(xmlFile);

		// get node list for xml

		NodeList nlXml = doc.getElementsByTagName("Pricing");

		// get xml first node
		Node nXml = nlXml.item(0);

		// Assign node element
		Element element = (Element) nXml;

		// print by tag name

		String text = element.getElementsByTagName(tagName).item(0).getTextContent();

		return text;

	}

	public String fromExtrasXML(String tagName)
			throws ParserConfigurationException, SAXException, IOException, Exception {

		// file path
		File xmlFile = new File("C:\\Lockers\\extras.xml");

		// create instance document builder

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(xmlFile);

		// get node list for xml

		NodeList nlXml = doc.getElementsByTagName("extras");

		// get xml first node
		Node nXml = nlXml.item(0);

		// Assign node element
		Element element = (Element) nXml;

		// print by tag name

		String text = element.getElementsByTagName(tagName).item(0).getTextContent();

		return text;

	}

	public String fromAttendantsXML(String Type, String UserPass)
			throws ParserConfigurationException, SAXException, IOException, Exception {

		String UserInfo = null;
		// file path

		// create instance document builder

		Document doc = documentXmls(fileXmls("at"));

		// get node list for xml

		NodeList nlXml = doc.getElementsByTagName("Attendant");

		// get xml first node
		for (int i = 0; i < nlXml.getLength(); i++) {
			Node nXml = nlXml.item(i);

			// Assign node element
			Element element = (Element) nXml;
			String text = element.getElementsByTagName("Type").item(0).getTextContent();

			// print by tag name
			if (text.contains(Type)) {
				if (UserPass.contains("user")) {
					UserInfo = element.getElementsByTagName("SignOnCode").item(0).getTextContent();

				} else {
					UserInfo = element.getElementsByTagName("Password").item(0).getTextContent();

				}
				break;
			}

		}

		return UserInfo;

	}

	public String couponXml(String tagName)

			throws ParserConfigurationException, SAXException, IOException, Exception {

		// file path
		File xmlFile = new File("C:\\wpe\\coupon_test.xml");

		// create instance document builder

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(xmlFile);

		// get node list for xml
		NodeList nlXml = doc.getElementsByTagName("");

		// get xml first node
		Node nXml = nlXml.item(0);

		// Assign node element
		Element element = (Element) nXml;

		// print by tag name

		String text = element.getElementsByTagName(tagName).item(0).getTextContent();

		return text;
	}

	public int fromPricingMaxPrice() throws Exception {

		int MaxPrice = 0;
		// file path
		File xmlFile = new File("C:\\Lockers\\pricing.xml");

		// create instance document builder

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(xmlFile);

		// get node list for xml

		NodeList nlXml = doc.getElementsByTagName("Pricing");

		Node nXml = nlXml.item(0);
		// Assign node element
		Element element = (Element) nXml;

		// print by tag name

		NodeList nlXml1 = element.getElementsByTagName("RentalFee");

		for (int i = 0; i < nlXml1.getLength(); i++) {

			Node nXml1 = nlXml1.item(i);
			// Assign node element
			Element element1 = (Element) nXml1;
			String text = element1.getTextContent();

			if (Integer.parseInt(text) >= MaxPrice) {
				MaxPrice = Integer.parseInt(text);
			}

		}

		return MaxPrice;

	}

	public Document documentXmls(File xmlFile) throws ParserConfigurationException, SAXException, IOException {

		// create instance document builder

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(xmlFile);

		return doc;
	}
	// used for Rest Assured response XML
	public String readResponseXMLDocument(Document dc, String key) {
		// get node list for xml

		NodeList nlXml = dc.getElementsByTagName("response");

		// get xml first node
		Node nXml = nlXml.item(0);

		// Assign node element
		Element element = (Element) nXml;

		// print by tag name

		String text = element.getElementsByTagName(key).item(0).getTextContent();
		return text;
	}

	public File fileXmls(String xmlNm) {
		File xmlFile = null;

		if (xmlNm.equals("at")) {
			xmlFile = new File("C:\\Lockers\\attendants.xml");

		} else if (xmlNm.equals("se")) {
			xmlFile = new File("C:\\Lockers\\setup.xml");

		} else if (xmlNm.equals("co")) {
			xmlFile = new File("C:\\Lockers\\config.xml");

		} else if (xmlNm.equals("pr")) {
			xmlFile = new File("C:\\Lockers\\pricing.xml");

		} else if (xmlNm.equals("ex")) {
			xmlFile = new File("C:\\Lockers\\extras.xml");
		}

		return xmlFile;
	}

	public boolean elemntExistXml(String type, String tagName)
			throws ParserConfigurationException, SAXException, IOException, Exception {
		// create instance document builder

		Document doc = documentXmls(fileXmls(type));

		// get node list for xml

		NodeList nlXml = doc.getElementsByTagName("setup");

		// get xml first node
		Node nXml = nlXml.item(0);

		// Assign node element
		Element element = (Element) nXml;

		// print by tag name

		NodeList secList = element.getElementsByTagName(tagName);

		return secList.getLength() == 0 ? false : true;

	}

	public String readXMLgetPrice(String sizeLock)
			throws ParserConfigurationException, SAXException, IOException, Exception {

		// create instance document builder

		Document doc = documentXmls(fileXmls("pr"));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		// System.out.println(dtf.format(localDate));

		Calendar c = Calendar.getInstance();
		c.setTime(new SimpleDateFormat("dd/M/yyyy").parse(dtf.format(localDate)));
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		DateTimeFormatter dtft = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String currentTime = dtft.format(now);

		// System.out.println(dtft.format(now));

		// check current day of week belong to weekend or or
		NodeList weekDayList = xmlElement("pr", "PricingSchedule", 0).getChildNodes();
		// System.out.println(weekDayList.item(dayOfWeek * 2 -
		// 1).getNodeName());

		NodeList pricingList = doc.getElementsByTagName("PricingStructure");
		Element currentWeekElement = null;

		for (int i = 0; i < pricingList.getLength(); i++) {
			Node weekdayList = pricingList.item(i);

			Element weekElement = (Element) weekdayList;

			if (weekElement.getAttribute("schedule").equals(weekDayList.item(dayOfWeek * 2 - 1).getNodeName())) {

				currentWeekElement = (Element) weekdayList;
			}

		}

		// get current time and detect which timeofdate that belongs to

		NodeList nodeList = currentWeekElement.getElementsByTagName("TimeOfDay");
		Element currenttimeofdElement = null;

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node theNote = nodeList.item(i);
			Element noteElement = (Element) theNote;

			SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
			Date StartTime = parser.parse(noteElement.getElementsByTagName("StartTime").item(0).getTextContent());
			Date EndTime = parser.parse(noteElement.getElementsByTagName("EndTime").item(0).getTextContent());
			Date currentTimeFormat = parser.parse(currentTime);
			if (currentTimeFormat.equals(StartTime) || currentTimeFormat.equals(EndTime)) {

				// System.out.println("equals");
				currenttimeofdElement = (Element) theNote;
				break;

			}

			else if (currentTimeFormat.after(StartTime) && currentTimeFormat.before(EndTime)) {

				// System.out.println("between");
				currenttimeofdElement = (Element) theNote;
				break;
			} else if (i + 1 == nodeList.getLength()) {
				// System.out.println("finalone");
				currenttimeofdElement = (Element) theNote;

			}

		}
		String givenHour = "1";
		// based on how many hours
		NodeList childNode = currenttimeofdElement.getElementsByTagName("Rental");

		Element howmanyHoursElement = null;

		for (int i = 0; i < childNode.getLength(); i++) {
			Node rental = childNode.item(i);
			Element rentalEle = (Element) rental;

			if (rentalEle.getElementsByTagName("RentalTime").item(0).getTextContent().contains(givenHour)) {

				howmanyHoursElement = (Element) rental;
			}

		}

		// based on which size

		NodeList smallNode = howmanyHoursElement.getElementsByTagName(sizeLock);

		Node small = smallNode.item(0);
		Element smallEle = (Element) small;

		String price = smallEle.getElementsByTagName("RentalFee").item(0).getTextContent();
		return price;

	}

	public Element xmlElement(String xmlNm, String NodeListTag, int nodeItem)
			throws ParserConfigurationException, SAXException, IOException {

		// create instance document builder

		Document doc = documentXmls(fileXmls(xmlNm));

		NodeList pricingList = doc.getElementsByTagName(NodeListTag);
		Node weekdayList = pricingList.item(nodeItem);
		Element weekElement = (Element) weekdayList;
		return weekElement;
	}

	public String xmlElement(String xmlNm, String NodeListTag, int nodeItem, String chilNodeTag)
			throws ParserConfigurationException, SAXException, IOException {

		// create instance document builder

		Document doc = documentXmls(fileXmls(xmlNm));

		NodeList nodeList = doc.getElementsByTagName(NodeListTag);
		Node node = nodeList.item(nodeItem);
		Element element = (Element) node;

		String value = element.getElementsByTagName(chilNodeTag).item(0).getTextContent();
		return value;
	}

	public String convertDocumentToString(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tf.newTransformer();
			// below code to remove XML declaration
			// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
			// "yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			String output = writer.getBuffer().toString();
			return output;
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Document convertStringToDocument(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
