package com.sugelamei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class MicroserviceConsumerMovieRibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieRibbonHystrixApplication.class, args);
    }

}
