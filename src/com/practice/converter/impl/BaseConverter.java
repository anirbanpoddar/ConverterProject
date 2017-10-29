package com.practice.converter.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.practice.converter.Converter;
import com.practice.converter.constant.ConverterConstants;

/**
 * This class provides the basic functionalities of the converter. These
 * functionalities can be overridden in the subclasses and specific
 * functionalities are implemented in the specific converter subclasses.
 * 
 * @author anirbanpoddar
 *
 */
public abstract class BaseConverter implements Converter {

	// Converter subclasses should be singleton. So, the instance of this
	// abstract class is private and static.
	protected static BaseConverter instance;
	
	// Name of the converter.
	protected static String name;
	
	// Creation time stamp of the converter.
	protected static String creationTimeStamp;
	
	// Properties to be used in the converter.
	protected static Properties properties;

	@Override
	public String getName() {

		return name;

	}

	@Override
	public String getCreationTimeStamp() {

		return creationTimeStamp;

	}

	/**
	 * Load the properties from the property file.
	 */
	protected static void loadProperties() {

		// Load the properties file from class path. [Physical path
		// implementation can also be used.]
		InputStream inputStream = BaseConverter.class.getClassLoader()
				.getResourceAsStream(ConverterConstants.PROPFILENAME);
		if (inputStream != null) {
			properties = new Properties();
			try {
				properties.load(inputStream);
			} catch (IOException ioEx) {
				System.out.println(ConverterConstants.ERROR + ConverterConstants.PROPFILEERROR);
				System.out.println(ConverterConstants.ERROR + ioEx.getMessage());
			} finally {
				try {
					inputStream.close();
				} catch (IOException ioEx) {
					System.out.println(ConverterConstants.ERROR + ConverterConstants.PROPFILEERROR);
					System.out.println(ConverterConstants.ERROR + ioEx.getMessage());
				}
			}
		}

	}

}
