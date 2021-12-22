package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.EmployeeDto;
import com.spring.service.EmployeeIMPL;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping("/h2database")
public class H2DatabaseController {

	@Autowired
	EmployeeIMPL employeeIMPL;
	
	@GetMapping
	public String welcome() {
		return "hello h2database example";
	}
	
	@PostMapping("/addemployeedetails")
	public String addEmployDetails(@RequestBody EmployeeDto empDetails) {
		employeeIMPL.saveDataOnDB(empDetails);
		return "successfuly added";
	}
	
	@GetMapping("/getEmployeeDetailsById/{id}")
	public Optional<EmployeeDto> getEmployeeDetailsById(@PathVariable(value = "id") String reqId) {
		int id = Integer.parseInt(reqId);
		return employeeIMPL.getEmployeeDetailsById(id);
	}
	
	@GetMapping("/getEmployeeDetailsByIdRequest")
	public String getEmployeeDetailsByIdRequest(String reqId) {
		
		return "test "+reqId;
		
//		int id = Integer.parseInt(reqId);
//		return employeeIMPL.getEmployeeDetailsById(id);
	}
	
	
	@GetMapping("/getEmployeeDetailsByName/{name}")
	public List<EmployeeDto> getEmployeeDetailsByName(@PathVariable(value = "name") String reqName){
		return employeeIMPL.getEmployeeDetailsByName(reqName);
	}
	
}
