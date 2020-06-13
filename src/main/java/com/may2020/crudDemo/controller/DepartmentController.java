package com.may2020.crudDemo.controller;

import com.may2020.crudDemo.model.Department;
import com.may2020.crudDemo.model.Employee;
import com.may2020.crudDemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/getalldepartments")
    List<Department> getAllEmployees() {
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    @PostMapping("/adddepartment")
    Department addDepartment(@Valid @RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("/updatdepartment/{id}")
    Department replaceEmployee(@RequestBody Department newDepartment, @PathVariable Long id) {

        return departmentRepository.findById(id)
                .map(department -> {
                    department.setArea(newDepartment.getArea());
                    department.setName(newDepartment.getName());
                    return departmentRepository.save(department);
                })
                .orElseGet(() -> {
                    newDepartment.setId(id);
                    return departmentRepository.save(newDepartment);
                });
    }

    @DeleteMapping("/deletedepartment/{id}")
    void deleteEmployee(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }
}
