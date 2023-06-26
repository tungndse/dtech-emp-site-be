package com.tutorial.empsite.controller;

import com.tutorial.empsite.model.Employee;
import com.tutorial.empsite.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*") //TODO Get the exact Cross Origin ok
public class EmployeeController {

    private final EmployeeService empService;

    /**
     * Bringing in an Employee Service instance
     */
    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    /**
     * Getting all employees
     */
    @GetMapping
    public List<Employee> getAll() {
        return empService.getAllEmployee();
    }

    /**
     * Getting one employee(id)
     */
    @GetMapping("/{id}")
    public Optional<Employee> getOne(@PathVariable Long id) {
        return empService.getEmployeeById(id);
    }

    /**
     * Saving one employee(id)
     */
    @PostMapping
    public Employee saveOne(@RequestBody Employee employee) {
        return empService.saveEmployee(employee);
    }

    /**
     * Edit one employee(id)
     */
    @PutMapping("/{id}")
    public Employee updateOne(@PathVariable Long id, @RequestBody Employee desiredEmployee) {
        return empService.updateEmployee(id, desiredEmployee);
    }

    /**
     * Delete one employee(id)
     */
    @DeleteMapping("{id")
    public void deleteOne(@PathVariable Long id) {
        empService.deleteEmployee(id);
    }

}
