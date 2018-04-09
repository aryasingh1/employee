package com.gomedii.swagger.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gomedii.swagger.model.Department;
import com.gomedii.swagger.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/department")
@Api(value="office")
public class DepartmentController {

	@Autowired
    private DepartmentService departmentService;
	
    @ApiOperation(value = "View a list of present Department",response = Department.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/api/Department", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Department> list(){
        Iterable<Department> departmentList = departmentService.listAllDepartment();
        return departmentList;
    }
    
    @ApiOperation(value = "Search a Department with an ID",response = Department.class)
    @RequestMapping(value = "/api/Department/{id}", method= RequestMethod.GET, produces = "application/json")
    public Department showDepartment(@PathVariable Integer id){
    	Department department = departmentService.getDepartmentById(id);
        return department;
    }

    @ApiOperation(value = "Add a Department")
    @RequestMapping(value = "/api/Departments", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> saveDepartment(@RequestBody Department department)
    {
    	departmentService.saveDepartment(department); 
    	return new ResponseEntity<String>("Department saved successfully", HttpStatus.OK); 
    	
    }

    @ApiOperation(value = "Update a Department")
    @RequestMapping(value = "/api/Departments/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<String> updateDepartment(@PathVariable Integer id, @RequestBody Department department){
    	Department storedDepartment = departmentService.getDepartmentById(id);
        //storedDepartment.setDid(department.getDid());
        storedDepartment.setDname(department.getDname());
        storedDepartment.setDmob(department.getDmob());
        storedDepartment.setCreatedOn(department.getCreatedOn());
        storedDepartment.setUpdatedOn(department.getUpdatedOn());

        storedDepartment.setUpdatedBy(department.getId());

        storedDepartment.setUpdatedOn(new Date());

        departmentService.saveDepartment(storedDepartment);
        return new ResponseEntity<String>("Department updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a department")
    @RequestMapping(value="/api/departments/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable Integer id){
    	departmentService.deleteDepartment(id);
        return new ResponseEntity<String>("department deleted successfully", HttpStatus.OK);

    }
}
