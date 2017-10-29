package com.practice.test;

import com.practice.converter.Converter;
import com.practice.converter.impl.XMLConverter;

/**
 * This class instantiates XML converter and tests the functionalities in a
 * single thread.
 * 
 * @author anirbanpoddar
 *
 */
public class XMLConverterTest {

	public static void main(String[] args) {

		// Valid file.
		Converter xmlConverter = XMLConverter.getInstance();
		System.out.println(xmlConverter.getName() + " started at: " + xmlConverter.getCreationTimeStamp());
		xmlConverter.readAndConvert(".//test//input1.xml");

		// Invalid file.
		xmlConverter = XMLConverter.getInstance();
		System.out.println(xmlConverter.getName() + " started at: " + xmlConverter.getCreationTimeStamp());
		xmlConverter.readAndConvert(".//test//input2.xml");

		// Valid file
		xmlConverter = XMLConverter.getInstance();
		System.out.println(xmlConverter.getName() + " started at: " + xmlConverter.getCreationTimeStamp());
		xmlConverter.readAndConvert(".//test//input3.xml");

		// Print in the console and write in the file.
		XMLConverter.getInstance().print();
		XMLConverter.getInstance().write(".//test//TestOutput.txt");

	}

}
