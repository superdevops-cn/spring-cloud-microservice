package com.sugelamei;

import com.sugelamei.config.FeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroserviceConsumerMovieFeignCustomizingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieFeignCustomizingApplication.class, args);
    }

}
