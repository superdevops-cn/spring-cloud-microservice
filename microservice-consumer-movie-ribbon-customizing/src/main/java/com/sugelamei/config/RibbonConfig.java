package com.sugelamei.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {

    @Bean
    public IRule iRule() {
        //修改负载均衡算法为随机算法
        return new RandomRule();
    }
}

