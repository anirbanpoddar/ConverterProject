package com.practice.converter;

/**
 * This interface defines the functionalities of the converter.
 * 
 * @author anirbanpoddar
 *
 */
public interface Converter {

	/**
	 * Returns the name of the converter. Name should be set when the converter
	 * is initialized.
	 * 
	 * @return String
	 */
	public String getName();

	/**
	 * Returns the creation time stamp of the converter. Creation time stamp
	 * should be set when the converter is initialized.
	 * 
	 * @return
	 */
	public String getCreationTimeStamp();

	/**
	 * Reads the file from the file path passed as parameter and converts the
	 * file to domain model.
	 * 
	 * @param String
	 *            inputFilePath: The file path to read.
	 */
	public void readAndConvert(String inputFilePath);

	/**
	 * Writes the domain model at the file path passed as a parameter.
	 * 
	 * @param String
	 *            outputFilePath: The file path to write.
	 */
	public void write(String outputFilePath);

	/**
	 * Prints the domain model on the console. [This is a method
	 * mainly used for testing purpose.]
	 */
	public void print();

}
