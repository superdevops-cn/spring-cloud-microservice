package com.sugelamei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class MicroserviceConsumerMovieRibbonHystrixTurbineMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieRibbonHystrixTurbineMqApplication.class, args);
    }

}
