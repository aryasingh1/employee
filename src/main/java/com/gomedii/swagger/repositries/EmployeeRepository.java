package com.gomedii.swagger.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gomedii.swagger.model.Employee;

//public interface EmployeeRepository extends CrudRepository<Employee, Integer>
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{


}