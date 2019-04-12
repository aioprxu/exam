package com.aiopr.exam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {

    @RequestMapping("/test")
    public String test(){
        return "success";
    }
}
