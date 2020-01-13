package com.sugelamei.client;

import com.sugelamei.entity.User;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("default");
        user.setDataBase("default");

        return user;
    }
}
