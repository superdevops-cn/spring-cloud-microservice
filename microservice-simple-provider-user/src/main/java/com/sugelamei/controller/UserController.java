package com.sugelamei.controller;

import com.sugelamei.entity.User;
import com.sugelamei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description:
 * @author: wxc
 * @create: 2019-11-16 22:08
 **/

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.selectByPrimaryKey(id);
    }


}
