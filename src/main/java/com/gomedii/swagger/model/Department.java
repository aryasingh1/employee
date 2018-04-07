package com.gomedii.swagger.model;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "did")
	private Integer id;
	
	@Column(name= "dname")
	private String Dname;
	
	@Column(name= "dmob")
	private String Dmob;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "created_on")
	private Date createdOn;
	
	@Column(name = "updated_on")
	private Date updatedOn;
	
	//@ManyToMany(/*cascade = CascadeType.REFRESH,*/mappedBy="department")
	@ManyToMany(cascade = CascadeType.ALL,/*fetch=FetchType.LAZY,*/mappedBy="department")
	private List<Employee> employee;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		this.Dname = dname;
	}
	public String getDmob() {
		return Dmob;
	}
	public void setDmob(String dmob) {
		this.Dmob = dmob;
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
}	