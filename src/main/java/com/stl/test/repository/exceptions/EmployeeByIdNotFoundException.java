package com.stl.test.repository.exceptions;

public class EmployeeByIdNotFoundException extends RuntimeException {
    public EmployeeByIdNotFoundException(String message) {
        super(message);
    }
}
