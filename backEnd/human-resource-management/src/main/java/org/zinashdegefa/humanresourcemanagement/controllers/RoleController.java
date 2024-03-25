package org.zinashdegefa.humanresourcemanagement.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Role;
import org.zinashdegefa.humanresourcemanagement.services.RoleService;

import java.util.List;

// Role Controller with CRUD path
@Slf4j
@Controller
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {

        this.roleService = roleService;
    }

    @PostMapping("/save/role")
    private String saveRole(@Valid @ModelAttribute("role") Role role, BindingResult result, Model model) {
        System.out.println("Role to be updated:/saved " + role);


        Role existingRole = roleService.getRoleByName(role.getRoleName());

        if (existingRole != null && existingRole.getRoleName() != null && !existingRole.getRoleName().isEmpty()) {
            result.rejectValue("roleName", null, "There is already a role registered with the same name");
        }

        if (result.hasErrors()) {
            model.addAttribute("role", role);
            return "add_role_form";
        }

        roleService.saveRole(role);
        return "redirect:/getAll/roles";
    }


    @GetMapping("/getAll/roles")

    public String roles(Model model) {
        List<Role> roles = roleService.getAllRoles();
        for (Role role : roles) {
            log.info("Role name: {}", role.getRoleName());
        }
        model.addAttribute("roles", roles);

        return "all_roles";
    }

    @GetMapping("/getRoleById/{roleId}")
    public Role getRoleById(@PathVariable int roleId) {

        return roleService.getRoleById(roleId);
    }

    @RequestMapping("/delete/role/{roleId}")
    public String deleteRole(@PathVariable int roleId) {

        try {
            roleService.deleteRole(roleId);
            System.out.println("Id number " + roleId + " is deleted!");
            return "redirect:/getAll/roles";
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return "redirect:/getAll/roles?failed";
        }
    }

    @PutMapping("/update/role")
    public Role updateRole(@RequestBody Role role) {
        roleService.saveRole(role);
        System.out.println(role.getRoleName() + " is updated!");
        return role;
    }

    @RequestMapping("/add/roleForm")
    public String addForm(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "add_role_form";
    }
}
