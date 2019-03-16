package com.circuitbreaker.controller;

import com.circuitbreaker.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    @Autowired
    GreetingService greetSvc;

    private static Logger LOG = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping("/greeting/{username}")
  public  String greeting(@PathVariable("username") String username){
        LOG.info("Greeting incoming user: {}",username);
        return greetSvc.greeting(username);
    }

    @RequestMapping("/greet")
    public  String greet(){
        LOG.info("Greetings to all!");
        return greetSvc.greeting("TDCR");
    }
}
