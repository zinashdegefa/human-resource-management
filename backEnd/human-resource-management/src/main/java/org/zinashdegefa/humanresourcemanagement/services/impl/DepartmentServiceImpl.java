package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.repositories.DepartmentRepository;
import org.zinashdegefa.humanresourcemanagement.services.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository)
    {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public void addDepartment(Department department) {

        departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> Departments = departmentRepository.findAll();

        return Departments;

    }

    @Override
    @Transactional
    public void deleteDepartment(int departmentId) {
        departmentRepository.deleteById((long) departmentId);
        System.out.println("The department with id number "  + departmentId + " is deleted!");
    }
}
