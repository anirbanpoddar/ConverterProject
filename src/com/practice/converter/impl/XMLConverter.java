package com.practice.converter.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.practice.converter.Converter;
import com.practice.converter.constant.ConverterConstants;
import com.practice.converter.util.ConverterUtils;
import com.practice.domain.Company;
import com.practice.domain.Employee;
import com.practice.domain.impl.CompanyImpl;
import com.practice.domain.impl.GlobalEmployeeImpl;
import com.practice.domain.impl.LocalEmployeeImpl;

/**
 * This singleton class provides the implementation of XML converter. It reads
 * input in XML format, parses and converts into domain model and writes in flat
 * file format or prints on console.
 * 
 * @author anirbanpoddar
 *
 */
public final class XMLConverter extends BaseConverter {

	// Companies map to store company structure.
	private static Map<String, Company> companies;

	/**
	 * Private constructor to prohibit this class to be instantiated.
	 */
	private XMLConverter() {
	}

	/**
	 * Instantiates the class only once even when multiple threads are accessing
	 * it.
	 * 
	 * @return Converter
	 */
	public static synchronized Converter getInstance() {
		// The whole method is synchronized as the setting of name and creation
		// time stamp was not done properly in double checking lock.

		if (instance == null) {
			instance = new XMLConverter();
			// Load the properties.
			loadProperties();
			if (properties != null) {
				// Set name and creation time stamp.
				name = properties.getProperty(ConverterConstants.XMLCONVNAME);
				DateFormat dateFormat = new SimpleDateFormat(properties.getProperty(ConverterConstants.DATEFORMATPROP));
				creationTimeStamp = dateFormat.format(new Date());
			} else {
				System.out.println(ConverterConstants.ERROR + ConverterConstants.PROPFILEERROR);
			}
			// Initialize companies map.
			companies = new ConcurrentHashMap<String, Company>();
		}
		return instance;

	}

	@Override
	public void readAndConvert(String inputFilePath) {

		// Flag to check the validity of the XML.
		boolean validXML = false;
		File xmlFile = new File(inputFilePath);
		if (xmlFile != null) {
			try {
				// Validate the XML file.
				validXML = ConverterUtils.validateXMLSchema(ConverterConstants.XSDFILEPATH, xmlFile);
			} catch (SAXException | IOException ex) {
				System.out.println(ConverterConstants.ERROR + ConverterConstants.XMLVALIDATIONERROR);
				System.out.println(ConverterConstants.ERROR + ex.getMessage());
			}
			if (validXML) {
				try {
					// Parse the XML file.
					parseXML(xmlFile);
				} catch (ParserConfigurationException | SAXException | IOException ex) {
					System.out.println(ConverterConstants.ERROR + ConverterConstants.XMLREADINGERROR);
					System.out.println(ConverterConstants.ERROR + ex.getMessage());
				}
			}
		}

	}

