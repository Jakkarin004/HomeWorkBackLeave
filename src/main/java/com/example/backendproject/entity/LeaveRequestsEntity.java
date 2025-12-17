package com.example.backendproject.entity;


import jakarta.persistence.*;

@Entity
@Table(name="leave_requests",catalog="leave_system")
public class LeaveRequestsEntity {

    private Integer id;
    private UserEntity userID;
    private LeaveTypesEntity leaveTypeId;
    private String startDate;
    private String endDate;
    private String status;
    private String reason;
    private String comment;

    public LeaveRequestsEntity() {
        super();
    }

    public LeaveRequestsEntity(Integer id, UserEntity userID, LeaveTypesEntity leaveTypeId, String startDate, String endDate, String status, String reason,String comment) {
        this.id = id;
        this.userID = userID;
        this.leaveTypeId = leaveTypeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.reason = reason;
        this.comment = comment;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity getUserID() {
        return userID;
    }

    public void setUserID(UserEntity userID) {
        this.userID = userID;
    }

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    public LeaveTypesEntity getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(LeaveTypesEntity leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    @Column(name = "start_date")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
