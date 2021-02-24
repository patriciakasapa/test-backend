package com.stl.test.repository;

import com.stl.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findEmployeeById(Integer id);

    @Override
    void deleteById(Integer integer);
}