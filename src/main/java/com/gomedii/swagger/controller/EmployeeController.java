
package com.gomedii.swagger.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.gomedii.swagger.model.Employee;
import com.gomedii.swagger.model.View;
import com.gomedii.swagger.repositries.EmployeeRepository;
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
	private EmployeeRepository repo;

	@ApiOperation(value = "View a list of present employee",response = Employee.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrievedd list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = String.class)
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
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = String.class)
			})    
	}
			)
	@RequestMapping(value = "/api/employees/{id}", method= RequestMethod.GET, produces = "application/json")
	public Employee showEmployee(@PathVariable Integer id)
	{
		Employee employee = employeeService.getEmployeeById(id);
		return employee;
	}

	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrievedd list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = String.class)
			})  
	}
			)
	@ApiOperation(value = "Add a employee")
	@RequestMapping(value = "/api/employees", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		//List<Employee> empList = new ArrayList<Employee>();

		employeeService.saveEmployee(employee);
		return new ResponseEntity<String>("employee saved successfully", HttpStatus.OK); 
	}

	@ApiOperation(value = "Update a employee")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrievedd list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = String.class)
			})  
	}
			)
	@RequestMapping(value = "/api/employees/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee)
	{
		Employee storedEmployee = employeeService.getEmployeeById(id);
		storedEmployee.setEname(employee.getEname());
		storedEmployee.setDescription(employee.getDescription());
		storedEmployee.setEmailid(employee.getEmailid());
		storedEmployee.setSalary(employee.getSalary());

		storedEmployee.setUpdatedOn(new Date());
		storedEmployee.setUpdatedBy(employee.getId());		//Updating in Employee by employee id = 1

		employeeService.saveEmployee(storedEmployee);
		return new ResponseEntity<String>("emplyee updated successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a employee")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrievedd list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = String.class)
			})  
	}
			)
	@RequestMapping(value="/api/empoyees/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> delete(@PathVariable Integer id)
	{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("employee deleted successfully", HttpStatus.OK);
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
}
