package com.practice.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.practice.converter.constant.ConverterConstants;
import com.practice.converter.util.ConverterUtils;

/**
 * This JUNIT class tests the methods of ConverterUtils class.
 * 
 * @author anirbanpoddar
 *
 */
public class ConverterUtilsTest {

	// Properties to be used in test.
	private static Properties properties;

	@BeforeClass
	public static void setUp() {

		// Load properties.
		InputStream inputStream = ConverterUtilsTest.class.getClassLoader().getResourceAsStream("test.properties");
		if (inputStream != null) {
			properties = new Properties();
			try {
				properties.load(inputStream);
			} catch (IOException ioEx) {
				System.out.println("Test - Error in loading property file");
				System.out.println(ioEx.getMessage());
			} finally {
				try {
					inputStream.close();
				} catch (IOException ioEx) {
					System.out.println("Test - Error in loading property file");
					System.out.println(ioEx.getMessage());
				}
			}
		}

	}

	/**
	 * Tests the validateName method.
	 */
	@Test
	public void testValidateName() {

		// Positive test.
		assertTrue(ConverterUtils.validateName("ABC"));
		assertTrue(ConverterUtils.validateName("ABC XYZ"));

		// Negative test.
		assertFalse(ConverterUtils.validateName("ABC1"));
		assertFalse(ConverterUtils.validateName("ABC@#"));
		assertFalse(ConverterUtils.validateName("ABC1 XYZ"));
		assertFalse(ConverterUtils.validateName(""));
		assertFalse(ConverterUtils.validateName(null));

	}

	/**
	 * Tests validateTelephone method.
	 */
	@Test
	public void testValidateTelephone() {

		// Check properties.
		if (properties != null) {
			String telPrefix = properties.getProperty(ConverterConstants.TELPREFIX);
			String telMaxLength = properties.getProperty(ConverterConstants.TELMAXLENGTH);
			String telMinLength = properties.getProperty(ConverterConstants.TELMINLENGTH);
			if (telPrefix != null && !"".equals(telPrefix) && telMaxLength != null && !"".equals(telMaxLength)
					&& telMinLength != null && !"".equals(telMinLength)) {
				// Positive test.
				assertTrue(ConverterUtils.validateTelephone("004567890867", properties));

				// Negative test.
				assertFalse(ConverterUtils.validateTelephone("00456789086", properties));
				assertFalse(ConverterUtils.validateTelephone("04567890867", properties));
				assertFalse(ConverterUtils.validateTelephone("0045-67890867", properties));
				assertFalse(ConverterUtils.validateTelephone("ABC", properties));
				assertFalse(ConverterUtils.validateTelephone("0045@67890867", properties));
				assertFalse(ConverterUtils.validateTelephone("", properties));
				assertFalse(ConverterUtils.validateTelephone(null, properties));
				assertFalse(ConverterUtils.validateTelephone("004567890867", null));
			} else {
				System.out
						.println("Test - testValidateTelephone could not be executed because of error in properties.");
			}
		} else {
			System.out.println("Test - testValidateTelephone could not be executed because of error in properties.");
		}

	}

	/**
	 * Tests validateEmail method.
	 */
	@Test
	public void testValidateEmail() {

		// Positive test.
		assertTrue(ConverterUtils.validateEmail("abc@xyz.com"));
		assertTrue(ConverterUtils.validateEmail("abc@xyz.dk"));
		assertTrue(ConverterUtils.validateEmail("abc@xyz.co.in"));
		assertTrue(ConverterUtils.validateEmail("abc1@xyz.co.in"));
		assertTrue(ConverterUtils.validateEmail("123@xyz.dk"));
		assertTrue(ConverterUtils.validateEmail("abc@xyz1.com"));

		// Negative test.
		assertFalse(ConverterUtils.validateEmail("abc@xyz.com."));
		assertFalse(ConverterUtils.validateEmail("abcxyz.com"));
		assertFalse(ConverterUtils.validateEmail("@xyz.com"));
		assertFalse(ConverterUtils.validateEmail("12345"));
		assertFalse(ConverterUtils.validateEmail("@@."));
		assertFalse(ConverterUtils.validateEmail(""));
		assertFalse(ConverterUtils.validateEmail(null));

	}

	/**
	 * Tests validateType method.
	 */
	@Test
	public void testValidateType() {

		// Positive test.
		assertTrue(ConverterUtils.validateType("Global"));
		assertTrue(ConverterUtils.validateType("Local"));

		// Negative test.
		assertFalse(ConverterUtils.validateType("ABC"));
		assertFalse(ConverterUtils.validateType(""));
		assertFalse(ConverterUtils.validateType(null));

	}

	/**
	 * XMLConverterTest validateXMLSchema method.
	 */
	@Test
	public void testValidateXMLSchema() {

		// Positive test.
		try {
			assertTrue(ConverterUtils.validateXMLSchema(".//test//test.xsd", new File(".//test//test1.xml")));
		} catch (SAXException | IOException ex) {
			System.out.println("Test - " + ex.getMessage());
			assertFalse(true);
		}

		// Negative test.
		// <Name> node absent in company.
		try {
			assertFalse(ConverterUtils.validateXMLSchema(".//test//test.xsd", new File(".//test//test2.xml")));
		} catch (SAXException | IOException ex) {
			System.out.println("Test - " + ex.getMessage());
			assertFalse(false);
		}
		// <Email> node absent in employee.
		try {
			assertFalse(ConverterUtils.validateXMLSchema(".//test//test.xsd", new File(".//test//test3.xml")));
		} catch (SAXException | IOException ex) {
			System.out.println("Test - " + ex.getMessage());
			assertFalse(false);
		}
		// Two <Name> nodes in company.
		try {
			assertFalse(ConverterUtils.validateXMLSchema(".//test//test.xsd", new File(".//test//test4.xml")));
		} catch (SAXException | IOException ex) {
			System.out.println("Test - " + ex.getMessage());
			assertFalse(false);
		}
		// <Telephone> node is first in company.
		try {
			assertFalse(ConverterUtils.validateXMLSchema(".//test//test.xsd", new File(".//test//test5.xml")));
		} catch (SAXException | IOException ex) {
			System.out.println("Test - " + ex.getMessage());
			assertFalse(false);
		}
		// File with only root node.
		try {
			assertFalse(ConverterUtils.validateXMLSchema(".//test//test.xsd", new File(".//test//test6.xml")));
		} catch (SAXException | IOException ex) {
			System.out.println("Test - " + ex.getMessage());
			assertFalse(false);
		}

	}

}
