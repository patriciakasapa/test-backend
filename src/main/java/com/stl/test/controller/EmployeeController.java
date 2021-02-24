package com.stl.test.controller;

import com.stl.test.model.Employee;
import com.stl.test.repository.service.EmployeeService;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final Logger logger = Logger.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        logger.info("Getting all employees" );
        List<Employee> employees = employeeService.allEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeDetails (@PathVariable("id") Integer id) {
        logger.info("Getting  employees with id= " + id );
        Employee employee = employeeService.viewEmployeeDetails(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        logger.info("Creating new employees with payload " + employee.toString());
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        logger.info("Updating  employees with id= " + id + " with payload " + employee.toString());
        Employee updateEmployee = employeeService.updateEmployeeInfo(id, employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Integer id) {
        logger.info("Deleting  employees with id= " + id );
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}