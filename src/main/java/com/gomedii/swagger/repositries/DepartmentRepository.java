package com.gomedii.swagger.repositries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gomedii.swagger.model.Department;
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
}

