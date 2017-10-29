package com.practice.converter.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.xml.sax.SAXException;

import com.practice.converter.constant.ConverterConstants;

/**
 * This class contains all the utility methods used in the converter.
 * 
 * @author anirbanpoddar
 *
 */
public class ConverterUtils {

	/**
	 * Private constructor to prohibit this class to be instantiated.
	 */
	private ConverterUtils() {
	}

	/**
	 * Validates the name.
	 * 
	 * @param String
	 *            name: The name to be validated.
	 * @return boolean
	 */
	public static boolean validateName(String name) {

		boolean valid = false;
		// Null and blank check.
		if (name != null && !"".equals(name)) {
			// It should only contain characters and spaces.
			name = name.replaceAll("\\s", "");
			valid = name.chars().allMatch(Character::isLetter);
		}
		return valid;

	}

	/**
	 * Validates the telephone number.
	 * 
	 * @param Sring
	 *            telephone: The telephone number to be validated.
	 * @param Properties
	 *            properties: Properties to be used for validation.
	 * @return boolean
	 */
	public static boolean validateTelephone(String telephone, Properties properties) {

		boolean valid = false;
		// Null and blank check for the parameters.
		if (telephone != null && !"".equals(telephone) && StringUtils.isNumeric(telephone) && properties != null) {
			String telPrefix = properties.getProperty(ConverterConstants.TELPREFIX);
			String telMaxLength = properties.getProperty(ConverterConstants.TELMAXLENGTH);
			String telMinLength = properties.getProperty(ConverterConstants.TELMINLENGTH);

			// Check for the prefix, maximum and minimum length provided in the
			// properties.
			if (telPrefix != null && StringUtils.isNumeric(telMaxLength) && StringUtils.isNumeric(telMinLength)) {
				if (telephone.startsWith(telPrefix) && telephone.length() >= Integer.parseInt(telMinLength)
						&& telephone.length() <= Integer.parseInt(telMaxLength)) {
					valid = true;
				}
			}
		}
		return valid;

	}

	/**
	 * Validates the email id.
	 * 
	 * @param String
	 *            email: The email id to be validated.
	 * @return boolean
	 */
	public static boolean validateEmail(String email) {

		boolean valid = EmailValidator.getInstance().isValid(email);
		return valid;

	}

	/**
	 * Validates the employee type.
	 * 
	 * @param String
	 *            type: The type to be validated.
	 * @return boolean
	 */
	public static boolean validateType(String type) {

		boolean valid = false;
		// Type can be Global or Local.
		if (ConverterConstants.EMPTYPELOCAL.equals(type) || ConverterConstants.EMPTYPEGLOBAL.equals(type)) {
			valid = true;
		}
		return valid;

	}

	/**
	 * Validates the XML file with the XSD from the path.
	 * 
	 * @param String
	 *            xsdPath: The path of the XSD file.
	 * @param String
	 *            xmlFile: The XML file to be validated.
	 * @return boolean true: If validation is successful else throw exception.
	 * @throws SAXException
	 * @throws IOException
	 */
	public static boolean validateXMLSchema(String xsdPath, File xmlFile) throws SAXException, IOException {

		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(new File(xsdPath));
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource(xmlFile));
		return true;

	}

}
