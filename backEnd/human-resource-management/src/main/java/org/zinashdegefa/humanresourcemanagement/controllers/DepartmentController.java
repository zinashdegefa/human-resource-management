package org.zinashdegefa.humanresourcemanagement.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.*;
import org.zinashdegefa.humanresourcemanagement.services.DepartmentService;

import java.util.List;


// Department Controller with CRUD path
@Slf4j
@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save/department")
    private String saveDepartment(@Valid @ModelAttribute("department") Department department, BindingResult result, Model model) {
        log.info("Result for department: " + result);
        log.info("Department to be saved "+ department);

        Department existingDepartment = departmentService.getDepartmentByName(department.getDepartmentName());

        if (existingDepartment != null && existingDepartment.getDepartmentName() != null && !existingDepartment.getDepartmentName().isEmpty()) {
           result.rejectValue("departmentName", null, "There is already a department registered with the same name");
        }

        if(result.hasErrors()){
            model.addAttribute("department", department);
            return "add_department_form";
        }
        departmentService.saveDepartment(department);
        return "redirect:/getAll/departments";
    }


    @GetMapping("/getAll/departments")

    public String departments (Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        for (Department dep: departments){
            log.info("Department name: " + dep.getDepartmentName());
        }
        model.addAttribute("departments", departments);
        return "all_departments";
    }


    @GetMapping("/getDepartmentById/{departmentId}")
    public Department getDepartmentById(@PathVariable int departmentId){

        return departmentService.getDepartmentById(departmentId);
    }

    @RequestMapping("/delete/department/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId) {

        try{
            departmentService.deleteDepartment(departmentId);
            log.info("Id number " + departmentId + " is deleted!");
            return "redirect:/getAll/departments";
        } catch (Exception e) {
            log.error("Exception: " + e);
            return "redirect:/getAll/departments?failed";
        }
    }

    @PutMapping("/update/department")
    public Department updateDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
        log.info(department.getDepartmentName() + " is updated!");
        return department;
    }

    @GetMapping("/add/depForm")
    public String addForm(Model model) {
       Department department = new Department();
        model.addAttribute("department", department);
        return "add_department_form";
    }
}
