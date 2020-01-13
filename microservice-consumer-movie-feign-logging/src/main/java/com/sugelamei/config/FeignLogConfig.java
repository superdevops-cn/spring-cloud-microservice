package com.sugelamei.config;



import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level  feignLogLevel(){
        return Logger.Level.FULL;
        //return Logger.Level.BASIC;
    }
}
