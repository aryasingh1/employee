package com.gomedii.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import io.swagger.annotations.ApiModelProperty;
@Entity
public class em {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	 
    @ApiModelProperty(notes = "The employee description")
    @Column(name="description")
    private String description;
	
	@ApiModelProperty(notes = "The application-specific employee ID")
    @Column(name="employee_id")
    private String employeeId;
    
    
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
    
	/*public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}*/

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	

	
}
