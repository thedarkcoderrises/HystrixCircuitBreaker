package com.circuitbreaker.service.impl;

import com.circuitbreaker.service.GreetingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    private static Logger LOG = LoggerFactory.getLogger(GreetingServiceImpl.class);
    @Override
    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public String greeting(String username) {
        if("cb".equalsIgnoreCase(username)){
            throw new NullPointerException();
        }
        String temp = String.format("Hello %s Welcome to Docker CI\\CD!", username.toUpperCase());
        LOG.info(temp);
        return temp;
    }

    private String defaultGreeting(String username) {
        if(username.startsWith("cb"))
        LOG.info("Hystrix fallBackMethod executed! for invalid user: {}",username);
        return "Invalid User!!";
    }
}
