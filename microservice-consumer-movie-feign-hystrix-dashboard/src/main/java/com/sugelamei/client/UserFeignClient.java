package com.sugelamei.client;

import com.sugelamei.entity.User;
import com.sugelamei.factory.UserFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-provider-user-ribbon",
        fallbackFactory = UserFeignClientFallbackFactory.class)
//@FeignClient(name ="microservice-provider-user-ribbon",configuration = FeignDisableHystrixConfig.class)
public interface UserFeignClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
