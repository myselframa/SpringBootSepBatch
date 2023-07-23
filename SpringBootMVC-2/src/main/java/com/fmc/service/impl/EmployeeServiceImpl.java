package com.fmc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmc.model.Employee;
import com.fmc.repo.EmployeeRepo;
import com.fmc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo repo;
	@Override
	public Integer saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repo.save(employee).getEmpId();
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public Employee findById(int id) {
		return repo.findById(id).get();
	}
	@Override
	public void deleteById(Integer id) {
		repo.delete(repo.findById(id).get());
		
	}

}
