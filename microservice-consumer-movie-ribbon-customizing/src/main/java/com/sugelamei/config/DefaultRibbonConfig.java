package com.sugelamei.config;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultRibbonConfig {

    @Bean
    public IRule rule(){
        return  new BestAvailableRule();
    }
    @Bean
    public IPing ping(){
        return new PingUrl();
    }

    @Bean
    public ServerList<Server> serverServerList(IClientConfig config){
        return new DefaultRibbonClientConfig.DefaultServerList(config);
    }

    @Bean
    public ServerListSubsetFilter serverListSubsetFilter(){
        return new ServerListSubsetFilter();
    }
}
