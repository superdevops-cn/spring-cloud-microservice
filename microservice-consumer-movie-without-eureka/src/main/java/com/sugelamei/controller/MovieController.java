package com.sugelamei.controller;

import com.sugelamei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
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
    RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://microservice-provider-user-ribbon/user/" + id, User.class);
    }

  public User[] search(String name,Integer age,String dataBase){
      Map<String,Object> map = new HashMap<>();
      map.put("name",name);
      map.put("age",age);
      map.put("dataBase",dataBase);
      return  restTemplate.getForObject("http://microservice-provider-user-ribbon/search?name={name}&age={age}&dataBase={dataBase}",User[].class,map);
  }
}
