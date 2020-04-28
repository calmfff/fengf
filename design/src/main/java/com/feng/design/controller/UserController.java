package com.feng.design.controller;

import ch.qos.logback.classic.Logger;
import com.feng.design.Enum.IsDeleteEnum;
import com.feng.design.model.ResponseVo;
import com.feng.design.model.User;
import com.feng.design.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

//用户
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVo login(@RequestParam final String username,
                            @RequestParam final String password, HttpSession session) {
        User user = new User();
        ResponseVo responseVo = new ResponseVo();
        user.setLoginName(username);
        user.setPassword(password);
        User loginUser = userService.getLogin(user);
        session.setAttribute(loginUser.getLoginName(), loginUser);

        if (loginUser != null) {
            logger.info("登访问成果" + loginUser.toString());
            responseVo.setCode(200);
            responseVo.setMsg("访问成功");
            loginUser.setToken(loginUser.getLoginName());
            responseVo.setData(loginUser);

        }

        return responseVo;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseVo userInfo(@RequestParam String token, HttpSession session) {
        ResponseVo responseVo = new ResponseVo();
        User user = (User) session.getAttribute(token);
        responseVo.setCode(200);
        responseVo.setMsg("查询成功");
        responseVo.setData(user);
        return responseVo;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseVo logout(@RequestParam String token, HttpSession session) {
        ResponseVo responseVo = new ResponseVo();
        User user = (User) session.getAttribute(token);
        responseVo.setCode(200);
        responseVo.setMsg("查询成功");
        responseVo.setData(user);
        return responseVo;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseVo selectUser(@RequestParam String name) {
        ResponseVo responseVo = new ResponseVo();
        User user = new User();
        if (name != null && !name.equals("")){
            user.setName(name);
        }

        List<User> userList = userService.getUserList(user)
                .stream()
                .map(user1 -> {
                    user1.setIsDelete(IsDeleteEnum.valueOf(user1.getState()).getMsg());
                    return user1;
                }).collect(Collectors.toList());

                ;

        logger.info(String.valueOf(userList));
        responseVo.setCode(200);
        responseVo.setMsg("查询成功");
        responseVo.setData(userList);
        return responseVo;
    }

}
