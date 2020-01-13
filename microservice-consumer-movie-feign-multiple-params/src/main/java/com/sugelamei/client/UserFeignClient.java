package com.sugelamei.client;

import com.sugelamei.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "microservice-provider-user-multiple-params")
public interface UserFeignClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

    // 该请求不会成功
    @GetMapping("/get")
    User get(User user);

    @GetMapping("/get")
    User get0(@SpringQueryMap User user);

    @GetMapping("/get")
    User get1(@RequestParam("id") Long id, @RequestParam("name") String name);

    @GetMapping("/get")
    User get2(@RequestParam Map<String, Object> map);

    @PostMapping("/post")
    User post(@RequestBody User user);
}
