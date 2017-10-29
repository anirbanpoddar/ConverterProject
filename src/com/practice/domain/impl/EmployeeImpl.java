package com.practice.domain.impl;

import com.practice.domain.Employee;

/**
 * This class contains employee information. This class should only be
 * initialized and changed by the input data and through different employee
 * classes extending from this.
 * 
 * @author anirbanpoddar
 * 
 */
public abstract class EmployeeImpl implements Employee {

	// Name of the employee.
	private String name;

	// Telephone number of the employee.
	private String telephone;

	// Email id of the employee.
	private String email;

	// Address of the employee.
	private String address;

	// Type of the employee.
	private String type;

	/**
	 * Constructor to set employee data.
	 * 
	 * @param String
	 *            name: Name of the employee.
	 * @param String
	 *            telephone: Telephone number of the employee.
	 * @param String
	 *            email: Email id of the employee.
	 * @param String
	 *            address: Address of the employee.
	 * @param String
	 *            type: Type of the employee.
	 */
	protected EmployeeImpl(String name, String telephone, String email, String address, String type) {

		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.type = type;

	}

	@Override
	public String getName() {

		return name;

	}

	@Override
	public void setName(String name) {

		this.name = name;

	}

	@Override
	public String getTelephone() {

		return telephone;

	}

	@Override
	public void setTelephone(String telephone) {

		this.telephone = telephone;

	}

	@Override
	public String getEmail() {

		return email;

	}

	@Override
	public String getAddress() {

		return address;

	}

	@Override
	public void setAddress(String address) {

		this.address = address;

	}

	@Override
	public String getType() {

		return type;

	}

	@Override
	public void setType(String type) {

		this.type = type;

	}

	@Override
	public String getInformation() {

		// The information is different for different subclasses.
		return name;

	}

}
