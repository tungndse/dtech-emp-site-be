package com.tutorial.empsite.service;

import com.tutorial.empsite.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {

    Employee saveEmployee(Employee employee);
    Optional<Employee> getEmployeeById(Long id);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
