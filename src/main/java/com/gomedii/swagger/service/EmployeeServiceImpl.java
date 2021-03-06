package com.gomedii.swagger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomedii.swagger.model.Department;
import com.gomedii.swagger.model.Employee;
import com.gomedii.swagger.repositries.DepartmentRepository;
import com.gomedii.swagger.repositries.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	private EmployeeRepository employeeRepository;
	private DepartmentRepository departmentRepository;

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Iterable<Employee> listAllEmployee() {
		logger.debug("listAllEmployee called");
		Iterable<Employee>  iterable = employeeRepository.findAll();
		return iterable;
	}
	
	@Override
	public Employee getEmployeeById(Integer id) {
		logger.debug("getEmployeeById called");
		return employeeRepository.findOne(id);
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		logger.debug("saveEmployee called"); 
	
		List<Employee> employeeList =  (List<Employee>) employeeRepository.findAll();
		Employee emp1 =  employeeList.get(0);
		int createdBy = emp1.getId();
		
		employee.setCreatedOn(new Date());
		employee.setDescription("IT");
		employee.setCreatedBy(createdBy);
		//employee.setUpdatedOn(new Date());

		employee.setCreatedOn(new Date());
		//employee.setUpdatedOn(new Date());
		employee.setDescription("IT");


		List<Department> deptlist = employee.getDepartment();

		for(Department deptloop : deptlist)
		{
			deptloop.setEmployee(Arrays.asList(employee));
		}
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee updateEmployee(Employee employee)
	{
		employee.setUpdatedOn(new Date());
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		logger.debug("deleteEmployee called");
		employeeRepository.delete(id);
	}
	
}