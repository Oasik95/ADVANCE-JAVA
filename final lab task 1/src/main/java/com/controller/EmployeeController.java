package com.controller;


import com.constant.Gender;
import com.constant.Status;
import com.domain.Employee;
import com.domain.LeaveApplication;
import com.domain.LeaveType;
import com.service.EmployeeService;
import com.service.LeaveApplicationService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;
import java.time.LocalDate;

@Controller
@RequestMapping("/Employee")

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @RequestMapping("/createEmploye")
    public String create() throws SQLException {
        Employee employee=new Employee();
       employee.setFirstname("oasik");
       employee.setLastname("jaber");
       employee.setGender(Gender.MALE);
       employee.setEmail("zhoasik999@gmail.com");
       employee.setJoininDate(LocalDate.ofEpochDay(10));
      employee.setStatus(Status.ACTIVE);
        employeeService.insert(employee);
        return "created";
    }

}
