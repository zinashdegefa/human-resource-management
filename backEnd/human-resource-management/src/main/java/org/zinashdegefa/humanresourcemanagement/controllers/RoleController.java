package org.zinashdegefa.humanresourcemanagement.controllers;

import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Manager;
import org.zinashdegefa.humanresourcemanagement.models.Role;
import org.zinashdegefa.humanresourcemanagement.services.RoleService;

import java.util.List;

@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {

        this.roleService = roleService;
    }

    @PostMapping("/saveRole")
    private String saveRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return "Role Successfully added";
    }

    @GetMapping("/getAllRoles")

    public List<Role> roles () {
        List<Role> roles = roleService.getAllRoles();

        return roles;
    }

    @DeleteMapping("/role/delete/{roleId}")
    public String deleteRole(@PathVariable int roleId) {
        roleService.deleteRole(roleId);
        return "Id number " + roleId + " is deleted!";
    }

    @PutMapping("/updateRole")
    public Role updateRole(@RequestBody Role role) {
        roleService.saveRole(role);
        System.out.println(role.getRoleName() + " is updated!");
        return role;
    }
}
