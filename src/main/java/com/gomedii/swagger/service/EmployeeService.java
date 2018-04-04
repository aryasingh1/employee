
package com.gomedii.swagger.service;

import com.gomedii.swagger.model.Employee;
import com.gomedii.swagger.model.em;

public interface EmployeeService {
	public abstract Iterable<Employee> listAllEmployee();
	public abstract Employee getEmployeeById(Integer id);
	public abstract Employee saveEmployee(Employee employee);
	public abstract void deleteEmployee(Integer id);
	public abstract void saveem(Employee employee);
	

}