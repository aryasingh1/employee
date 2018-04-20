package com.gomedii.swagger.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditJoinTable;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Audited
@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer id;
	
	@Column(name= "name")
	@NotEmpty(message = "*Please provide department name")
	private String name;
	
	@Column(name= "contact_no")
	@NotEmpty(message = "*Please provide department mobile number ")
	private String contact_no;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "created_on")
	private Date createdOn;
	
	@Column(name = "updated_on")
	private Date updatedOn;
	
	@Column(name= "createdBy")
	private int createdBy;
	
	@Column(name = "updatedBy")
	private int updatedBy;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL , fetch=FetchType.LAZY)
	@AuditJoinTable
	@JoinTable(name="employee_department" ,  joinColumns= {
													@JoinColumn(name="did")},inverseJoinColumns= {
												@JoinColumn(name="id")})
	
	private List<Employee> employee;
	
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
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
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
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
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
}