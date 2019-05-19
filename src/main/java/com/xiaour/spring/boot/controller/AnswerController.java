package com.xiaour.spring.boot.controller;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.request.UpdateAnswer;
import com.xiaour.spring.boot.response.BaseResponse;
import com.xiaour.spring.boot.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/update")
    public String updateAnswer(@RequestBody String data) {
        data = data.replace("\\","");
        data = data.replace("{\"data\":\"","");
        data = data.substring(0,data.length()-2);
        UpdateAnswer updateAnswer = JSON.parseObject(data, UpdateAnswer.class);
        System.out.println(JSON.toJSONString(updateAnswer));
        BaseResponse baseResponse = new BaseResponse();
        if(answerService.updateAnswer(updateAnswer)) {
            baseResponse.setCode(200);
            baseResponse.setMessage("true");
            return baseResponse.toString();
        }
        baseResponse.setCode(1000);
        baseResponse.setMessage("false");
        return baseResponse.toString();
    }

    @GetMapping("/get")
    public String getAnswer(Integer examId, Integer userId) {
        System.out.println(examId+userId);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(answerService.getAnswer(examId, userId));
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        return JSON.toJSONString(baseResponse);
    }

}
