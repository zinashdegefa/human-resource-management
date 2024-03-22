package org.zinashdegefa.humanresourcemanagement.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.*;
import org.zinashdegefa.humanresourcemanagement.services.DepartmentService;
import org.zinashdegefa.humanresourcemanagement.services.ManagerService;

import java.util.List;


// Manager Controller with CRUD path
@Controller
public class ManagerController {

    private final ManagerService managerService;
    private final DepartmentService departmentService;

    public ManagerController(ManagerService managerService, DepartmentService departmentService) {
        this.managerService = managerService;
        this.departmentService = departmentService;
    }

    @PostMapping("/save/manager")
    private String saveManager(@Valid @ModelAttribute("manager") Manager manager, BindingResult result, Model model) {
        System.out.println("Manager to be updated:/saved " + manager);

    if (manager.getDepartment() != null) {
        Manager existingManager = managerService.getManagerByDepartmentId(manager.getDepartment().getId());

        System.out.println("Existing manger: " + existingManager);

        if (existingManager != null && existingManager.getDepartment() != null && !existingManager.getDepartment().getDepartmentName().isEmpty()) {
            result.rejectValue("department", null, "A manager is already assigned to this department");
        }

    }
        if (result.hasErrors()) {
            List<Department> departments = departmentService.getAllDepartments();
            model.addAttribute("manager", manager);
            model.addAttribute("departments", departments);
            model.addAttribute("manager", manager);
            return "/add-man-form";
        }
        managerService.saveManager(manager);

        return "redirect:/getAll/managers";
    }

    @GetMapping("/getAll/managers")

    public String managers(Model model) {
        List<Manager> managers = managerService.getAllManagers();
        model.addAttribute("managers", managers);

        return "all-managers";

    }

    @GetMapping("/getManagerById/{managerId}")
    public Manager getManagerById(@PathVariable int managerId) {

        return managerService.getManagerById(managerId);
    }

    @RequestMapping("/delete/manager/{managerId}")
    public String deleteDepartment(@PathVariable int managerId) {

        try {
            managerService.deleteManager(managerId);
            System.out.println("Id number " + managerId + " is deleted!");
            return "redirect:/getAll/managers";
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return "redirect:/getAll/managers?failed";
        }

    }

    @PutMapping("/update/manager") // TODO finish this
    public String updateManager(@RequestBody Manager manager, BindingResult result) {
        try {
            managerService.saveManager(manager);
        } catch (Exception e) {
            result.rejectValue("department", null, "There is already .....");  // TODO finish this

            return "/add-man-form";
        }
        System.out.println(manager.getId() + " is updated!");
        return "manager";
    }

    @RequestMapping("/add/manForm")
    public String addForm(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        Manager manager = new Manager();
        model.addAttribute("manager", manager);
        model.addAttribute("departments", departments);
        return "add-man-form";
    }


}
