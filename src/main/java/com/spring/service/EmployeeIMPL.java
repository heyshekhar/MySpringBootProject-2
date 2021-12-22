package com.spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.dto.EmployeeDto;


@Service
@Repository
@Transactional
public class EmployeeIMPL {

	Logger log = LogManager.getLogger(EmployeeIMPL.class);
	
	@Autowired
	EntityManager entityManger;
	
	@Autowired
	EmployeeService employeeService;
	
	public String saveDataOnDB(EmployeeDto empDto) {

		log.info("going to add data for employee : {}", empDto.getName());
		employeeService.save(empDto);
		return "success";
	}

	public Optional<EmployeeDto> getEmployeeDetailsById(int id) {
		
		return employeeService.findById(id);
		
	}
	
	
	public List<EmployeeDto> getEmployeeDetailsByName(String name) {
		return employeeService.findByName(name);
		
		
//		Query q = entityManger.createQuery("select c from EMPLOYEEDB as c where c.name =:name");
//		q.setParameter("name", name);
//		return q.getResultList();
	}
}
