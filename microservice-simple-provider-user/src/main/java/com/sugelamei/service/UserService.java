package com.sugelamei.service;

import com.sugelamei.entity.User;


import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: wxc
 * @create: 2019-11-16 22:09
 **/
public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
