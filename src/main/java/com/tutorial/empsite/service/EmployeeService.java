package com.tutorial.empsite.service;

import com.tutorial.empsite.model.Employee;
import com.tutorial.empsite.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id,Employee desiredEmployee) {
        return repository.findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setFirstName(desiredEmployee.getFirstName());
                    existingEmployee.setLastName(desiredEmployee.getLastName());
                    existingEmployee.setEmail(desiredEmployee.getEmail());
                    return repository.save(existingEmployee);
                })
                .orElseGet(() -> {
                    desiredEmployee.setId(id);
                    return repository.save(desiredEmployee);
                });
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}

