package com.circuitbreaker.controller;

import com.circuitbreaker.App;
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

    private static Logger LOG = LoggerFactory.getLogger(App.class);

    @RequestMapping("/greeting/{username}")
  public  String greeting(@PathVariable("username") String username){

        LOG.warn("WARN");
        LOG.info("INFO");
        LOG.debug("DEBUG");
        return greetSvc.greeting(username);
    }
}
