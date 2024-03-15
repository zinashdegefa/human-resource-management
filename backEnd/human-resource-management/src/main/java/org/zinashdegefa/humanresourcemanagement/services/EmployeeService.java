package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);

    List<Employee> getAllEmployees();
    void deleteEmployee(int employeeId);
    void updateEmployee(Employee employee);
    Employee getEmployeeById(int employeeId);

}
