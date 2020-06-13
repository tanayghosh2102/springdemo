package com.may2020.crudDemo.controller;

import com.may2020.crudDemo.model.Employee;
import com.may2020.crudDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getallemployees")
    List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees;
    }

    @GetMapping("/getemployee/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(new Employee());
    }

    @PutMapping("/updatemployee/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFname(newEmployee.getFname());
                    employee.setLname(newEmployee.getLname());
                    employee.setEmailId(newEmployee.getEmailId());
                    employee.setSalary(newEmployee.getSalary());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }

    @PostMapping("/addemployee")
    Employee addEmployee(@Valid @RequestBody Employee employeeObj) {
        return employeeRepository.save(employeeObj);
    }

    @DeleteMapping("/deletemployee/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
