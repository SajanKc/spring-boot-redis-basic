package com.iamsajan.springredisdemo.controller;

import com.iamsajan.springredisdemo.model.Employee;
import com.iamsajan.springredisdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public void saveEmployee(@RequestBody Employee employee) {
        this.employeeRepository.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return this.employeeRepository.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.getEmployees();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable String id) {
        return this.employeeRepository.deleteEmployee(id);
    }
}
