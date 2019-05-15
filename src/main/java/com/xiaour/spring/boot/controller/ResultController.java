package com.xiaour.spring.boot.controller;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.response.BaseResponse;
import com.xiaour.spring.boot.service.QuestionService;
import com.xiaour.spring.boot.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/get")
    public String getResult(Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(resultService.getResultByUser(id));
        return JSON.toJSONString(baseResponse);
    }

    @GetMapping("/getByExam")
    public String getAllResult(Integer exam) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(resultService.getResultByExam(exam));
        return JSON.toJSONString(baseResponse);
    }
}
