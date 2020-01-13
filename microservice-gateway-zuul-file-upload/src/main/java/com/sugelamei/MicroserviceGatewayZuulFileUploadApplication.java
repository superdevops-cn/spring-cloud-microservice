package com.sugelamei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceGatewayZuulFileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceGatewayZuulFileUploadApplication.class, args);
    }

}
