package com.practice.domain.impl;

import com.practice.domain.constant.DomainConstants;

/**
 * This class contains global employee information. This class should only be
 * initialized and changed by the input data.
 * 
 * @author anirbanpoddar
 * 
 */
public class GlobalEmployeeImpl extends EmployeeImpl {

	/**
	 * Constructor to set global employee data.
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
	public GlobalEmployeeImpl(String name, String telephone, String email, String address, String type) {

		super(name, telephone, email, address, type);

	}

	@Override
	public String getInformation() {

		// New information over the parent class.
		return getName() + DomainConstants.DOMFILESEP + getEmail();

	}

}
