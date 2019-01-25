package com.wang.service.serviceImpl;

import com.wang.dao.UserDao;
import com.wang.domain.User;
import com.wang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
