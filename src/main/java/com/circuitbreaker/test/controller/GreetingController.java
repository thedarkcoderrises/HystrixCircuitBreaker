package com.circuitbreaker.test.controller;

import com.circuitbreaker.test.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    @Autowired
    GreetingService greetSvc;

    @RequestMapping("/greeting/{username}")
  public  String greeting(@PathVariable("username") String username){
        return greetSvc.greeting(username);
    }
}
