
 package com.gomedii.swagger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomedii.swagger.model.Department;
import com.gomedii.swagger.model.Employee;
import com.gomedii.swagger.repositries.DepartmentRepository;
import com.gomedii.swagger.repositries.EmployeeRepository;
import com.gomedii.swagger.service.EmployeeService;
import com.gomedii.swagger.service.EmployeeServiceImpl;

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
        
/*    	List<Employee> employeeList =  (List<Employee>) employeeRepository.findAll();
    	Employee employee2 =  employeeList.get(0);
    	List<Department> departments =employee2.getDepartment();   
    	employee.setDepartment(departments);*/
        
        List<Employee> employeeList =  (List<Employee>) employeeRepository.findAll();
    	Employee employee2 =  employeeList.get(0);
    	
    	List<Department> departments =employee2.getDepartment();
    	List<Department> deparmentNew = new ArrayList<>();
    	for(Department department :  departments)
    	{
    		//Department department1 = new Department();
    		//department1.setId(department.getId());
    		deparmentNew.add(department);
    	}
    	employee.setDepartment(deparmentNew);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        logger.debug("deleteEmployee called");
        employeeRepository.delete(id);
    }
}