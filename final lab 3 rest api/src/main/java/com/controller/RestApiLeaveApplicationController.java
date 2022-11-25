package com.controller;

import com.domain.LeaveApplication;
import com.domain.LeaveType;
import com.domain.Student;
import com.service.LeaveApplicationService;
import com.service.LeaveTypeService;
import com.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiLeaveApplicationController {

    private LeaveApplicationService leaveApplicationService;

    private LeaveTypeService leaveTypeService;

    private StudentService studentService;

    public RestApiLeaveApplicationController(LeaveApplicationService leaveApplicationService, LeaveTypeService leaveTypeService, StudentService studentService) {
        this.leaveApplicationService = leaveApplicationService;
        this.leaveTypeService = leaveTypeService;
        this.studentService = studentService;
    }


    @PostMapping ("/api/leaveApplications")
    public boolean create() throws Exception {
        LeaveType leaveType = leaveTypeService.get(1L);
        Student student = studentService.get(1L);

        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setStudent(student);
        leaveApplication.setLeaveType(leaveType);

        leaveApplication.setFromDate(LocalDate.of(2022, 10, 20));
        leaveApplication.setToDate(LocalDate.of(2022, 10, 28));
        leaveApplication.setTotalDays(9);
        leaveApplication.setReason("High Fever");
        boolean result = leaveApplicationService.insert(leaveApplication);
        System.out.println(result);
        if (!result) {
            throw new Exception("Constraint Violation");
        }
        return result;
    }

    @GetMapping ("/leaveApplication/{id}")
    public LeaveApplication get(@PathVariable("id")String id) {
        LeaveApplication leaveApplication = leaveApplicationService.get(Long.valueOf(id));

        return leaveApplication;
    }

    @GetMapping("/leaveApplications")
    public List<LeaveApplication> getAll()
    {
        return leaveApplicationService.list();
    }
    @PutMapping ("/leaveApplication/{id}")
    public LeaveApplication update(@PathVariable("id")String id) {
        LeaveApplication leaveApplication = leaveApplicationService.get(Long.valueOf(id));
        leaveApplication.setReason("covid");
        leaveApplicationService.update(leaveApplication);
        return leaveApplication;
    }
    @DeleteMapping  ("/leaveApplication/{id}")
    public LeaveApplication delete(@PathVariable("id")String id) {
        LeaveApplication leaveApplication = leaveApplicationService.get(Long.valueOf(id));
        leaveApplicationService.delete(leaveApplication);

        return leaveApplication;
    }
}
