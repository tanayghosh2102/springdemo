package com.may2020.crudDemo.controller;

import com.may2020.crudDemo.model.Employee;
import com.may2020.crudDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getallemployees")
    List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees;
    }

    @PostMapping("/addEmployee")
    Employee addEmployee(@Valid @RequestBody Employee employeeObj) {
        return employeeRepository.save(employeeObj);
    }
}
