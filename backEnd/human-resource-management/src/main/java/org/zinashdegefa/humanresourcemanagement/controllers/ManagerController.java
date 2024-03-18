package org.zinashdegefa.humanresourcemanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.*;
import org.zinashdegefa.humanresourcemanagement.services.DepartmentService;
import org.zinashdegefa.humanresourcemanagement.services.ManagerService;

import java.util.List;

@Controller
public class ManagerController {

    private final ManagerService managerService;
    private final DepartmentService departmentService;

    public ManagerController(ManagerService managerService, DepartmentService departmentService) {
        this.managerService = managerService;
        this.departmentService = departmentService;
    }

    @PostMapping("/saveManager")
    private String saveManager(@ModelAttribute("manager") Manager manager) {
        System.out.println("Manager to be updated:/saved "+ manager);
        managerService.saveManager(manager);
        return "redirect:/getAllManagers";
    }

    @GetMapping("/getAllManagers")

    public String managers(Model model) {
        List<Manager> managers = managerService.getAllManagers();
        model.addAttribute("managers", managers);

        return "all-managers";

    }

    @GetMapping("/getManagerById/{managerId}")
    public Manager getManagerById(@PathVariable int managerId){

        return managerService.getManagerById(managerId);
    }

    @RequestMapping("/manager/delete/{managerId}")
    public String deleteDepartment(@PathVariable int managerId) {
        managerService.deleteManager(managerId);
        return "redirect:/getAllManagers";
    }

    @PutMapping("/updateManager")
    public Manager updateManager(@RequestBody Manager manager) {
        managerService.saveManager(manager);
        System.out.println(manager.getId() + " is updated!");
        return manager;
    }

    @RequestMapping("/addManForm")
    public String addForm(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        Manager manager = new Manager();
        model.addAttribute("manager", manager);
        model.addAttribute("departments", departments);
        return "add-man-form";
    }




}
