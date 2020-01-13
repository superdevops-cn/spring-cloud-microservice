package com.sugelamei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud
 * @description:
 * @author: wxc
 * @create: 2019-11-17 00:08
 **/
@Configuration
public class ConsumerConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
