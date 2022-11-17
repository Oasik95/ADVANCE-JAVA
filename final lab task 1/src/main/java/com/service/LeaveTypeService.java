package com.service;

import com.domain.LeaveType;
import com.repository.LeaveApplicationRepository;
import com.repository.LeaveTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class LeaveTypeService {
    private LeaveTypeRepository leaveTypeRepository;

    public  LeaveTypeService(LeaveApplicationRepository leaveApplicationRepository) {
        this.leaveTypeRepository = leaveTypeRepository;
    }

    @Transactional
    public boolean insert(LeaveType leaveType) throws SQLException {

        return leaveTypeRepository.create(leaveType);
    }
}