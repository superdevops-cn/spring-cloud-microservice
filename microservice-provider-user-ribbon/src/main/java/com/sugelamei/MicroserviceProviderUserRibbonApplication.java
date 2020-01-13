package com.sugelamei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.sugelamei.mapper")
@SpringBootApplication
public class MicroserviceProviderUserRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProviderUserRibbonApplication.class, args);
    }

}
