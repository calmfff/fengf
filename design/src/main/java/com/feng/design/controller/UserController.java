package com.feng.design.controller;

import ch.qos.logback.classic.Logger;
import com.feng.design.model.ResponseVo;
import com.feng.design.model.User;
import com.feng.design.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//用户
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.POST )
    public ResponseVo login(@RequestParam String loginName,
                            @RequestParam String password){
        User user = new User();
        ResponseVo responseVo = new ResponseVo();
        user.setLoginName(loginName);
        user.setPassword(password);
        User loginUser = userService.getLogin(user);

        if (loginUser != null){
            logger.info("登访问成果"+loginUser.toString());
            responseVo.setCode(200);
            responseVo.setMsg("访问成功");
            responseVo.setData(loginUser);
        }

        return responseVo;
    }


    @RequestMapping(value = "/selectUser", method = RequestMethod.POST )
    public ResponseVo selectUser(@RequestParam String name){
        ResponseVo responseVo = new ResponseVo();
        User user = new User();
        user.setName(name);
        List<User> userList = userService.getUserList(user);
        logger.info(String.valueOf(userList));
        responseVo.setCode(200);
        responseVo.setMsg("查询成功");
        responseVo.setData(userList);
        return responseVo;
    }

}
