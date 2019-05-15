package com.xiaour.spring.boot.controller;


import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.entity.User;
import com.xiaour.spring.boot.response.BaseResponse;
import com.xiaour.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public String getAllUser() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(userService.queryUser());
        return JSON.toJSONString(baseResponse);
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody String data) {
        data = data.replace("\\","");
        data = data.replace("{\"data\":\"","");
        data = data.substring(0,data.length()-2);
        User user = JSON.parseObject(data, User.class);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(userService.updateUser(user));
        return JSON.toJSONString(baseResponse);
    }

    @PostMapping("/add")
    public String addUser(String data) {
        data = data.replace("\\","");
        data = data.replace("{\"data\":\"","");
        data = data.substring(0,data.length()-2);
        User user = JSON.parseObject(data, User.class);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(userService.addUser(user));
        return JSON.toJSONString(baseResponse);
    }

    @GetMapping("/del")
    public String delUser(Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(userService.delUser(id));
        return JSON.toJSONString(baseResponse);
    }

}
