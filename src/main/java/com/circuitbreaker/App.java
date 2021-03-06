package com.circuitbreaker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class App 
{

    private static Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ){
        SpringApplication app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        LOG.info("Hystrix Application deployed successfully");
    }
}
