package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.UserModel;

import java.util.List;

// Department Service Interface

public interface DepartmentService {
    void saveDepartment(Department department);
    List<Department> getAllDepartments();
    void deleteDepartment(int departmentId);
    void updateDepartment(Department department);
    Department getDepartmentById(int departmentId);

    Department getDepartmentByName(String name);
}
