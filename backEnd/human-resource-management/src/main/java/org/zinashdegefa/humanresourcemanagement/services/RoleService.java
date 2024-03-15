package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.Role;

import java.util.List;

public interface RoleService {

    void saveRole(Role role);
    List<Role> getAllRoles();
    void deleteRole(int roleId);
    void updateRole(Role role);
}
