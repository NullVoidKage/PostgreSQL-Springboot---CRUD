package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto getEmployee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(getEmployee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> list = employeeService.getAllEmployees();
        return ResponseEntity.ok(list);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable("id") Long employeeId,
            @RequestBody EmployeeDto updatedEmployee
    ) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,
                updatedEmployee);

        return ResponseEntity.ok(employeeDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(
            @PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Employee deleted " + employeeId + " successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployee() {
        employeeService.deleteAllEmployee();
        return ResponseEntity.ok("All employees deleted");
    }


}
