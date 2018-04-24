package com.gomedii.swagger.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.gomedii.swagger.model.Employee;

//public interface EmployeeRepository extends CrudRepository<Employee, Integer>
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{


}