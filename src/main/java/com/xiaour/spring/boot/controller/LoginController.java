package com.xiaour.spring.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.xiaour.spring.boot.entity.User;
import com.xiaour.spring.boot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @version 1.0
 * @ClassName: UserController
 * @Desc: 用户注册的controller
 * @author: zhouming
 * @date: 2018年8月7日 下午1:43:16
 */

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Object loginUser(User user) {
        Map<String, Object> result = new HashMap<String, Object>();
        System.err.println(user);
        if ("admin".equals(user.getName()) && "123456".equals(user.getPassword())) {
            result.put("code", 200);
            result.put("msg", "admin");
            result.put("token", "adminxxxx");
            return result;
        } else if ("user".equals(user.getName()) && "123".equals(user.getPassword())) {
            result.put("code", 200);
            result.put("msg", "user");
            result.put("token", "userxxxx");
            result.put("id","1");
            return result;
        }
        result.put("code", 500);
        result.put("msg", "登录失败");
        return result;
    }

//    @PostMapping("/submit")
//    public Object submitUser(User user) {
//
//        Map<String, Object> result = new HashMap<String, Object>();
//        if (StringUtils.isBlank(user.getcId())) {
//            user.setcId(UUID.randomUUID().toString().replaceAll("-", ""));
//            userService.save(user);
//        } else {
//            userService.update(user);
//        }
//
//
//        result.put("success", true);
//        result.put("msg", "登录成功");
//        result.put("token", "adminxxxx");
//        return result;
//    }
//
//    @PostMapping("/userlist")
//    public List<User> userList(String filter) {
//        return userService.listUser(filter);
//    }
//
//    @PostMapping("/delete")
//    public Map<String, Object> delete(String userId) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        if (StringUtils.isNotBlank(userId)) {
//            userService.deleteByPrimarykey(userId);
//            result.put("success", true);
//        } else {
//            result.put("success", false);
//        }
//        return result;
//    }


}
