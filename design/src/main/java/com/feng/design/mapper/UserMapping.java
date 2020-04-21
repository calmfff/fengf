package com.feng.design.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.feng.design.model.User;

import java.util.List;

@Mapper
public interface UserMapping {
    User getLogin(User user);
    List<User> getUserList(User user);
}
