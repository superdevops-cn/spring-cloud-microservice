package com.sugelamei.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
/*
 使用RibbonClient为特定name的RibbonClient自定义配置。
 使用@RibbonClient的configuration属性，指定Ribbon的配置类。
 */
@Configuration
@RibbonClient(name = "microservice-provider-user-ribbon",configuration = RibbonConfig.class)
public class RibbonClientConfig {

}
