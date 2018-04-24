package com.gomedii.swagger.model;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeDto {
	 

 
    private String name;
 
    private String emailid;
 
    private BigDecimal salary;
    
 
	private List<DepartmentDto> departmentDto;

	public List<DepartmentDto> getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(List<DepartmentDto> departmentDto) {
		this.departmentDto = departmentDto;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
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
