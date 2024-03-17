package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.Department;

import java.util.List;

public interface DepartmentService {
    void saveDepartment(Department department);
    List<Department> getAllDepartments();
    void deleteDepartment(int departmentId);
    void updateDepartment(Department department);
    Department getDepartmentById(int departmentId);
}