
package com.gomedii.swagger.service;

import com.gomedii.swagger.model.Employee;


public interface EmployeeService {
	public abstract Iterable<Employee> listAllEmployee();
	public abstract Employee getEmployeeById(Integer id);
	public abstract Employee saveEmployee(Employee employee);
	public abstract void deleteEmployee(Integer id);
	
	

}