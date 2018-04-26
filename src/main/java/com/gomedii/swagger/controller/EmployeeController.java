  
package com.gomedii.swagger.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.gomedii.swagger.model.Employee;

import com.gomedii.swagger.model.EmployeeDtoPost;
import com.gomedii.swagger.model.EmployeeDtoUpdate;

import com.gomedii.swagger.model.View;
import com.gomedii.swagger.repositries.DepartmentRepository;
import com.gomedii.swagger.repositries.EmployeeRepository;
import com.gomedii.swagger.service.DepartmentService;
import com.gomedii.swagger.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;


@RestController
@RequestMapping("/employee")
@Api(value="office")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	 private org.modelmapper.ModelMapper modelMapper;

	
	@ApiOperation(value = "View a list of present employee",response = Employee.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrievedd list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = Employee.class)
			}),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
			)
	@RequestMapping(value = "/api/employees", method= RequestMethod.GET, produces = "application/json")
	public Iterable<Employee> list()
	{
		Iterable<Employee> employeeList = employeeService.listAllEmployee();
		return employeeList;
	}

	@ApiOperation(value = "Search a employee with an ID",response = Employee.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrievedd list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = Employee.class)
			})    
	}
			)
	@RequestMapping(value = "/api/employees/{id}", method= RequestMethod.GET, produces = "application/json")
	public Employee showEmployee(@PathVariable Integer id,@RequestHeader(value="auth") String auth)
	{
		Employee employee = employeeService.getEmployeeById(id);
		return employee;
	}

	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrievedd list",responseHeaders = {

					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = String.class)
			})
	}	)
	@ApiOperation(value = "Add a employee")
	@RequestMapping(value = "/api/employees", method = RequestMethod.POST, produces = "application/json")

	public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDtoPost employeeDto,@RequestHeader(value="auth") String auth) throws ParseException
	{
		Employee employee = convertToEntity(employeeDto);
		employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}

	@ApiOperation(value = "Update a employee")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrievedd list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = Employee.class)
			})  
	})
	

	@RequestMapping(value = "/api/employees/{id}", method = RequestMethod.PUT, produces = "application/json")


	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Integer id, @RequestBody EmployeeDtoUpdate employeeDtoUpdate,@RequestHeader(value="auth") String auth) throws ParseException


	{
		//Employee employee = convertToEntity(employeeupdate);
		
		List<Employee> employeeList =  (List<Employee>) employeeRepository.findAll();
		Employee emp1 =  employeeList.get(0);
		int emp_updatedBy = emp1.getId();
		//Employee emp=employeeRepository.findOne(id);
		//Employee storedEmployee = employeeService.getEmployeeById(id);
		
		Employee employee = employeeService.getEmployeeById(id);
		//employee.setId(id);
		employee.setName(employeeDtoUpdate.getName());
		employee.setEmailid(employeeDtoUpdate.getEmailid());
		employee.setDescription(employeeDtoUpdate.getDescription());
		employee.setSalary(employeeDtoUpdate.getSalary());
		employee.setUpdatedOn(new Date());
		employee.setUpdatedBy(emp_updatedBy);		//Updated by employee id = 1
		//employeeService.saveEmployee(employee);		
		
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Delete a employee")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrievedd list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = Employee.class)
			})  
	}
			)
	@RequestMapping(value="/api/empoyees/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Employee> delete(@PathVariable Integer id,@RequestHeader(value="auth") String auth)
	{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}



	@GetMapping("/api/employees/{id}/summarry")
	
	@JsonView(View.Summary.class)
	public Employee getSpecificEmployee(@PathVariable(value="id") Integer id)
	{
		return employeeService.getEmployeeById(id);


	}
	
	@GetMapping("/getAll/{id}")
	public Employee getAllEmployee(@PathVariable(value="id") Integer id)
	{
		return employeeService.getEmployeeById(id);
	}
	
	private Employee convertToEntity(EmployeeDtoPost emDto) throws ParseException 
	{
		Employee employee = modelMapper.map(emDto, Employee.class);
	    return employee;
	}
	
	private EmployeeDtoPost convertToDto(Employee employee) {
		EmployeeDtoPost emDto = modelMapper.map(employee, EmployeeDtoPost.class);
	   
	    return emDto;
	}	
	
	private Employee convertToEntity(EmployeeDtoUpdate emDtoupdate) throws ParseException 
	{
		Employee employee = modelMapper.map(emDtoupdate, Employee.class);
	    return employee;
	}
	
	private EmployeeDtoUpdate convertToDtoUpdate(Employee employee) 
	{
		EmployeeDtoUpdate emDtoupdate = modelMapper.map(employee, EmployeeDtoUpdate.class);
	    return emDtoupdate;
	}
	

	
}