	@Override
	public void write(String outputFilePath) {

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath));
			if (bufferedWriter != null) {
				PrintWriter printWriter = new PrintWriter(bufferedWriter);
				if (printWriter != null) {
					if (companies != null && !companies.isEmpty()) {
						// Iterate through the companies.
						companies.forEach((key, value) -> {
							printWriter.println(ConverterConstants.LINESEPARATOR);
							printWriter.println(ConverterConstants.COMPANYINFORMATION + value.getInformation());
							printWriter.println(ConverterConstants.NAME + value.getName());
							printWriter.println(ConverterConstants.TELEPHONE + value.getTelephone());
							printWriter.println(ConverterConstants.EMAIL + value.getEmail());
							printWriter.println(ConverterConstants.ADDRESS + value.getAddress());
							printWriter.println(ConverterConstants.EMPLOYEES);
							
							List<Employee> employees = value.getEmployees();
							writeEmployee(employees, printWriter);
						});
					} else {
						printWriter.println(ConverterConstants.NOCOMMESSAGE);
					}
					printWriter.close();
				}
				bufferedWriter.close();
			}
		} catch (IOException ioEx) {
			System.out.println(ConverterConstants.ERROR + ConverterConstants.FILEWRITINGERROR);
			System.out.println(ConverterConstants.ERROR + ioEx.getMessage());
		}

	}

	@Override
	public void print() {

		if (companies != null && !companies.isEmpty()) {
			// Iterate through the companies.
			companies.forEach((key, value) -> {
				System.out.println(ConverterConstants.LINESEPARATOR);
				System.out.println(ConverterConstants.COMPANYINFORMATION + value.getInformation());
				System.out.println(ConverterConstants.NAME + value.getName());
				System.out.println(ConverterConstants.TELEPHONE + value.getTelephone());
				System.out.println(ConverterConstants.EMAIL + value.getEmail());
				System.out.println(ConverterConstants.ADDRESS + value.getAddress());
				System.out.println(ConverterConstants.EMPLOYEES);
				
				List<Employee> employees = value.getEmployees();
				if (employees != null && !employees.isEmpty()) {
					employees.forEach(item -> {
						System.out.println(item.getInformation());
						System.out.println(ConverterConstants.NAME + item.getName());
						System.out.println(ConverterConstants.TELEPHONE + item.getTelephone());
						System.out.println(ConverterConstants.EMAIL + item.getEmail());
						System.out.println(ConverterConstants.ADDRESS + item.getAddress());
						System.out.println(ConverterConstants.TYPE + item.getType());
					});
				} else {
					System.out.println(ConverterConstants.NOEMPMESSAGE);
				}
			});
		} else {
			System.out.println(ConverterConstants.NOCOMMESSAGE);
		}

	}

	/**
	 * Writes the employees.
	 * 
	 * @param List<Employee>
	 *            employees: Employee list.
	 * @param PrintWriter
	 *            printWriter: PrintWriter to write.
	 */
	private void writeEmployee(List<Employee> employees, PrintWriter printWriter) {

		if (employees != null && !employees.isEmpty()) {
			// Iterate through the employees.
			employees.forEach(item -> {
				printWriter.println(item.getInformation());
				printWriter.println(ConverterConstants.NAME + item.getName());
				printWriter.println(ConverterConstants.TELEPHONE + item.getTelephone());
				printWriter.println(ConverterConstants.EMAIL + item.getEmail());
				printWriter.println(ConverterConstants.ADDRESS + item.getAddress());
				printWriter.println(ConverterConstants.TYPE + item.getType());
			});
		} else {
			printWriter.println(ConverterConstants.NOEMPMESSAGE);
		}

	}

	/**
	 * Parses the XML file to read company and employee nodes.
	 * 
	 * @param File
	 *            xmlFile: The XML file to parse.
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private void parseXML(File xmlFile) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
		Document document = docBuilder.parse(xmlFile);
		document.getDocumentElement().normalize();
		NodeList comNodeList = document.getElementsByTagName(ConverterConstants.COMPANYNODE);
		
		// Iterate through company nodes.
		for (int comCount = 0; comCount < comNodeList.getLength(); comCount++) {
			Node comNode = comNodeList.item(comCount);
			if (comNode.getNodeType() == Node.ELEMENT_NODE) {
				Element comElement = (Element) comNode;
				// Parse company element.
				parseCompanyElement(comElement);
			}
		}

	}

	/**
	 * Parses company element.
	 * 
	 * @param Element
	 *            comElement: The company element to parse.
	 */
	private void parseCompanyElement(Element comElement) {

		String comName = comElement.getElementsByTagName(ConverterConstants.NAMENODE).item(0).getTextContent();
		String comTelephone = null;
		String comEmail = null;
		// Flag to check the validity of nodes in company.
		boolean validCom = false;

		// Check if name is present.
		if (comName != null && !"".equals(comName)) {
			comTelephone = comElement.getElementsByTagName(ConverterConstants.TELEPHONENODE).item(0).getTextContent();
			validCom = true;
		} else {
			System.out.println(ConverterConstants.ERROR + ConverterConstants.COMNAMEERROR + comName);
		}

		if (validCom) {
			// Check the validity of telephone number.
			if (ConverterUtils.validateTelephone(comTelephone, properties)) {
				comEmail = comElement.getElementsByTagName(ConverterConstants.EMAILNODE).item(0).getTextContent();
			} else {
				System.out.println(ConverterConstants.ERROR + ConverterConstants.COMTELEPHONEERROR + comTelephone);
				validCom = false;
			}
		}

		if (validCom) {
			// Check the validity of email id.
			if (ConverterUtils.validateEmail(comEmail)) {
				String comAddress = comElement.getElementsByTagName(ConverterConstants.ADDRESSNODE).item(0)
						.getTextContent();
				
				// Restrict multiple threads to access the companies map.
				synchronized (this) {
					// If company is not present then create new company.
					if (!companies.containsKey(comName)) {
						Map<String, Employee> employeeList = new ConcurrentHashMap<String, Employee>();
						Company company = new CompanyImpl(comName, comTelephone, comEmail, comAddress, employeeList);
						// Parse employees.
						parseEmployee(comElement, company);
						companies.put(comName, company);
					} else {
						// If company is present then update the information
						// based on name.
						Company company = companies.get(comName);
						company.setTelephone(comTelephone);
						company.setEmail(comEmail);
						company.setAddress(comAddress);
						// Parse company element to find employees.
						parseEmployee(comElement, company);
						companies.put(comName, company);
					}
				}
			} else {
				System.out.println(ConverterConstants.ERROR + ConverterConstants.COMEMAILERROR + comEmail);
			}
		}

	}

	/**
	 * Parses the company element to read employees.
	 * 
	 * @param Element
	 *            comElement: The company element to parse.
	 * @param Company
	 *            company: Company of the employees to be added to.
	 */
	private void parseEmployee(Element comElement, Company company) {

		NodeList empNodeList = comElement.getElementsByTagName(ConverterConstants.EMPLOYEENODE);
		for (int empCount = 0; empCount < empNodeList.getLength(); empCount++) {
			Node empNode = empNodeList.item(empCount);
			if (empNode.getNodeType() == Node.ELEMENT_NODE) {
				Element empElement = (Element) empNode;
				// Parse the employee element.
				parseEmployeeElement(empElement, company);
			}
		}

	}

	/**
	 * Parses the employee element.
	 * 
	 * @param Element
	 *            empElement: The employee element to parse.
	 * @param Company
	 *            company: Company of the employees to be added to.
	 */
	private void parseEmployeeElement(Element empElement, Company company) {

		String empEmail = empElement.getElementsByTagName(ConverterConstants.EMAILNODE).item(0).getTextContent();
		String empName = null;
		String empTelephone = null;
		String empType = null;
		// Flag to check the validity of nodes in employee.
		boolean validEmp = false;

		// Check the validity of email id.
		if (ConverterUtils.validateEmail(empEmail)) {
			empName = empElement.getElementsByTagName(ConverterConstants.NAMENODE).item(0).getTextContent();
			validEmp = true;
		} else {
			System.out.println(ConverterConstants.ERROR + ConverterConstants.EMPEMAILERROR + empEmail);
		}

		if (validEmp) {
			// Check the validity of name.
			if (ConverterUtils.validateName(empName)) {
				empTelephone = empElement.getElementsByTagName(ConverterConstants.TELEPHONENODE).item(0)
						.getTextContent();
			} else {
				System.out.println(ConverterConstants.ERROR + ConverterConstants.EMPNAMEERROR + empName);
				validEmp = false;
			}
		}

		if (validEmp) {
			// Check the validity of telephone number.
			if (ConverterUtils.validateTelephone(empTelephone, properties)) {
				empType = empElement.getElementsByTagName(ConverterConstants.TYPENODE).item(0).getTextContent();
			} else {
				System.out.println(ConverterConstants.ERROR + ConverterConstants.EMPTELEPHONEERROR + empTelephone);
				validEmp = false;
			}
		}

		if (validEmp) {
			// Check the validity of type.
			if (ConverterUtils.validateType(empType)) {
				String empAddress = empElement.getElementsByTagName(ConverterConstants.ADDRESSNODE).item(0)
						.getTextContent();
				Employee employee = null;
				if (ConverterConstants.EMPTYPEGLOBAL.equals(empType)) {
					employee = new GlobalEmployeeImpl(empName, empTelephone, empEmail, empAddress, empType);
				} else {
					employee = new LocalEmployeeImpl(empName, empTelephone, empEmail, empAddress, empType);
				}
				// Add or update employee to the company based on email id.
				company.addUpdateEmployee(empEmail, employee);
			} else {
				System.out.println(ConverterConstants.ERROR + ConverterConstants.EMPTYPEERROR + empType);
			}
		}

	}

}
