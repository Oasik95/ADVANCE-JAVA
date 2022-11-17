package com.controller;


import com.domain.LeaveType;
import com.service.LeaveTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/LeaveType")

public class LeaveTypeController {

    private LeaveTypeService leaveTypeService;

    public LeaveTypeController(LeaveTypeService leaveTypeService) {
        this.leaveTypeService = leaveTypeService;
    }



    @RequestMapping("/create")
    public String create() throws SQLException {
        LeaveType leaveType=new LeaveType();
        leaveType.setCategory("Sick Leave");
        leaveType.setTotalDays(10);
        leaveTypeService.insert(leaveType);
        return "created";
    }
}
