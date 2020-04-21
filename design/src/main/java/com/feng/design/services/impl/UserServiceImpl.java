package com.feng.design.services.impl;

import com.feng.design.mapper.UserMapping;
import com.feng.design.model.User;
import com.feng.design.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapping userMapping;
    @Override
    public User getLogin(User user) {

        return this.userMapping.getLogin(user) ;
    }

    @Override
    public List<User> getUserList(User user) {
        return this.userMapping.getUserList(user);
    }
}
