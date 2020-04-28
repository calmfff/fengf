package com.feng.design.services;

import com.feng.design.model.User;

import java.util.List;

public interface UserService {
    User getLogin(User user);
    List<User> getUserList(User user);
    Integer getUserCount(User user);
}
