package com.practice.domain;

/**
 * This interface defines the functionalities of the employee. Email id should
 * act as the primary key. So, email id should not be changed once set.
 * 
 * @author anirbanpoddar
 *
 */
public interface Employee {

	/**
	 * Returns the name of the employee.
	 * 
	 * @return String
	 */
	public String getName();

	/**
	 * Sets the name of the employee.
	 * 
	 * @param String
	 *            name: The name.
	 */
	public void setName(String name);

	/**
	 * Returns the telephone number of the employee.
	 * 
	 * @return String
	 */
	public String getTelephone();

	/**
	 * Sets the telephone number of the employee.
	 * 
	 * @param String
	 *            telephone: The telephone number.
	 */
	public void setTelephone(String telephone);

	/**
	 * Returns the email id of the employee.
	 * 
	 * @return String
	 */
	public String getEmail();

	/**
	 * Returns the address of the employee.
	 * 
	 * @return String
	 */
	public String getAddress();

	/**
	 * Sets the address of the employee.
	 * 
	 * @param String
	 *            address: The address.
	 */
	public void setAddress(String address);

	/**
	 * Returns the type of the employee.
	 * 
	 * @return String
	 */
	public String getType();

	/**
	 * Sets the type of the employee.
	 * 
	 * @param String
	 *            type: The type.
	 */
	public void setType(String type);

	/**
	 * Returns the short information about the employee.
	 * 
	 * @return String
	 */
	public String getInformation();

}
