package com.sugelamei.controller;

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

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://localhost:8080/user/" + id, User.class);
    }

}
