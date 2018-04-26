package com.gomedii.swagger.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.envers.AuditJoinTable;

public class DepartmentDtoPost {

	private String name;
	private String Contact_no;
	
	/*private List<EmployeeDtoPost> employeeDtos;*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_no() {
		return Contact_no;
	}
	public void setContact_no(String contact_no) {
		Contact_no = contact_no;
	}
	/*public List<EmployeeDtoPost> getEmployeeDtos() {
		return employeeDtos;
	}
	public void setEmployeeDtos(List<EmployeeDtoPost> employeeDtos) {
		this.employeeDtos = employeeDtos;
	}*/
}