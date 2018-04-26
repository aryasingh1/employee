package com.gomedii.swagger.service;

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
public class DepartmentServiceImpl implements DepartmentService {
	private final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public void setDepartmentRepository(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Iterable<Department> listAllDepartment() {
		logger.debug("listAllDepartment called");
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(Integer id) {
		logger.debug("getDepartmentById called");
		return departmentRepository.findOne(id);
	}
	
	@Override
	public Department saveDepartment(Department department) {
		logger.debug("saveDepartment called"); 
		department.setCreatedOn(new Date());
		List<Employee> emplist = (List<Employee>) employeeRepository.findAll();
		Employee emp1 = emplist.get(0);
		int createdBy = emp1.getId();
		//department.setUpdatedOn(new Date());
		department.setCreatedBy(createdBy);
		department.setEmployee(emplist);
		return departmentRepository.save(department);
	}
	
	@Override
	public Department updateDepartment(Department department)
	{
		department.setUpdatedOn(new Date());
		return departmentRepository.save(department);
	}
	
	@Override
	public void deleteDepartment(Integer id) {
		logger.debug("deleteDepartment called");
		departmentRepository.delete(id);
	}
}	