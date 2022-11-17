package com.service;

import com.domain.LeaveApplication;
import com.repository.LeaveApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class LeaveApplicationService {
    private LeaveApplicationRepository leaveApplicationRepository;

    public LeaveApplicationService(LeaveApplicationRepository leaveApplicationRepository) {
        this.leaveApplicationRepository = leaveApplicationRepository;
    }

    @Transactional
    public boolean insert(LeaveApplication leaveApplication) throws SQLException {

        return leaveApplicationRepository.create(leaveApplication);
    }
}