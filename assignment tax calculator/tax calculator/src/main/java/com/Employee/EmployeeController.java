package com.Employee;


import com.domain.Employee;
import com.repository.EmployeeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    @RequestMapping("/ans")
    public String PostFrom(@ModelAttribute Employee employee)throws SQLException
    {
        employee.setYearlysalary(employee.getMonthlysalary()*12);
        double tax=employee.getTaxs();

       employee.setTax(tax);
       employee.setNsal(employee.getYearlysalary()-tax);
       employee.setMonthlynsal(employee.getNsal()/12);
       employee.setMonthlytax(tax/12);
        employeeRepo.create(employee);

        return "ans";
    }

}
