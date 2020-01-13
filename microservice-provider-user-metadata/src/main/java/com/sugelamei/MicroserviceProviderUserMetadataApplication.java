package com.sugelamei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sugelamei.mapper")
public class MicroserviceProviderUserMetadataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProviderUserMetadataApplication.class, args);
    }

}
