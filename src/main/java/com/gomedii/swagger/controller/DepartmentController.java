package com.gomedii.swagger.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gomedii.swagger.model.Department;
import com.gomedii.swagger.model.DepartmentDtoPost;
import com.gomedii.swagger.model.DepartmentDtoUpdate;
import com.gomedii.swagger.model.Employee;
import com.gomedii.swagger.repositries.EmployeeRepository;
import com.gomedii.swagger.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;



@RestController
@RequestMapping("/department")
@Api(value="office")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private org.modelmapper.ModelMapper modelMapper;

	@ApiOperation(value = "View a list of present Department",response = Department.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrieved list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = Department.class)
			}),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
			)
	@RequestMapping(value = "/api/Department", method= RequestMethod.GET, produces = "application/json")
	public Iterable<Department> list()
	{
		Iterable<Department> departmentList = departmentService.listAllDepartment();
		return departmentList;
	}

	@ApiOperation(value = "Search a Department with an ID",response = Department.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrieved list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = Department.class)
			})
	})
	@RequestMapping(value = "/api/Department/{id}", method= RequestMethod.GET, produces = "application/json")
	public Department showDepartment(@PathVariable Integer id,@RequestHeader(value="auth") String auth)
	{
		Department department = departmentService.getDepartmentById(id);
		return department;
	}

	//public ResponseEntity<String> updateDepartment(@PathVariable Integer id, @RequestBody Department department)
	@ApiOperation(value = "Add a Department")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrieved list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = Department.class)
			})
	})
	@RequestMapping(value = "/api/Departments", method = RequestMethod.POST, produces = "application/json")

	public ResponseEntity<Department> saveDepartment(@RequestBody DepartmentDtoPost departmentDto,@RequestHeader(value="auth") String auth) throws ParseException
	

	{
		Department department= convertToEntity(departmentDto);
		departmentService.saveDepartment(department); 
		return new ResponseEntity<Department>(HttpStatus.OK);
	}

	@ApiOperation(value = "Update a Department")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrieved list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = Department.class)
			})
	})
	@RequestMapping(value = "/api/Departments/{id}", method = RequestMethod.PUT, produces = "application/json")

	public ResponseEntity<Department> updateDepartmentDto(@PathVariable Integer id, @RequestBody DepartmentDtoUpdate departmentDtoUpdate,@RequestHeader(value="auth") String auth) throws ParseException
	{	
		List<Employee> employeeList =  (List<Employee>) employeeRepository.findAll();
		Employee emp1 =  employeeList.get(0);
		int updatedBy = emp1.getId();
		
		Department storedDepartment = departmentService.getDepartmentById(id);
		storedDepartment.setName(departmentDtoUpdate.getName());
		storedDepartment.setContact_no(departmentDtoUpdate.getContact_no());
		//storedDepartment.setUpdatedOn(departmentDtoUpdate.getUpdatedOn());

		storedDepartment.setUpdatedOn(new Date());
		storedDepartment.setUpdatedBy(updatedBy);
		
		departmentService.updateDepartment(storedDepartment);
		//departmentService.saveDepartment(storedDepartment);
		return new ResponseEntity<Department>(HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a department")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully retrieved list",responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = Department.class)
			})
	})
	@RequestMapping(value="/api/departments/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Department> delete(@PathVariable Integer id,@RequestHeader(value="auth") String auth)
	{
		departmentService.deleteDepartment(id);
		return new ResponseEntity<Department>(HttpStatus.OK);
	}
	
	private Department convertToEntity(DepartmentDtoPost dmDto) throws ParseException 
	{
		Department department = modelMapper.map(dmDto, Department.class);
	    return department;
	}
	
	private DepartmentDtoPost convertToDto(Department department) 
	{
		DepartmentDtoPost dmDto = modelMapper.map(department, DepartmentDtoPost.class);   
	    return dmDto;
	}
}