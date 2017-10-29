package com.practice.converter.constant;

/**
 * This class contains all the constants used in the converter.
 * 
 * @author anirbanpoddar
 *
 */
public class ConverterConstants {

	/**
	 * Private constructor to prohibit this class to be instantiated.
	 */
	private ConverterConstants() {
	}

	/**
	 * Constant for the name of the property file.
	 */
	public static final String PROPFILENAME = "converter.properties";

	/**
	 * Constant for property file loading error message.
	 */
	public static final String PROPFILEERROR = "Error in reading property file.";

	/**
	 * Constant for the name of the XMLConverter in the property file.
	 */
	public static final String XMLCONVNAME = "XMLConverter.name";

	/**
	 * Constant for the date format in the property file.
	 */
	public static final String DATEFORMATPROP = "DateFormat";

	/**
	 * Constant for the telephone number prefix in the property file.
	 */
	public static final String TELPREFIX = "Telephone.Prefix";

	/**
	 * Constant for the telephone number maximum length in the property file.
	 */
	public static final String TELMAXLENGTH = "Telephone.MaxLength";

	/**
	 * Constant for the telephone number minimum length in the property file.
	 */
	public static final String TELMINLENGTH = "Telephone.MinLength";

	/**
	 * Constant for the path of XSD file.
	 */
	public static final String XSDFILEPATH = ".//src//input.xsd";

	/**
	 * Constant for XML file validation error message.
	 */
	public static final String XMLVALIDATIONERROR = "Error in validating input XML file.";

	/**
	 * Constant for XML file reading error message.
	 */
	public static final String XMLREADINGERROR = "Error in reading input XML file.";

	/**
	 * Constant for the local employee type.
	 */
	public static final String EMPTYPELOCAL = "Local";

	/**
	 * Constant for the global employee type.
	 */
	public static final String EMPTYPEGLOBAL = "Global";

	/**
	 * Constant for error identification in the console.
	 */
	public static final String ERROR = "Error - ";

	/**
	 * Constant for line separator.
	 */
	public static final String LINESEPARATOR = "----------------------------------------------------------------------------";

	/**
	 * Constant for Company Information.
	 */
	public static final String COMPANYINFORMATION = "Company Information -  ";

	/**
	 * Constant for Name.
	 */
	public static final String NAME = "Name - ";

	/**
	 * Constant for Telephone.
	 */
	public static final String TELEPHONE = "Telephone - ";

	/**
	 * Constant for Email.
	 */
	public static final String EMAIL = "Email - ";

	/**
	 * Constant for Address.
	 */
	public static final String ADDRESS = "Address - ";

	/**
	 * Constant for Employees.
	 */
	public static final String EMPLOYEES = "Employees - ";

	/**
	 * Constant for Type.
	 */
	public static final String TYPE = "Type - ";

	/**
	 * Constant for no employee message.
	 */
	public static final String NOEMPMESSAGE = "No employee exists!";

	/**
	 * Constant for no company message.
	 */
	public static final String NOCOMMESSAGE = "No company exists!";

	/**
	 * Constant for file writing error message..
	 */
	public static final String FILEWRITINGERROR = "Error in writing file.";

	/**
	 * Constant for company node name.
	 */
	public static final String COMPANYNODE = "Company";

	/**
	 * Constant for name node name.
	 */
	public static final String NAMENODE = "Name";

	/**
	 * Constant for telephone node name.
	 */
	public static final String TELEPHONENODE = "Telephone";

	/**
	 * Constant for email node name.
	 */
	public static final String EMAILNODE = "Email";

	/**
	 * Constant for address node name.
	 */
	public static final String ADDRESSNODE = "Address";

	/**
	 * Constant for employee node name.
	 */
	public static final String EMPLOYEENODE = "Employee";

	/**
	 * Constant for type node name.
	 */
	public static final String TYPENODE = "Type";

	/**
	 * Constant for company name invalid error message..
	 */
	public static final String COMNAMEERROR = "Company name invalid: ";

	/**
	 * Constant for company telephone invalid error message..
	 */
	public static final String COMTELEPHONEERROR = "Company telephone invalid: ";

	/**
	 * Constant for company email invalid error message..
	 */
	public static final String COMEMAILERROR = "Company email invalid: ";

	/**
	 * Constant for employee name invalid error message..
	 */
	public static final String EMPNAMEERROR = "Employee name invalid: ";

	/**
	 * Constant for employee telephone invalid error message..
	 */
	public static final String EMPTELEPHONEERROR = "Employee telephone invalid: ";

	/**
	 * Constant for employee email invalid error message..
	 */
	public static final String EMPEMAILERROR = "Employee email invalid: ";

	/**
	 * Constant for employee type invalid error message..
	 */
	public static final String EMPTYPEERROR = "Employee type invalid: ";

}
