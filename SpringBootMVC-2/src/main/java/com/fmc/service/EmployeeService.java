package com.fmc.service;

import java.util.List;

import com.fmc.model.Employee;

public interface EmployeeService {
	
	Integer saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee findById(int id);
	void deleteById(Integer id);

}
