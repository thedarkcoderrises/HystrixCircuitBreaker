package com.circuitbreaker.test.service.impl;

import com.circuitbreaker.test.service.GreetingService;
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
        return String.format("Hello %s \n Welcome to Docker!\n", username);
    }

    private String defaultGreeting(String username) {
        return "Invalid User!!";
    }
}
