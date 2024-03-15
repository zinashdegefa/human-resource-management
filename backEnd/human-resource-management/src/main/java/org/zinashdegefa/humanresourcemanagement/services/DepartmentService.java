package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);
    List<Department> getAllDepartments();
    void deleteDepartment(int departmentId);
}
