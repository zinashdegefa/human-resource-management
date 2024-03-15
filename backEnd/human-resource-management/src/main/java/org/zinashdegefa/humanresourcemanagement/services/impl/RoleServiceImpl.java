package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zinashdegefa.humanresourcemanagement.models.Manager;
import org.zinashdegefa.humanresourcemanagement.models.Role;
import org.zinashdegefa.humanresourcemanagement.repositories.RoleRepository;
import org.zinashdegefa.humanresourcemanagement.services.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository)
    {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) {

        roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        return roles;

    }

    @Override
    @Transactional
    public void deleteRole(int roleId) {
        roleRepository.deleteById((long) roleId);
        System.out.println("The role with id number "  + roleId + " is deleted!");
    }
}
