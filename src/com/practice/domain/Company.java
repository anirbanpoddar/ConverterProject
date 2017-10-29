package com.practice.domain;

import java.util.List;

/**
 * This interface defines the functionalities of the company. Name should act as
 * the primary key. So, name should not be changed once set.
 * 
 * @author anirbanpoddar
 *
 */
public interface Company {

	/**
	 * Returns the name of the company.
	 * 
	 * @return String
	 */
	public String getName();

	/**
	 * Returns the telephone number of the company.
	 * 
	 * @return String
	 */
	public String getTelephone();

	/**
	 * Sets the telephone number of the company.
	 * 
	 * @param String
	 *            telephone: The telephone number.
	 */
	public void setTelephone(String telephone);

	/**
	 * Returns the email id of the company.
	 * 
	 * @return String
	 */
	public String getEmail();

	/**
	 * Sets the email id of the company.
	 * 
	 * @param String
	 *            email: The email id.
	 */
	public void setEmail(String email);

	/**
	 * Returns the address of the company.
	 * 
	 * @return String
	 */
	public String getAddress();

	/**
	 * Sets the address of the company.
	 * 
	 * @param String
	 *            address: The address.
	 */
	public void setAddress(String address);

	/**
	 * Returns the list of employees in the company.
	 * 
	 * @return List<Employee>
	 */
	public List<Employee> getEmployees();

	/**
	 * Add or update an employee to the company.
	 * 
	 * @param String
	 *            email: Email id of the employee.
	 * @param Employee
	 *            employee: Employee data.
	 */
	public void addUpdateEmployee(String email, Employee employee);

	/**
	 * Returns the short information about the company.
	 * 
	 * @return String
	 */
	public String getInformation();

}
