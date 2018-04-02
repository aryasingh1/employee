package com.gomedii.swagger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomedii.swagger.model.Employee;
import com.gomedii.swagger.repositries.EmployeeRepository;
import com.gomedii.swagger.service.EmployeeService;
import com.gomedii.swagger.service.EmployeeServiceImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> listAllEmployee() {
        logger.debug("listAllEmployee called");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        logger.debug("getEmployeeById called");
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        logger.debug("saveEmployee called");
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        logger.debug("deleteEmployee called");
        employeeRepository.delete(id);
    }

	/*@Override
	public Employee getEmployeeByName(String name) {
		logger.debug("getEmployeeByName called");
		return employeeRepository.findByName();*/
		
	}

