package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.Department;

import java.util.List;

// Department Service Interface

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    void deleteDepartment(int departmentId);

    void updateDepartment(Department department);

    Department getDepartmentById(int departmentId);

    Department getDepartmentByName(String name);
}
