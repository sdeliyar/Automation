package com.practice;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class readXMLfiles {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// file path
		File xmlFile = new File("C:\\Lockers\\setup.xml");

		// create instance document builder

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(xmlFile);

		// get node list for xml
		NodeList nlXml = doc.getChildNodes();

		// get xml first node
		Node nXml = nlXml.item(0);

		// Assign node element
		Element element = (Element) nXml;

		// print by tag name
		System.err.println("KioskId: " + element.getElementsByTagName("facility").item(0).getTextContent());

	}

}
