package com.sugelamei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class MicroserviceConsumerMovieFeignHystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieFeignHystrixTurbineApplication.class, args);
    }

}
