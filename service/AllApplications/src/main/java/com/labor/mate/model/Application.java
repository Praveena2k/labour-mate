package com.labor.mate.model;

import com.labor.mate.enumeration.ApplicationStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Application {
    @Id
    @GeneratedValue
    private Long applicationId;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private Date appliedDate;

    private Long userId;
    private Long jobId;

    // Getters/setters

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}
