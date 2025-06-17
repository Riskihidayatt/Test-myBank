package com.myBank.Mybank;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HealthController {

    @GetMapping("/")
    public String home() {
        return "Spring Boot Application is running!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/api/status")
    public ApiResponse status() {
        return new ApiResponse("success", "Application is healthy", System.currentTimeMillis());
    }
}

