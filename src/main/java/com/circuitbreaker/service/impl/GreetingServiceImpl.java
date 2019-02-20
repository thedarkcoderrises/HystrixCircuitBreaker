package com.circuitbreaker.service.impl;

import com.circuitbreaker.service.GreetingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public String greeting(String username) {
        if("cb".equalsIgnoreCase(username)){
            throw new NullPointerException();
        }
        return String.format("Hello %s Welcome to Docker CI\\CD!", username.toUpperCase());
    }

    private String defaultGreeting(String username) {
        return "Invalid User!!";
    }
}
