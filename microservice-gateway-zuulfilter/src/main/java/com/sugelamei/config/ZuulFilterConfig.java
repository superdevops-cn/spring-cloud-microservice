package com.sugelamei.config;

import com.sugelamei.filter.PostLogZuulFilter;
import com.sugelamei.filter.PreLogZuulFilter;
import com.sugelamei.filter.RouteLogZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulFilterConfig {

    @Bean
    public PreLogZuulFilter preLogZuulFilter(){
        return new PreLogZuulFilter();
    }

    @Bean
    public PostLogZuulFilter postLogZuulFilter(){
        return  new PostLogZuulFilter();
    }

    @Bean
    public RouteLogZuulFilter routeLogZuulFilter(){
        return  new RouteLogZuulFilter();
    }
}
