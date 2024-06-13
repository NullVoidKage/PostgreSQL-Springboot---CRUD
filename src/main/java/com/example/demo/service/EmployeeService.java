package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updated);

    void deleteEmployeeById(Long employeeId);

    void deleteAllEmployee();
}
