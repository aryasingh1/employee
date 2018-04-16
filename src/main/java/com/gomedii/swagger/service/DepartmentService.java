	package com.gomedii.swagger.service;
	
	import com.gomedii.swagger.model.Department;
	
	public interface DepartmentService {
		
		public abstract Iterable<Department> listAllDepartment();
		public abstract Department saveDepartment(Department department);
		public abstract void deleteDepartment(Integer id);
		public abstract Department getDepartmentById(Integer id);
	}