package com.stl.test.repository.service;

import com.stl.test.model.Employee;
import com.stl.test.repository.EmployeeRepository;
import com.stl.test.repository.exceptions.EmployeeByIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> allEmployees() {
        return employeeRepository.findAll();
    }

    public Employee viewEmployeeDetails(Integer id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeByIdNotFoundException("User by id: " + " does not exist!"));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeInfo(Integer id, Employee employee) {
        Employee savedEmployee = employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeByIdNotFoundException("User by id: " + " does not exist!"));

        savedEmployee.setDepartment(employee.getDepartment());
        savedEmployee.setEmailAddress(employee.getEmailAddress());
        savedEmployee.setFirstName(employee.getFirstName());
        savedEmployee.setLastName(employee.getLastName());
        savedEmployee.setEmailAddress(employee.getEmailAddress());
        savedEmployee.setRole(employee.getRole());
        savedEmployee.setImageUrl(employee.getImageUrl());
        return employeeRepository.save(savedEmployee);
    }

    public void  deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}