package com.practice.domain.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.practice.domain.Company;
import com.practice.domain.Employee;
import com.practice.domain.constant.DomainConstants;

/**
 * This class contains company information. This class should only be
 * initialized and changed by the input data.
 * 
 * @author anirbanpoddar
 *
 */
public class CompanyImpl implements Company {

	// Name of the company.
	private String name;

	// Telephone number of the company.
	private String telephone;

	// Email id of the company.
	private String email;

	// Address of the company.
	private String address;

	// List of employees in the company.
	private Map<String, Employee> employees = new ConcurrentHashMap<String, Employee>();

	/**
	 * Constructor to set company data.
	 * 
	 * @param String
	 *            name: Name of the company.
	 * @param String
	 *            telephone: Telephone number of the company.
	 * @param String
	 *            email: Email id of the company.
	 * @param String
	 *            address: Address of the company.
	 * @param Map<String,
	 *            Employee> employees: List of employees in the company.
	 */
	public CompanyImpl(String name, String telephone, String email, String address, Map<String, Employee> employees) {

		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.employees.putAll(employees);

	}

	@Override
	public String getName() {

		return name;

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
	public void setEmail(String email) {

		this.email = email;

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
	public List<Employee> getEmployees() {

		List<Employee> list = new ArrayList<Employee>();
		if (employees != null && !employees.isEmpty()) {
			employees.entrySet().stream().forEach(item -> list.add(item.getValue()));
		}
		return list;

	}

	@Override
	public String getInformation() {

		return name + DomainConstants.DOMFILESEP + telephone + DomainConstants.DOMFILESEP + email;

	}

	@Override
	public void addUpdateEmployee(String email, Employee employee) {

		employees.put(email, employee);

	}

}
