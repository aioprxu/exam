package com.xiaour.spring.boot.controller;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.entity.Question;
import com.xiaour.spring.boot.response.BaseResponse;
import com.xiaour.spring.boot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public String addQuestion(@RequestBody String data) {
        data = data.replace("\\","");
        data = data.replace("{\"data\":\"","");
        data = data.substring(0,data.length()-2);
        System.out.println(data);
        Question question = JSON.parseObject(data, Question.class);
        BaseResponse baseResponse = new BaseResponse();
        if(questionService.addQuestion(question)) {
            baseResponse.setCode(200);
            baseResponse.setMessage("true");
            return baseResponse.toString();
        } else {
            baseResponse.setCode(1000);
            baseResponse.setMessage("false");
            return baseResponse.toString();
        }
    }

    @GetMapping("/del")
    public String delQuestion(Integer id) {
        System.out.println(id);
        BaseResponse baseResponse = new BaseResponse();
        if(questionService.delQuestion(id)) {
            baseResponse.setCode(200);
            baseResponse.setMessage("true");
            return baseResponse.toString();
        } else {
            baseResponse.setCode(1000);
            baseResponse.setMessage("false");
            return baseResponse.toString();
        }
    }

    @PostMapping("/update")
    public String updateQuestion(@RequestBody String data) {
        data = data.replace("\\","");
        data = data.replace("{\"data\":\"","");
        data = data.substring(0,data.length()-2);
        Question question = JSON.parseObject(data, Question.class);
        BaseResponse baseResponse = new BaseResponse();
        if(questionService.updateQuestion(question)) {
            baseResponse.setCode(200);
            baseResponse.setMessage("true");
            return baseResponse.toString();
        } else {
            baseResponse.setCode(1000);
            baseResponse.setMessage("false");
            return baseResponse.toString();
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public String getQuestion() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(questionService.getQuestion());
        return JSON.toJSONString(baseResponse);
    }

    @GetMapping("/get")
    public String getQuestionById(Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(questionService.getQuestionById(id));
        return JSON.toJSONString(baseResponse);
    }

    @GetMapping("/getByModel")
    public String getQuestionByModel(Integer model) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        System.out.println(model);
        if (model != null) {
            baseResponse.setData(questionService.getQuestionByModel(model));
        } else {
            baseResponse.setData(questionService.getQuestion());
        }
        return JSON.toJSONString(baseResponse);
    }

    @GetMapping("/getByPaper")
    public String getQuestionByPaper(Integer paper) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(questionService.getQuestionByPaper(paper));
        return JSON.toJSONString(baseResponse);
    }

}
