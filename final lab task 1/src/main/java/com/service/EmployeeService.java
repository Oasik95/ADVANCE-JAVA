package com.service;

import com.domain.Employee;
import com.domain.LeaveApplication;
import com.repository.EmployeeRepository;
import com.repository.LeaveApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public boolean insert(Employee employee) throws SQLException {

        return employeeRepository.create(employee);
    }
}