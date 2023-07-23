package com.fmc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fmc.model.Employee;
import com.fmc.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService empservice;

	public EmployeeController(EmployeeService empservice) {
		this.empservice = empservice;
	}
	
	@GetMapping("/showForm")
	public String showFormToAdd(Model model) {
		Employee emp=new Employee();
		model.addAttribute("employee", emp);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmpolyee(@ModelAttribute("employee") Employee emp,Model model) {
		
		empservice.saveEmployee(emp);
		return "redirect:/employee/getall";
		
	}
	
	@GetMapping("/getall")
	public String getAllEmployees(Model model) {
		List<Employee> employees=empservice.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employees/list-employess";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int empId, Model model) {
		
		Employee emp=empservice.findById(empId);
		model.addAttribute("employee",emp);
		return "employees/employee-form";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int empId) {
		empservice.deleteById(empId);
		return "redirect:/employee/getall";
	}

}
