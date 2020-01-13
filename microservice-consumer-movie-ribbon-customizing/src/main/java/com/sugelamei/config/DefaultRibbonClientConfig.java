package com.sugelamei.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@RibbonClients(defaultConfiguration = DefaultRibbonConfig.class)
public  class DefaultRibbonClientConfig {
    public static class DefaultServerList extends ConfigurationBasedServerList{

        public  DefaultServerList(IClientConfig clientConfig) {
            super.initWithNiwsConfig(clientConfig);
        }
    }
}


