package org.zinashdegefa.humanresourcemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zinashdegefa.humanresourcemanagement.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
