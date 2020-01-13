package com.sugelamei.controller;

import com.google.common.collect.Maps;
import com.sugelamei.client.UserFeignClient;
import com.sugelamei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: springcloud
 * @description:
 * @author: wxc
 * @create: 2019-11-17 00:14
 **/

@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userFeignClient.findById(id);
    }


    /**
     * 测试URL：http://localhost:9081/user/get?id=1&name=张三
     * 该请求不会成功。
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get")
    public User get(User user) {
        return this.userFeignClient.get(user);
    }

    /**
     * 测试URL：http://localhost:9081/user/get0?id=1&name=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get0")
    public User get0(User user) {
        return this.userFeignClient.get0(user);
    }
    /**
     * 测试URL：http://localhost:9081/user/get1?id=1&name=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get1")
    public User get1(User user) {
        return this.userFeignClient.get1(user.getId(), user.getName());
    }

    /**
     * 测试URL：http://localhost:9081/user/get2?id=1&name=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get2")
    public User get2(User user) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", user.getId());
        map.put("name", user.getName());
        return this.userFeignClient.get2(map);
    }

    /**
     * 测试URL:http://localhost:9081/user/post?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/post")
    public User post(User user) {
        return this.userFeignClient.post(user);
    }
}
