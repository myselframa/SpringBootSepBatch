package com.fmc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmc.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	Employee findByEmpId(Integer id);

}
