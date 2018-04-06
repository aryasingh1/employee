
package com.gomedii.swagger.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Employee {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated employee ID")
    @Column(name="id")
    private Integer id;
   
    @ApiModelProperty(notes = "The application-specific employee ID")
    @Column(name="ename")
    private String Ename;
    
    @JsonView(View.Summary.class)
    @ApiModelProperty(notes = "The employee description")
    @Column(name="description")
    private String description;
    
    @ApiModelProperty(notes = "The image URL of the employee")
    @Column(name="emailid",length=4000)
    private String Emailid;
    
    @JsonView(View.Summary.class)
    @ApiModelProperty(notes = "The salary of the employee")
    @Column(name="salary")
    private BigDecimal salary;
    
    
    public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "created_on")
	private Date createdOn;
	
	@Column(name = "updated_on")
	private Date updatedOn;
	

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

   

    public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public String getEmailid() {
		return Emailid;
	}

	public void setEmailid(String emailid) {
		Emailid = emailid;
	}

	public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

	

}