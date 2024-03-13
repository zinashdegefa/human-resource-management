package org.zinashdegefa.humanresourcemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zinashdegefa.humanresourcemanagement.models.Employee;

public interface employeeRepository extends JpaRepository<Employee, Long> {
}
