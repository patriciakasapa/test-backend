package com.stl.test.repository.service;

import com.stl.test.model.Employee;
import com.stl.test.repository.EmployeeRoom;
import com.stl.test.repository.exceptions.EmployeeByIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRoom employeeRoom;

    @Autowired
    public EmployeeService(EmployeeRoom employeeRoom) {
        this.employeeRoom = employeeRoom;
    }

    public List<Employee> allEmployees() {
        return employeeRoom.findAll();
    }

    public Employee viewEmployeeDetails(Integer id) {
        return employeeRoom.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeByIdNotFoundException("User by id: " + " does not exist!"));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRoom.save(employee);
    }

    public Employee updateEmployeeInfo(Employee employee) {
        return employeeRoom.save(employee);
    }

    public void  deleteEmployee(Integer id) {
        employeeRoom.deleteEmployeeById(id);
    }
}
