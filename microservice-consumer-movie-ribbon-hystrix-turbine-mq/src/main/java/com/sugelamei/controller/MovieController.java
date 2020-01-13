package com.sugelamei.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sugelamei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud
 * @description:
 * @author: wxc
 * @create: 2019-11-17 00:14
 **/

@RestController
public class MovieController {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER-RIBBON/user/" + id, User.class);
    }


    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("default");
        user.setDataBase("default");

        return user;
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
    },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "101"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
            }, fallbackMethod = "findByIdFallback")
    @GetMapping("user0/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER-RIBBON/user/" + id, User.class);
    }

    @HystrixCommand(fallbackMethod = "findByIdFallback",
            ignoreExceptions = {IllegalArgumentException.class, NullPointerException.class})
    @GetMapping("/user1/{id}")
    public User findById1(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER-RIBBON/user/" + id, User.class);
    }


}
