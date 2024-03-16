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

    @PostMapping("/saveDepartment")
    private String saveDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
        return "Department Successfully added";
    }

    @GetMapping("/getAllDepartments")

    public List<Department> departments() {
        List<Department> departments = departmentService.getAllDepartments();

        return departments;

    }

    @GetMapping("/getDepartmentById/{departmentId}")
    public Department getDepartmentById(@PathVariable int departmentId){

        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/delete/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId) {
        departmentService.deleteDepartment(departmentId);
        return "Id number " + departmentId + " is deleted!";
    }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
        System.out.println(department.getDepartmentName() + " is updated!");
        return department;
    }
}
