package com.gomedii.swagger.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Employee {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated employee ID")
    @Column(name="id")
    private Integer id;
    
    @Version
    @ApiModelProperty(notes = "The auto-generated version of the employee")
    @Column(name="version")
    private Integer version;
    
  
    
    @ApiModelProperty(notes = "The application-specific employee ID")
    @Column(name="employee_id")
    private String employeeId;
    
    @JsonView(View.Summery.class)
    @ApiModelProperty(notes = "The employee description")
    @Column(name="description")
    private String description;
    
    @ApiModelProperty(notes = "The image URL of the employee")
    @Column(name="image_url",length=4000)
    private String imageUrl;
    
    @JsonView(View.Summery.class)
    @ApiModelProperty(notes = "The salary of the employee")
    @Column(name="salary")
    private BigDecimal salary;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

	
}