package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);
    List<Role> getAllRoles();
    void deleteRole(int roleId);
}
