package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dto.EmployeeDto;

public interface EmployeeService extends JpaRepository<EmployeeDto, Integer>{

	List<EmployeeDto> findByName(String name);

}
