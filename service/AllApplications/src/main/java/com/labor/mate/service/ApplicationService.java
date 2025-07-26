package com.labor.mate.service;

import com.labor.mate.dto.JobDTO;
import com.labor.mate.dto.UserDTO;
import com.labor.mate.enumeration.ApplicationStatus;
import com.labor.mate.model.Application;
import com.labor.mate.repository.ApplicationRepository;
import com.labor.mate.repository.JobRepo;
import com.labor.mate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepo;

    @Autowired
    private UserRepo userClient;

    @Autowired
    private JobRepo jobClient;

    public Application apply(Long userId, Long jobId) {
        // Fetch user and job info from external services
        UserDTO user = userClient.getUserById(userId);
        JobDTO job = jobClient.getJobById(jobId);

        // You could add skill matching logic here if needed

        Application app = new Application();
        app.setUserId(userId);
        app.setJobId(jobId);
        app.setAppliedDate(new Date());
        app.setStatus(ApplicationStatus.APPLIED);

        return applicationRepo.save(app);
    }

    public Application updateStatus(Long id, ApplicationStatus status) {
        Application app = applicationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        app.setStatus(status);
        return applicationRepo.save(app);
    }

    public List<Application> getByUserId(Long userId) {
        return applicationRepo.findByUserId(userId);
    }

    public List<Application> getByJobId(Long jobId) {
        return applicationRepo.findByJobId(jobId);
    }
}

