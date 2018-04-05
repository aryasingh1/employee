package com.gomedii.swagger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.gomedii.swagger.model.Employee;
import com.gomedii.swagger.repositries.EmployeeRepository;

@SpringBootApplication
public class Employee1Application implements ApplicationListener<ContextRefreshedEvent>{
	private Logger log = Logger.getLogger(Employee1Application.class);
	@Autowired
	private EmployeeRepository employee1Repository;

	public static void main(String[] args) {
		SpringApplication.run(Employee1Application.class, args);
	}
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadEmployee1();
	}

	private void loadEmployee1() {
		Employee employee = new Employee();

		employee.setEname("shyam");
		employee.setDescription("employee address");
		employee.setSalary(13299.00);
		employee.setImageUrl("www.gomedii.com");
		employee.setEmployeeId("123456");
		employee1Repository.save(employee);

		log.info("Employee - id: " + employee.getId());

		Employee director = new Employee();
		director.setEname("ram");
		director.setDescription("director address");
		director.setImageUrl("www.binaryinformatics.com");
		director.setEmployeeId("45678");
		director.setSalary(47499.00);
		employee1Repository.save(director);

		log.info("Saved Phone - id:" + director.getId());
	}
}
