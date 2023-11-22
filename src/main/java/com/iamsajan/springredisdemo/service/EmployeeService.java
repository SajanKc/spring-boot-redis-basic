//package com.iamsajan.springredisdemo.service;
//
//import com.iamsajan.springredisdemo.model.Employee;
//import com.iamsajan.springredisdemo.repository.EmployeeRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class EmployeeService {
//
//    private final EmployeeRepository employeeRepository;
//
//    public Employee getEmployeeById(String id) {
//        return this.employeeRepository.findById(id).orElse(null);
//    }
//
//    public void saveEmployee(Employee employee) {
//        this.employeeRepository.save(employee);
//    }
//}
