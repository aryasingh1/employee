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
	@Column(name="ename")
	private String Ename;

	@JsonView(View.Summary.class)
	@ApiModelProperty(notes = "The employee description")
	@Column(name="description")
	private String description;

	@ApiModelProperty(notes = "The Emailid of the employee")
	@Column(name="emailid",length=5000)
	private String Emailid;


	@Column(name="salary")
	private BigDecimal salary;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "created_on")
	private Date createdOn;

	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="employee")

	private List<Department> department;

	@Column(name = "updated_on")
	private Date updatedOn;

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