package com.example.backendproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name="leave_balances",catalog="leave_system")
public class LeaveBalancesEntity {
    private Integer id;
    private UserEntity userId;
    private LeaveTypesEntity leaveTypeId;
    private String year;
    private Integer remainingDays;

    public LeaveBalancesEntity() {
        super();
    }

    public LeaveBalancesEntity(Integer id, UserEntity userId, LeaveTypesEntity leaveTypeId, String year, Integer remainingDays) {
        this.id = id;
        this.userId = userId;
        this.leaveTypeId = leaveTypeId;
        this.year = year;
        this.remainingDays = remainingDays;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    public LeaveTypesEntity getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(LeaveTypesEntity leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    @Column(name = "year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Column(name = "remaining_days")
    public Integer getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(Integer remainingDays) {
        this.remainingDays = remainingDays;
    }
}
