package com.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leaveApplication")
public class LeaveApplication {
    @Id
    @Column(name = "leave_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee_id;

    private LocalDate fromLeaveDate;//form_leave_date

    private LocalDate toLeaveDate;

    private int totalLeaveDays;

    private  String reason;

    @ManyToOne
    @JoinColumn(name = "leave_Type_id")
    private LeaveType leaveType;

    public void setFromLeaveDate(LocalDate fromLeaveDate) {
        this.fromLeaveDate = fromLeaveDate;
    }

    public LocalDate getFromLeaveDate() {
        return fromLeaveDate;
    }

    public void setToLeaveDate(LocalDate toLeaveDate) {
        this.toLeaveDate = toLeaveDate;
    }

    public LocalDate getToLeaveDate() {
        return toLeaveDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTotalLeaveDays(int i) {
        return totalLeaveDays;
    }

    public void setTotalLeaveDays(int totalLeaveDays) {
        this.totalLeaveDays = totalLeaveDays;
    }

    public String getReason() {
        return reason;
    }
}