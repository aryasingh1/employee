package com.gomedii.swagger.model;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeDtoPost {
	
    private String name;
    private String emailid;
    private BigDecimal salary;
	
    public List<DepartmentDtoPost> departmentDtos;
    
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
	public List<DepartmentDtoPost> getDepartmentDtos() {
		return departmentDtos;
	}
	public void setDepartmentDtos(List<DepartmentDtoPost> departmentDtos) {
		this.departmentDtos = departmentDtos;
	}
}