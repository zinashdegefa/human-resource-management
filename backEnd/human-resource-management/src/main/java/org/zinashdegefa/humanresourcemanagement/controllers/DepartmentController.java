package org.zinashdegefa.humanresourcemanagement.controllers;

import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.services.DepartmentService;

import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/addDepartment")
    private String addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return "Department Successfully added";
    }

    @GetMapping("/getAllDepartments")

    public List<Department> departments() {
        List<Department> departments = departmentService.getAllDepartments();

        return departments;

    }

    @DeleteMapping("/department/delete/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId) {
        departmentService.deleteDepartment(departmentId);
        return "Id number " + departmentId + " is deleted!";
    }
}
