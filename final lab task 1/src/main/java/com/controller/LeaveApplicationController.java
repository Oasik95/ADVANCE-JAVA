package com.controller;


import com.domain.LeaveApplication;
import com.domain.LeaveType;
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
@RequestMapping("/leaveApplicaiton")

public class LeaveApplicationController {

    private LeaveApplicationService leaveApplicationService;

    public LeaveApplicationController(LeaveApplicationService leaveApplicationService) {
        this.leaveApplicationService = leaveApplicationService;
    }
    @RequestMapping("/createleave")
    public String create() throws SQLException {
        LeaveApplication leaveApplication=new LeaveApplication();
        leaveApplication.setFromLeaveDate(LocalDate.ofEpochDay(10));
        leaveApplication.setToLeaveDate(LocalDate.ofEpochDay(20));
        leaveApplication.getTotalLeaveDays(10);
        leaveApplication.setReason("sick");
        leaveApplicationService.insert(leaveApplication);
        return "created";
    }

}
