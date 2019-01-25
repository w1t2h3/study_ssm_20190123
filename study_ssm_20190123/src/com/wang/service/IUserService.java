package com.wang.service;

import com.wang.domain.User;

public interface IUserService {
    //    根据用户名查询用户
    User findUserByName(String username);

    //  增加用户到tuser表
    void addUser(User user);
}
