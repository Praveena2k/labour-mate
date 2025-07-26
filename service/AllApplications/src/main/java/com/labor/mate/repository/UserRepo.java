package com.labor.mate.repository;

import com.labor.mate.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${user.service.url}")
public interface UserRepo {
    @GetMapping("/users/{id}")
    UserDTO getUserById(@PathVariable Long id);
}
