package org.zinashdegefa.humanresourcemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.UserModel;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

// Custom method to find Department by name
    Department findByDepartmentName(String departmentName);
}
