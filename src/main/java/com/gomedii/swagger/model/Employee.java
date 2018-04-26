package com.gomedii.swagger.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

@Audited
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated employee ID")
	@Column(name="id")
	private Integer id;

	@ApiModelProperty(notes = "The application-specific employee ID")
	@JsonView(View.Summary.class)
	@NotEmpty(message = "*Please provide employee name")
	@Column(name="name")
	private String name;

	@JsonView(View.Summary.class)
	@ApiModelProperty(notes = "The employee description")
	@Column(name="description")
	private String description;

	@ApiModelProperty(notes = "The Emailid of the employee")
	@Column(name="emailid",length=5000)
	@NotEmpty(message = "*Please provide employee email id")
	private String emailid;


	@Column(name="salary")
	private BigDecimal salary;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "created_on")
	private Date createdOn;

	//@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="employee")

	private List<Department> department;

	@Column(name = "updated_on")
	private Date updatedOn;

	//@DateTimeFormat(pattern= "DD/MM/YYYY")
	@Column(name= "createdBy")
	private int createdBy;

	@Column(name = "updatedBy")
	private int updatedBy;

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	public int getCreatedBy()
	{
		return createdBy;
	}
	public void setCreatedBy(int createdBy)
	{
		this.createdBy= createdBy;
	}

	public int getUpdatedBy()
	{
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy)
	{
		this.updatedBy= updatedBy;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}