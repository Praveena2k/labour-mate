package com.labor.mate.controller;

import com.labor.mate.JobApplication;
import com.labor.mate.enumeration.ApplicationStatus;
import com.labor.mate.model.Application;
import com.labor.mate.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService service;


    @PostMapping("/apply")
    public ResponseEntity<Application> apply(
            @RequestParam Long userId,
            @RequestParam Long jobId) {

        return ResponseEntity.ok(service.apply(userId, jobId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Application> updateStatus(
            @PathVariable Long id,
            @RequestParam ApplicationStatus status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }

    @GetMapping("/user/{userId}")
    public List<Application> byUser(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    @GetMapping("/job/{jobId}")
    public List<Application> byJob(@PathVariable Long jobId) {
        return service.getByJobId(jobId);
    }
}

