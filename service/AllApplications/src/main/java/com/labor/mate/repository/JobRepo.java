package com.labor.mate.repository;

import com.labor.mate.dto.JobDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "job-service", url = "${job.service.url}")
public interface JobRepo {
    @GetMapping("/jobs/{id}")
    JobDTO getJobById(@PathVariable Long id);
}
