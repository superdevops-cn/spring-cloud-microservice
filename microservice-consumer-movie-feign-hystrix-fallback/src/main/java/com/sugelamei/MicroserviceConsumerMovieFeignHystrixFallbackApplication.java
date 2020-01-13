package com.sugelamei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceConsumerMovieFeignHystrixFallbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieFeignHystrixFallbackApplication.class, args);
    }

}
