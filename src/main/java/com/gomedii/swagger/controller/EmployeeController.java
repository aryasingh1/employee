package com.gomedii.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gomedii.swagger.model.Employee;
import com.gomedii.swagger.model.em;
import com.gomedii.swagger.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employee")
@Api(value="office")
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "View a list of present employee",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Employee> list(Model model){
        Iterable<Employee> employeeList = employeeService.listAllEmployee();
        return employeeList;
    }
    @ApiOperation(value = "Search a employee with an ID",response = Employee.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public Employee showEmployee(@PathVariable Integer id, Model model){
       Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @ApiOperation(value = "Add a employee")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> saveEmployee(@RequestBody em employee)
    {
    	Employee employeea = new Employee();
    	employeea.setId(employee.getId());
    	employeea.setEmployeeId(employee.getEmployeeId());
        employeeService.saveem(employeea);
        return new ResponseEntity<String>("employee saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a employee")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        Employee storedEmployee = employeeService.getEmployeeById(id);
        storedEmployee.setEmployeeId(employee.getEmployeeId());
        storedEmployee.setDescription(employee.getDescription());
        storedEmployee.setImageUrl(employee.getImageUrl());
        storedEmployee.setSalary(employee.getSalary());
        employeeService.saveem(storedEmployee);
        return new ResponseEntity<String>("emplyee updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a employee")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("employee deleted successfully", HttpStatus.OK);

    }

}